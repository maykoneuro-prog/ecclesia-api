package com.example.ecclesiaapi.service;

import com.example.ecclesiaapi.domain.TokenVerificacao;
import com.example.ecclesiaapi.domain.Usuario;
import com.example.ecclesiaapi.repository.TokenVerificacaoRepository;
import com.example.ecclesiaapi.repository.UsuarioRepository;
import com.example.ecclesiaapi.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TokenVerificacaoRepository tokenRepository;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            TokenVerificacaoRepository tokenRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.tokenRepository = tokenRepository;
    }

    /* =====================================================
       ✅ CADASTRO DE USUÁRIO (senha segura com BCrypt)
       ===================================================== */
    public Usuario cadastrar(String nome, String email, String senha) {

        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(PasswordUtil.gerarHash(senha));
        usuario.setPerfil("FILIAL");
        usuario.setEmailVerificado(false);
        usuario.setAprovado(false);

        usuarioRepository.save(usuario);

        TokenVerificacao token = new TokenVerificacao();
        token.setUsuario(usuario);
        token.setToken(UUID.randomUUID().toString());
        token.setCriadoEm(LocalDateTime.now());

        tokenRepository.save(token);

        return usuario;
    }

    /* =====================================================
       🔐 LOGIN (BCrypt correto)
       ===================================================== */
    public Usuario login(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!PasswordUtil.validar(senha, usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        if (!usuario.isEmailVerificado()) {
            throw new RuntimeException("E-mail não verificado");
        }

        if (!usuario.isAprovado()) {
            throw new RuntimeException("Usuário pendente de aprovação");
        }

        return usuario;
    }

    /* =====================================================
       📧 VERIFICAR EMAIL
       ===================================================== */
    public void verificarEmail(String token) {

        TokenVerificacao verificacao = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido"));

        Usuario usuario = verificacao.getUsuario();
        usuario.setEmailVerificado(true);

        usuarioRepository.save(usuario);
        tokenRepository.delete(verificacao);
    }

    /* =====================================================
       ✅ APROVAR USUÁRIO (🚨 ESTE MÉTODO FOI RESTAURADO)
       ===================================================== */
    public void aprovarUsuario(Long id, String perfil) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setAprovado(true);
        usuario.setPerfil(perfil);

        usuarioRepository.save(usuario);
    }

    /* =====================================================
       🛠 ADMINISTRATIVO
       ===================================================== */

    public List<Usuario> listar(String filtro) {
        if (filtro == null || filtro.isBlank()) {
            return usuarioRepository.findAll();
        }

        return usuarioRepository
                .findByNomeContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        filtro, filtro
                );
    }

    public List<Usuario> listarPendentes() {
        return usuarioRepository.findAll()
                .stream()
                .filter(u -> !u.isAprovado())
                .toList();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(Long id, Usuario dados) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setPerfil(dados.getPerfil());
        usuario.setAprovado(dados.isAprovado());

        return usuarioRepository.save(usuario);
    }

    /* =====================================================
       🔁 RESET DE SENHA (BCrypt)
       ===================================================== */
    public void resetarSenha(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setSenha(PasswordUtil.gerarHash("123456"));

        usuarioRepository.save(usuario);
    }
}

package com.example.ecclesiaapi.controller.admin;

import com.example.ecclesiaapi.domain.Pessoa;
import com.example.ecclesiaapi.dto.AprovacaoRequest;
import com.example.ecclesiaapi.service.PessoaService;
import com.example.ecclesiaapi.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/aprovacoes")
public class AdminAprovacaoRestController {

    private final UsuarioService usuarioService;
    private final PessoaService pessoaService;

    public AdminAprovacaoRestController(
            UsuarioService usuarioService,
            PessoaService pessoaService
    ) {
        this.usuarioService = usuarioService;
        this.pessoaService = pessoaService;
    }

    /**
     * Aprova um usuário e cria a Pessoa
     */
    @PostMapping("/{usuarioId}")
    public void aprovarUsuario(
            @PathVariable Long usuarioId,
            @RequestBody AprovacaoRequest request
    ) {

        // 1. Aprova usuário e define perfil técnico
        usuarioService.aprovarUsuario(usuarioId, request.getPerfilUsuario());

        // 2. Cria Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.getNome());
        pessoa.setEmail(request.getEmail());
        pessoa.setTipo(request.getTipoPessoa());
        pessoa.setAtivo(true);

        pessoaService.salvarDireto(pessoa);
    }
}

package com.example.ecclesiaapi.controller.admin;

import com.example.ecclesiaapi.domain.Usuario;
import com.example.ecclesiaapi.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/usuarios")
public class AdminUsuarioController {

    private final UsuarioService usuarioService;

    public AdminUsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // ✅ LISTAR USUÁRIOS (COM OU SEM FILTRO)
    @GetMapping
    public List<Usuario> listar(@RequestParam(required = false) String filtro) {
        return usuarioService.listar(filtro);
    }

    // ✅ LISTAR USUÁRIOS PENDENTES
    @GetMapping("/pendentes")
    public List<Usuario> listarPendentes() {
        return usuarioService.listarPendentes();
    }

    // ✅ BUSCAR USUÁRIO POR ID (NOVO ENDPOINT)
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    // ✅ ATUALIZAR USUÁRIO (PERFIL/APROVAÇÃO)
    @PutMapping("/{id}")
    public Usuario atualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario
    ) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

    // ✅ RESETAR SENHA
    @PostMapping("/{id}/resetar-senha")
    public void resetarSenha(@PathVariable Long id) {
        usuarioService.resetarSenha(id);
    }
}
package agsilvamhm.livrosEEmprestimos.controller;

import agsilvamhm.livrosEEmprestimos.model.Usuario;
import agsilvamhm.livrosEEmprestimos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
}

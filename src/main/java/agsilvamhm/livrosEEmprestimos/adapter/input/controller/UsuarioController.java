package agsilvamhm.livrosEEmprestimos.adapter.input.controller;

import agsilvamhm.livrosEEmprestimos.core.domain.model.Usuario;
import agsilvamhm.livrosEEmprestimos.core.usecase.UsuarioCase;
import agsilvamhm.livrosEEmprestimos.port.input.UsuarioInputPort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioInputPort usuarioInputPort;

  //  public UsuarioController(UsuarioCase usuarioService){
  //      this.usuarioService = usuarioService;
  //  }

    @PostMapping
 //   @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.save(usuario);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoUsuario.getId())
                .toUri();
        return ResponseEntity.created(location).body(novoUsuario);
    }
/*
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuarioParaAtualizar) {
        try {
             Usuario usuarioAtualizado = usuarioService.update(id, usuarioParaAtualizar);
             return ResponseEntity.ok(usuarioAtualizado);
        } catch (EntityNotFoundException e) {
             return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
            usuarioService.deleteById(id);
    }*/
}

package agsilvamhm.livrosEEmprestimos.controller;

import agsilvamhm.livrosEEmprestimos.model.Livro;
import agsilvamhm.livrosEEmprestimos.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/livros")
    public Livro novoLivro(@Valid @RequestBody Livro livro){
        return livroService.save(livro);
    }

}

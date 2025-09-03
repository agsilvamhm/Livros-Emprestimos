package agsilvamhm.livrosEEmprestimos.adapter.input.controller;

import agsilvamhm.livrosEEmprestimos.core.domain.model.Livro;
import agsilvamhm.livrosEEmprestimos.core.usecase.LivroCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    @Autowired
    private LivroCase livroService;

    @PostMapping("/livros")
    public Livro novoLivro(@Valid @RequestBody Livro livro){
        return livroService.save(livro);
    }

}

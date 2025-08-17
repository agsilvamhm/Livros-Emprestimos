package agsilvamhm.livrosEEmprestimos.service;

import agsilvamhm.livrosEEmprestimos.model.Livro;
import agsilvamhm.livrosEEmprestimos.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro save(Livro livro){
        return livroRepository.save((livro));
    }
}

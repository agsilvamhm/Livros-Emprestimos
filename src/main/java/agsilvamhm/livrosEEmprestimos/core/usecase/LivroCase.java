package agsilvamhm.livrosEEmprestimos.core.usecase;

import agsilvamhm.livrosEEmprestimos.core.domain.model.Livro;
import agsilvamhm.livrosEEmprestimos.adapter.output.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroCase {

    @Autowired
    private LivroRepository livroRepository;

    public Livro save(Livro livro){
        return livroRepository.save((livro));
    }
}

package agsilvamhm.livrosEEmprestimos.core.usecase;

import agsilvamhm.livrosEEmprestimos.adapter.input.request.EmprestimoRequestDto;
import agsilvamhm.livrosEEmprestimos.core.domain.model.Emprestimo;
import agsilvamhm.livrosEEmprestimos.core.domain.model.Livro;
import agsilvamhm.livrosEEmprestimos.core.domain.model.Usuario;
import agsilvamhm.livrosEEmprestimos.adapter.output.repository.EmprestimoRepository;
import agsilvamhm.livrosEEmprestimos.adapter.output.repository.LivroRepository;
import agsilvamhm.livrosEEmprestimos.adapter.output.repository.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmprestimoCase {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioEntity usuarioRepository;

    public Emprestimo save(EmprestimoRequestDto dto){
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataDevolucao = dataAtual.plusDays(7);

        Optional<Usuario> usuario = usuarioRepository.findById(dto.getUsuarioId());
        Optional<Livro> livro = livroRepository.findById(dto.getLivroId());
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario.orElse(null));
        emprestimo.setLivro(livro.orElse(null));
        emprestimo.setRetiradoEm(dataAtual);
        emprestimo.setDevolucaoPrevista(dataDevolucao);

        return emprestimoRepository.save(emprestimo);
    }
}

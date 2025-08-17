package agsilvamhm.livrosEEmprestimos.service;

import agsilvamhm.livrosEEmprestimos.dto.request.EmprestimoRequestDto;
import agsilvamhm.livrosEEmprestimos.model.Emprestimo;
import agsilvamhm.livrosEEmprestimos.model.Livro;
import agsilvamhm.livrosEEmprestimos.model.Usuario;
import agsilvamhm.livrosEEmprestimos.repository.EmprestimoRepository;
import agsilvamhm.livrosEEmprestimos.repository.LivroRepository;
import agsilvamhm.livrosEEmprestimos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

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

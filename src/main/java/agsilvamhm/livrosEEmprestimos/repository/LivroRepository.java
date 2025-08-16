package agsilvamhm.livrosEEmprestimos.repository;

import agsilvamhm.livrosEEmprestimos.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

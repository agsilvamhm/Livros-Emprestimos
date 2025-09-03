package agsilvamhm.livrosEEmprestimos.adapter.output.repository;

import agsilvamhm.livrosEEmprestimos.core.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}

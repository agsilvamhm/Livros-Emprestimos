package agsilvamhm.livrosEEmprestimos.adapter.output.repository;

import agsilvamhm.livrosEEmprestimos.core.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}

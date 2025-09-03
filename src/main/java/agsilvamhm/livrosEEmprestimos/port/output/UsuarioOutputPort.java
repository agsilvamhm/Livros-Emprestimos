package agsilvamhm.livrosEEmprestimos.port.output;

import agsilvamhm.livrosEEmprestimos.core.domain.model.Usuario;

public interface UsuarioOutputPort {
    Usuario save(Usuario usuario);
}

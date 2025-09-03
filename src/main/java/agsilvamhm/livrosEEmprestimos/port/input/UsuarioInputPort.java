package agsilvamhm.livrosEEmprestimos.port.input;

import agsilvamhm.livrosEEmprestimos.core.domain.model.Usuario;

public interface UsuarioInputPort {
    Usuario createUsuario(Usuario usuario);
}

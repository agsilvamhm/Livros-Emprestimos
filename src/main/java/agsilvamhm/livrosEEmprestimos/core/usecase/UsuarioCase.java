package agsilvamhm.livrosEEmprestimos.core.usecase;

import agsilvamhm.livrosEEmprestimos.core.domain.model.Usuario;
import agsilvamhm.livrosEEmprestimos.port.input.UsuarioInputPort;
import agsilvamhm.livrosEEmprestimos.port.output.UsuarioOutputPort;

public class UsuarioCase implements UsuarioInputPort {

    private UsuarioOutputPort usuarioOutputPort;

    public Usuario createUsuario(Usuario usuario){
        return usuarioOutputPort.save(usuario);
    }

}

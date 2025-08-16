package agsilvamhm.livrosEEmprestimos.service;

import agsilvamhm.livrosEEmprestimos.model.Usuario;
import agsilvamhm.livrosEEmprestimos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario user){
        return usuarioRepository.save(user);
    }
}

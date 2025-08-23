package agsilvamhm.livrosEEmprestimos.service;

import agsilvamhm.livrosEEmprestimos.model.Usuario;
import agsilvamhm.livrosEEmprestimos.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(Usuario user){
        return usuarioRepository.save(user);
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o id: " + id));
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario update(Long id, Usuario usuarioAtualizado){
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNome(usuarioAtualizado.getNome());
                    usuarioExistente.setEmail(usuarioAtualizado.getEmail());
                    return usuarioRepository.save(usuarioExistente);
                }).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o id: " + id));
    }

    public void deleteById(Long id){
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com o id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}

package agsilvamhm.livrosEEmprestimos.dto.request;

import java.time.LocalDateTime;

public class EmprestimoRequestDto {
    private Long usuarioId;
    private Long livroId;
    private LocalDateTime retiradoEm;
    private LocalDateTime devolucaoPrevista;

    // Crie os getters e setters para todos os campos
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public LocalDateTime getRetiradoEm() {
        return retiradoEm;
    }

    public void setRetiradoEm(LocalDateTime retiradoEm) {
        this.retiradoEm = retiradoEm;
    }

    public LocalDateTime getDevolucaoPrevista() {
        return devolucaoPrevista;
    }

    public void setDevolucaoPrevista(LocalDateTime devolucaoPrevista) {
        this.devolucaoPrevista = devolucaoPrevista;
    }
}

package agsilvamhm.livrosEEmprestimos.core.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O ISBN não pode ser vazio ou nulo.")
    @Column(name = "isbn", unique = true, nullable = false, length = 20)
    private String isbn;
    @NotBlank(message = "O título não pode ser vazio ou nulo.")
    private String titulo;
    @NotBlank(message = "O autor não pode ser vazio ou nulo.")
    private String autor;
    @NotNull(message = "O estoque não pode ser nulo.")
    @Min(value = 0, message = "O estoque não pode ser negativo.")
    private Integer estoque;
    @NotNull
    private Boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

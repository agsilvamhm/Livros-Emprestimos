package agsilvamhm.livrosEEmprestimos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode ser vazio ou nulo.")
    @Size(max = 60, message = "O nome não pode ter mais de 60 caracteres.")
    private String nome;
    @NotBlank(message = "O e-mail não pode ser vazio ou nulo.")
    @Email(message = "Formato de e-mail inválido.")
    @Size(max = 254, message = "O e-mail não pode ter mais de 254 caracteres.")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

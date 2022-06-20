package br.com.casadocodigo.deveficiente.novoautor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true) @Email
    private String email;
    @Column(nullable = false) @Size(max = 400)
    private String descricao;
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    public Author(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

}

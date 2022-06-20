package br.com.casadocodigo.deveficiente.novoautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AuthorRequest(@NotBlank String nome,
                            @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String descricao
                               ) {
    public Author toModel() {
        return new Author(this.nome, this.email, this.descricao);
    }
}

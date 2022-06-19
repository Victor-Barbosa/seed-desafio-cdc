package br.com.casadocodigo.deveficiente.novoautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AutorRequest(@NotBlank String nome,
                           @NotBlank @Email String email,
                           @NotBlank @Size(max = 400) String descricao
                               ) {
    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}

package br.com.casadocodigo.deveficiente.novoautor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public record AutoresController(AutorRepository autorRepository) {

    @PostMapping("/autores")
    public String save(@RequestBody @Valid AutorRequest request){
        Autor autor = request.toModel();
        autorRepository.save(autor);
        return autor.toString();
    }
}

package br.com.casadocodigo.deveficiente.novoautor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public record AuthorController(AuthorService authorService) {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody @Valid AuthorRequest request) {
        return authorService.save(request);
    }
}
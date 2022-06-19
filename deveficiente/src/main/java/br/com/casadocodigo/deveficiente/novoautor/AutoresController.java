package br.com.casadocodigo.deveficiente.novoautor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public record AutoresController(AutorRepository autorRepository) {

    @PostMapping("/autores")
    public ResponseEntity<String> save(@RequestBody @Valid AutorRequest request){
        emailExists(request);
        var autor = request.toModel();
        autorRepository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Autor(a) Cadastrado");
    }

    private void emailExists(AutorRequest request) {
        if (autorRepository.existsByEmail(request.email())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe autor(a) com esse email Cadastrado!");
        }
    }
}

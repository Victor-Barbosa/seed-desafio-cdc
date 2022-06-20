package br.com.casadocodigo.deveficiente.novoautor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public record AuthorService(AuthorRepository authorRepository) {

    public Author save(AuthorRequest request) {
        log.info("Save {},", request);
        emailExists(request);
        log.info("Email already exists!");
        var author = request.toModel();
        return authorRepository.save(author);

    }

    private void emailExists(AuthorRequest request) {
        if (authorRepository.existsByEmail(request.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "J\n" +
                    "There is already an author with this email Registered!");
        }
    }
}

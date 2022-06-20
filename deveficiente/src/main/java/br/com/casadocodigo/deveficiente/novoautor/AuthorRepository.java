package br.com.casadocodigo.deveficiente.novoautor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByEmail(String email);

}
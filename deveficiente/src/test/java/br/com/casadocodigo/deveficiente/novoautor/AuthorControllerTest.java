package br.com.casadocodigo.deveficiente.novoautor;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

    @MockBean
    private AuthorService authorService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldSaveAuthor() throws Exception {
        var authorRequest = new AuthorRequest("joao", "joao@email.com", "Joao é legal!");
        var authorResponse = new Author(1L, authorRequest.nome(), authorRequest.email(), authorRequest.descricao(), LocalDateTime.now());
        BDDMockito.given(authorService.save(authorRequest)).willReturn(authorResponse);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/autores")
                        .content(new Gson().toJson(authorRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(new Gson().toJson(authorResponse)));
    }

    @Test
    void autorService() {
    }
}
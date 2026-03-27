package koala.kommunity;

import koala.kommunity.DTOs.User.EnumUserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void shouldCreateUserSuccessfully() throws Exception {
        String json = "{\"name\": \"John Doe\", \"email\": \"john@example.com\", \"password\": \"password123\", \"role\": \"USER\"}";

        mockMvc.perform(post("/users/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk());
    }

    @Test
    void shouldReturnBadRequestWhenNameIsMissing() throws Exception {
        String invalidJson = "{\"email\": \"test@example.com\", \"password\": \"pass123\", \"role\": \"USER\"}";

        mockMvc.perform(post("/users/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidJson))
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestWhenEmailIsMissing() throws Exception {
        String invalidJson = "{\"name\": \"John\", \"password\": \"pass123\", \"role\": \"USER\"}";

        mockMvc.perform(post("/users/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidJson))
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestWhenPasswordIsMissing() throws Exception {
        String invalidJson = "{\"name\": \"John\", \"email\": \"test@example.com\", \"role\": \"USER\"}";

        mockMvc.perform(post("/users/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidJson))
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestWhenEmailIsInvalid() throws Exception {
        String invalidJson = "{\"name\": \"John\", \"email\": \"not-an-email\", \"password\": \"pass123\", \"role\": \"USER\"}";

        mockMvc.perform(post("/users/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidJson))
            .andExpect(status().isBadRequest());
    }
}

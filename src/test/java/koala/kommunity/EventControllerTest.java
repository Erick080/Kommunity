package koala.kommunity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EventControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void shouldCreateEventSuccessfully() throws Exception {
        String json = "{\"name\": \"Tech Conference\", \"date\": \"2026-05-15T10:30:00\", \"place\": \"Convention Center\", \"description\": \"A conference about new technologies\"}";

        mockMvc.perform(post("/events/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Tech Conference"))
            .andExpect(jsonPath("$.place").value("Convention Center"));
    }

    @Test
    void shouldCreateEventWithoutDescriptionAndUseDefault() throws Exception {
        String json = "{\"name\": \"Workshop\", \"date\": \"2026-05-15T10:30:00\", \"place\": \"Lab Room\"}";

        mockMvc.perform(post("/events/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Workshop"))
            .andExpect(jsonPath("$.description").value("sem descrição"));
    }

    @Test
    void shouldReturnBadRequestWhenNameIsMissing() throws Exception {
        String invalidJson = "{\"date\": \"2026-05-15T10:30:00\", \"place\": \"Convention Center\"}";

        mockMvc.perform(post("/events/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.errors.name").exists());
    }

    @Test
    void shouldReturnBadRequestWhenDateIsMissing() throws Exception {
        String invalidJson = "{\"name\": \"Tech Conference\", \"place\": \"Convention Center\"}";

        mockMvc.perform(post("/events/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.errors.date").exists());
    }

    @Test
    void shouldReturnBadRequestWhenPlaceIsMissing() throws Exception {
        String invalidJson = "{\"name\": \"Tech Conference\", \"date\": \"2026-05-15T10:30:00\"}";

        mockMvc.perform(post("/events/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.errors.place").exists());
    }

    @Test
    void shouldSearchEventByName() throws Exception {
        String createEventJson = "{\"name\": \"Tech Summit 2026\", \"date\": \"2026-06-20T14:30:00\", \"place\": \"Main Hall\", \"description\": \"Annual technology summit\"}";
        mockMvc.perform(post("/events/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(createEventJson))
            .andExpect(status().isOk());

        mockMvc.perform(get("/events/search")
            .param("name", "Tech Summit 2026"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Tech Summit 2026"))
            .andExpect(jsonPath("$.date").value("2026-06-20T14:30:00"))
            .andExpect(jsonPath("$.place").value("Main Hall"))
            .andExpect(jsonPath("$.description").value("Annual technology summit"));
    }

    @Test
    void shouldReturnEventWithAllAttributesWhenSearchByName() throws Exception {
        mockMvc.perform(get("/events/search")
            .param("name", "EventThatDoesNotExist"))
            .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnBadRequestWhenAllFieldsAreMissing() throws Exception {
        String invalidJson = "{}";

        mockMvc.perform(post("/events/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(invalidJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.errors.name").exists())
            .andExpect(jsonPath("$.errors.date").exists())
            .andExpect(jsonPath("$.errors.place").exists());
    }
}

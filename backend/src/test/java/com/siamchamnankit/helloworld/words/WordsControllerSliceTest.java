package com.siamchamnankit.helloworld.words;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordsController.class)
public class WordsControllerSliceTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    WorldClient worldClient;

    @Test
    public void when_external_world_client_was_WORLD_it_should_be_Hello_WORLD() throws Exception {
        when(worldClient.get("World")).thenReturn(new WorldClientResponse("WORLD"));
        mvc.perform(get("/api/v1/words/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("value").value("Hello WORLD !"));

    }

}
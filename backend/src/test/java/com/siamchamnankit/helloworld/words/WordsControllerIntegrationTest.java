package com.siamchamnankit.helloworld.words;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WordsControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    WorldClient worldClient;

    @Test
    public void when_we_get_first_word_it_should_be_HelloWorld (){
        when(worldClient.get(any())).thenReturn(new WorldClientResponse("World"));

        WordResponse word = restTemplate.getForObject("/api/v1/words/1", WordResponse.class);
        assertEquals(1, word.getId());
        assertEquals("Hello World !", word.getValue());
    }
}

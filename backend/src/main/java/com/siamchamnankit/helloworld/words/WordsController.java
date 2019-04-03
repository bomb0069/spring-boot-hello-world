package com.siamchamnankit.helloworld.words;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {

    @GetMapping("/api/v1/words/{id}")
    public WordResponse getWord(@PathVariable int id) {
        return new WordResponse(id, "Hello World !");
    }
}

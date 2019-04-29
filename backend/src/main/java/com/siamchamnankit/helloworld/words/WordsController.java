package com.siamchamnankit.helloworld.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {

    @Autowired
    WorldClient worldClient;

    @GetMapping("/api/v1/words/{id}")
    public WordResponse getWord(@PathVariable int id) {
        return new WordResponse(id, "Hello " + worldClient.get("World").getWorld() + " !");
    }
}

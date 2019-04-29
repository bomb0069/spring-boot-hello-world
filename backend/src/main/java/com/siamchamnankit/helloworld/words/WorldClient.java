package com.siamchamnankit.helloworld.words;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "world-client", url = "http://localhost:9090/world")
public interface WorldClient {

    @GetMapping("/{world}")
    WorldClientResponse get(@PathVariable String world);

}

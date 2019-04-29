package com.siamchamnankit.helloworld.words;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorldClientResponse {
    private String world;

    public WorldClientResponse(@JsonProperty("world") String world) {

        this.world = world;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }
}

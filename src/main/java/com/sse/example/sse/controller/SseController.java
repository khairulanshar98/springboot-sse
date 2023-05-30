package com.sse.example.sse.controller;

import com.sse.example.sse.entity.Dummy;
import com.sse.example.sse.service.implementation.DummyPublisher;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/sse")
@Tag(name = "sse", description = "API sse subscribe and publish")
public class SseController {
    @Autowired
    DummyPublisher dummyPublisher;

    @CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")
    @GetMapping(value = "/subscribe/{topic}", consumes = MediaType.ALL_VALUE)
    public Publisher<Dummy> subscribe(@PathVariable String topic) {
        try {
            return this.dummyPublisher.getDummyPublisher(topic);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


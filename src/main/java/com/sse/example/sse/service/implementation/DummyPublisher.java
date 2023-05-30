package com.sse.example.sse.service.implementation;

import com.sse.example.sse.entity.Dummy;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

import java.io.IOException;

@Component
public class DummyPublisher {
    private final FluxProcessor<Dummy, Dummy> processor;
    private final FluxSink<Dummy> sink;
    private final SseEmitter sse;
    public DummyPublisher() {
        this.processor = DirectProcessor.<Dummy>create().serialize();
        this.sink = this.processor.sink();
        sse = new SseEmitter();
    }

    public void publish(Dummy dummy) throws IOException {
        this.sse.send(SseEmitter.event().name("init").data(dummy));
        this.sink.next(dummy);
    }

    public Publisher<Dummy> getDummyPublisher(String topic) throws IOException {
        this.sse.send(SseEmitter.event().name("init"));
        return processor.filter(dummy -> dummy.getTopic().equalsIgnoreCase(topic));
    }
}

package com.sse.example.sse.service;

import com.sse.example.sse.config.exception.RecordNotCreatedException;
import com.sse.example.sse.config.exception.RecordNotFoundException;
import com.sse.example.sse.config.exception.RecordNotUpdatedException;
import com.sse.example.sse.entity.Dummy;

import java.util.List;

public interface DummyService {
    List<Dummy> getAll() throws RecordNotFoundException;

    Dummy create(Dummy dummy) throws RecordNotCreatedException;

    Dummy update(Dummy dummy) throws RecordNotUpdatedException;

    List<Dummy> getByHello(String hello) throws RecordNotFoundException;

    List<Dummy> getByTopic(String topic) throws RecordNotFoundException;
}

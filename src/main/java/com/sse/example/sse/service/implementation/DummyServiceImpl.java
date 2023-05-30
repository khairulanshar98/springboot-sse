package com.sse.example.sse.service.implementation;

import com.sse.example.sse.config.exception.RecordNotCreatedException;
import com.sse.example.sse.config.exception.RecordNotFoundException;
import com.sse.example.sse.config.exception.RecordNotUpdatedException;
import com.sse.example.sse.entity.Dummy;
import com.sse.example.sse.repository.DummyRepository;
import com.sse.example.sse.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    @Autowired
    DummyPublisher dummyPublisher;

    @Override
    public List<Dummy> getAll() throws RecordNotFoundException {
        try {
            return this.dummyRepository.findAll();
        } catch (NoSuchElementException e) {
            throw new RecordNotFoundException("Not found", e);
        }
    }

    @Override
    public Dummy create(Dummy dummy) throws RecordNotCreatedException {
        try {
            if (!this.dummyRepository.existsById(dummy.getId())) {
                Dummy newRecord=this.dummyRepository.save(dummy);
                this.dummyPublisher.publish(newRecord);
                return newRecord;
            } else {
                throw new RecordNotCreatedException("Duplicate Id.");
            }
        } catch (DataAccessException e) {
            throw new RecordNotCreatedException("Record not created.", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dummy update(Dummy dummy) throws RecordNotUpdatedException {
        try {
            return this.dummyRepository.save(dummy);
        } catch (DataAccessException e) {
            throw new RecordNotUpdatedException("Record not created.", e);
        }
    }

    @Override
    public List<Dummy> getByHello(String hello) throws RecordNotFoundException {
        try {
            return this.dummyRepository.findByHello(hello);
        } catch (NoSuchElementException e) {
            throw new RecordNotFoundException("Not found", e);
        }
    }

    @Override
    public List<Dummy> getByTopic(String topic) throws RecordNotFoundException {
        try {
            return this.dummyRepository.findByTopic(topic);
        } catch (NoSuchElementException e) {
            throw new RecordNotFoundException("Not found", e);
        }
    }
}

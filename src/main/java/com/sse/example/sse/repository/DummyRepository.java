package com.sse.example.sse.repository;

import com.sse.example.sse.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DummyRepository extends JpaRepository<Dummy, Long> {

    List<Dummy> findByHello(String hello);

    List<Dummy> findByTopic(String topic);
}

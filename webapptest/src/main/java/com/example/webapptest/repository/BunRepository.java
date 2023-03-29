package com.example.webapptest.repository;

import com.example.webapptest.model.Bun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BunRepository extends CrudRepository<Bun, Long> {
    Bun findByBun(String bun);
}

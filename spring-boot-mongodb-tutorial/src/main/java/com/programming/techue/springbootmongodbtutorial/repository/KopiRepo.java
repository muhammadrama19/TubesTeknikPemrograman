package com.programming.techue.springbootmongodbtutorial.repository;

import com.programming.techue.springbootmongodbtutorial.model.Kopi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface KopiRepo extends MongoRepository<Kopi, String> {
    @Query("{'name': ?0}")
    List<Kopi> findByName(String name);
}
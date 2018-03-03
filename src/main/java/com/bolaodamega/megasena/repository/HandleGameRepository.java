package com.bolaodamega.megasena.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bolaodamega.megasena.domain.HandleGame;

@Repository
public interface HandleGameRepository extends MongoRepository<HandleGame, String> {

}
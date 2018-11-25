package com.bolaodamega.megasena.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import com.bolaodamega.megasena.domain.Game;

@NoRepositoryBean
public interface DeleteGameRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {

	@Query(value = "{number01: :#{#game.number01}, number02: :#{#game.number02}, number03: :#{#game.number03}, number04: :#{#game.number04}, number05: :#{#game.number05}, number06: :#{#game.number06}}", delete = true)
	void deleteNumber(@Param("game") Game game);
}
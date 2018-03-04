package com.bolaodamega.megasena.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolaodamega.megasena.domain.MineGame;

@Repository
public interface MineGameRepository extends DeleteGameRepository<MineGame, String> {

	@Transactional(readOnly = true)
	Slice<MineGame> findAllBy(Pageable page);

	@Query(value = "{number01: {$gte: :#{#game.number01}}, number02: {$gte: :#{#game.number02}}, number03: {$gte: :#{#game.number03}}, number04: {$gte: :#{#game.number04}}, number05: {$gte: :#{#game.number05}}, number06: {$gte: :#{#game.number06}}}")
	Page<MineGame> findAll(@Param("game") MineGame mineGame, Pageable pageable);

}
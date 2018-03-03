package com.bolaodamega.megasena.repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolaodamega.megasena.domain.RaffledGame;

@Repository
public interface RaffledGameRepository extends MongoRepository<RaffledGame, String> {

	@Transactional(readOnly = true)
    Slice<RaffledGame> findAllBy(Pageable page);

	RaffledGame findTopByOrderByTenderNumberDesc();

	RaffledGame findByTenderNumber(Integer tenderNumber);
}
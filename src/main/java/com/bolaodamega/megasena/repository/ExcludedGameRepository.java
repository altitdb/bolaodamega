package com.bolaodamega.megasena.repository;
import org.springframework.stereotype.Repository;

import com.bolaodamega.megasena.domain.ExcludedGame;

@Repository
public interface ExcludedGameRepository extends DeleteGameRepository<ExcludedGame, String> {

}
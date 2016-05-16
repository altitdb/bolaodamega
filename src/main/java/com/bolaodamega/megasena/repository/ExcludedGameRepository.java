package com.bolaodamega.megasena.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolaodamega.megasena.domain.ExcludedGame;
import com.bolaodamega.megasena.domain.GamePK;

@Repository
public interface ExcludedGameRepository extends JpaRepository<ExcludedGame, GamePK> {

}
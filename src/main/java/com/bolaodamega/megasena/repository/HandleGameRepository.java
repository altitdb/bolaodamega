package com.bolaodamega.megasena.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolaodamega.megasena.domain.GamePK;
import com.bolaodamega.megasena.domain.HandleGame;

@Repository
public interface HandleGameRepository extends JpaRepository<HandleGame, GamePK> {

}
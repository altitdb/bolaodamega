package com.bolaodamega.megasena.repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolaodamega.megasena.domain.GamePK;
import com.bolaodamega.megasena.domain.MineGame;

@Repository
public interface MineGameRepository extends JpaRepository<MineGame, GamePK> {

    @Transactional(readOnly = true)
    Slice<MineGame> findAllBy(Pageable page);
	
}
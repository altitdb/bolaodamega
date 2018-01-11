package com.bolaodamega.megasena.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Path;

import org.springframework.data.jpa.domain.Specification;

import com.bolaodamega.megasena.domain.GamePK;
import com.bolaodamega.megasena.domain.MineGame;
import com.bolaodamega.megasena.dto.NextGameDTO;

public class MineGameSpecifications {

	public static Specification<MineGame> nextGames(NextGameDTO nextGame) {

		return new Specification<MineGame>() {
			public Predicate toPredicate(Root<MineGame> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();

				Path<GamePK> paramGamePk = root.get("gamePk");
				
				Path<Integer> paramNumber01 = paramGamePk.get("number01");
				query.orderBy(cb.asc(paramNumber01));
				Predicate precidateNumber01 = cb.greaterThanOrEqualTo(paramNumber01, nextGame.getNumber01());
				predicates.add(precidateNumber01);
				
				Path<Integer> paramNumber02 = paramGamePk.get("number02");
				query.orderBy(cb.asc(paramNumber02));
				Predicate precidateNumber02 = cb.greaterThanOrEqualTo(paramNumber02, nextGame.getNumber02());
				predicates.add(precidateNumber02);
				
				Path<Integer> paramNumber03 = paramGamePk.get("number03");
				query.orderBy(cb.asc(paramNumber03));
				Predicate precidateNumber03 = cb.greaterThanOrEqualTo(paramNumber03, nextGame.getNumber03());
				predicates.add(precidateNumber03);
				
				Path<Integer> paramNumber04 = paramGamePk.get("number04");
				query.orderBy(cb.asc(paramNumber04));
				Predicate precidateNumber04 = cb.greaterThanOrEqualTo(paramNumber04, nextGame.getNumber04());
				predicates.add(precidateNumber04);
				
				Path<Integer> paramNumber05 = paramGamePk.get("number05");
				query.orderBy(cb.asc(paramNumber05));
				Predicate precidateNumber05 = cb.greaterThanOrEqualTo(paramNumber05, nextGame.getNumber05());
				predicates.add(precidateNumber05);
				
				Path<Integer> paramNumber06 = paramGamePk.get("number06");
				query.orderBy(cb.asc(paramNumber06));
				Predicate precidateNumber06 = cb.greaterThanOrEqualTo(paramNumber06, nextGame.getNumber06());
				predicates.add(precidateNumber06);
				
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}

		};
	}
}

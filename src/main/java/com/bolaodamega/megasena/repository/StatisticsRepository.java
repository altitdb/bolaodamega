package com.bolaodamega.megasena.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bolaodamega.megasena.domain.Statistics;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics, Integer> {

}
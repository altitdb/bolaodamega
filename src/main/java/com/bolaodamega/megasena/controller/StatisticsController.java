package com.bolaodamega.megasena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolaodamega.megasena.dto.StatisticsDTO;
import com.bolaodamega.megasena.service.StatisticsServiceBean;

@RestController
public class StatisticsController {

	@Autowired
	private StatisticsServiceBean statisticsBean;
	
	@RequestMapping("/api/v1/statistics")
	public List<StatisticsDTO> getStatistics() {
		return statisticsBean.findAll();
	}
}

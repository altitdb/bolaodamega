package com.bolaodamega.megasena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolaodamega.megasena.dto.RaffledDTO;
import com.bolaodamega.megasena.service.RaffledGameServiceBean;

@RestController
public class RaffledController {

	@Autowired
	private RaffledGameServiceBean raffledGameServiceBean;
	
	@RequestMapping(value = "/api/v1/raffled/last")
	public RaffledDTO getLastRaffled() {
		return raffledGameServiceBean.getLast();
	}
	
	@RequestMapping(value = "/api/v1/raffled/next/{tenderNumber}")
	public RaffledDTO getNextRaffled(@PathVariable("tenderNumber") Integer tenderNumber) {
		return raffledGameServiceBean.getNext(tenderNumber);
	}
	
	@RequestMapping(value = "/api/v1/raffled/previous/{tenderNumber}")
	public RaffledDTO getPreviousRaffled(@PathVariable("tenderNumber") Integer tenderNumber) {
		return raffledGameServiceBean.getPrevious(tenderNumber);
	}
}

package com.bolaodamega.megasena.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RaffledGame")
@TypeAlias("RaffledGame")
public class RaffledGame extends Game {

	private Integer tenderNumber;
	private String city;
	private String state;
	private String accumulated;
	private BigDecimal accumulatedValue;
	private BigDecimal accumulatedTurning;
	private BigDecimal taxRevenuesTotal;
	private Date tenderDate;
	private BigDecimal estimatedPrize;
	private Integer winnersFourth;
	private Integer winnersFifth;
	private Integer winnersSixth;
	private BigDecimal valueFourth;
	private BigDecimal valueFifth;
	private BigDecimal valuesSixth;

	public Boolean getAccumulated() {
		return "SIM".equals(accumulated);
	}

	public Integer getTenderNumber() {
		return tenderNumber;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public BigDecimal getAccumulatedValue() {
		return accumulatedValue;
	}

	public BigDecimal getAccumulatedTurning() {
		return accumulatedTurning;
	}

	public BigDecimal getTaxRevenuesTotal() {
		return taxRevenuesTotal;
	}

	public Date getTenderDate() {
		return tenderDate;
	}

	public BigDecimal getEstimatedPrize() {
		return estimatedPrize;
	}

	public Integer getWinnersFourth() {
		return winnersFourth;
	}

	public Integer getWinnersFifth() {
		return winnersFifth;
	}

	public Integer getWinnersSixth() {
		return winnersSixth;
	}

	public BigDecimal getValueFourth() {
		return valueFourth;
	}

	public BigDecimal getValueFifth() {
		return valueFifth;
	}

	public BigDecimal getValuesSixth() {
		return valuesSixth;
	}

	public void setTenderNumber(Integer tenderNumber) {
		this.tenderNumber = tenderNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setAccumulated(String accumulated) {
		this.accumulated = accumulated;
	}

	public void setAccumulatedValue(BigDecimal accumulatedValue) {
		this.accumulatedValue = accumulatedValue;
	}

	public void setAccumulatedTurning(BigDecimal accumulatedTurning) {
		this.accumulatedTurning = accumulatedTurning;
	}

	public void setTaxRevenuesTotal(BigDecimal taxRevenuesTotal) {
		this.taxRevenuesTotal = taxRevenuesTotal;
	}

	public void setTenderDate(Date tenderDate) {
		this.tenderDate = tenderDate;
	}

	public void setEstimatedPrize(BigDecimal estimatedPrize) {
		this.estimatedPrize = estimatedPrize;
	}

	public void setWinnersFourth(Integer winnersFourth) {
		this.winnersFourth = winnersFourth;
	}

	public void setWinnersFifth(Integer winnersFifth) {
		this.winnersFifth = winnersFifth;
	}

	public void setWinnersSixth(Integer winnersSixth) {
		this.winnersSixth = winnersSixth;
	}

	public void setValueFourth(BigDecimal valueFourth) {
		this.valueFourth = valueFourth;
	}

	public void setValueFifth(BigDecimal valueFifth) {
		this.valueFifth = valueFifth;
	}

	public void setValuesSixth(BigDecimal valuesSixth) {
		this.valuesSixth = valuesSixth;
	}

	public Game getGame() {
		List<Integer> numbers = this.getNumbers();
		Collections.sort(numbers);
		super.setNumber01(numbers.get(0));
		super.setNumber02(numbers.get(1));
		super.setNumber03(numbers.get(2));
		super.setNumber04(numbers.get(3));
		super.setNumber05(numbers.get(4));
		super.setNumber06(numbers.get(5));
        return this;
    }

}

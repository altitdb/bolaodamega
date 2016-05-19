package com.bolaodamega.megasena.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "RAFFLED_GAME")
public class RaffledGame extends Game {

	@Column(name = "TENDER_NUMBER")
	private Integer tenderNumber;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String accumulated;
	@Column(name = "ACCUMULATED_VALUE")
	private BigDecimal accumulatedValue;
	@Column(name = "ACCUMULATED_TURNING")
	private BigDecimal accumulatedTurning;
	@Column(name = "TAX_REVENUES_TOTAL")
	private BigDecimal taxRevenuesTotal;
	@Temporal(TemporalType.DATE)
	@Column(name = "TENDER_DATE")
	private Date tenderDate;
	@Column(name = "ESTIMATED_PRIZE")
	private BigDecimal estimatedPrize;
	@Column(name = "WINNERS_FOURTH")
	private Integer winnersFourth;
	@Column(name = "WINNERS_FIFTH")
	private Integer winnersFifth;
	@Column(name = "WINNERS_SIXTH")
	private Integer winnersSixth;
	@Column(name = "VALUE_FOURTH")
	private BigDecimal valueFourth;
	@Column(name = "VALUE_FIFTH")
	private BigDecimal valueFifth;
	@Column(name = "VALUE_SIXTH")
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

}

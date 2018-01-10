package com.bolaodamega.megasena.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameBaseDTO {

	private Integer number01;
	private Integer number02;
	private Integer number03;
	private Integer number04;
	private Integer number05;
	private Integer number06;

	public Integer getNumber01() {
		order();
		return number01;
	}

	public void setNumber01(Integer number01) {
		this.number01 = number01;
	}

	public Integer getNumber02() {
		order();
		return number02;
	}

	public void setNumber02(Integer number02) {
		this.number02 = number02;
	}

	public Integer getNumber03() {
		order();
		return number03;
	}

	public void setNumber03(Integer number03) {
		this.number03 = number03;
	}

	public Integer getNumber04() {
		order();
		return number04;
	}

	public void setNumber04(Integer number04) {
		this.number04 = number04;
	}

	public Integer getNumber05() {
		order();
		return number05;
	}

	public void setNumber05(Integer number05) {
		this.number05 = number05;
	}

	public Integer getNumber06() {
		order();
		return number06;
	}

	public void setNumber06(Integer number06) {
		this.number06 = number06;
	}
	
	private void order() {
		List<Integer> numbers = Arrays.asList(number01, number02, number03, number04, number05, number06);
		Collections.sort(numbers);
		this.number01 = numbers.get(0);
		this.number02 = numbers.get(1);
		this.number03 = numbers.get(2);
		this.number04 = numbers.get(3);
		this.number05 = numbers.get(4);
		this.number06 = numbers.get(5);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GameBaseDTO [number01=");
		builder.append(number01);
		builder.append(", number02=");
		builder.append(number02);
		builder.append(", number03=");
		builder.append(number03);
		builder.append(", number04=");
		builder.append(number04);
		builder.append(", number05=");
		builder.append(number05);
		builder.append(", number06=");
		builder.append(number06);
		builder.append("]");
		return builder.toString();
	}

}

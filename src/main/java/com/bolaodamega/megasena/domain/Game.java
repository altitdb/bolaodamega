package com.bolaodamega.megasena.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Game {

	@Id
	private String id;
	private Integer number01;
	private Integer number02;
	private Integer number03;
	private Integer number04;
	private Integer number05;
	private Integer number06;

	public String getId() {
		return id;
	}

	public Integer getNumber01() {
		return number01;
	}

	public void setNumber01(Integer number01) {
		this.number01 = number01;
	}

	public Integer getNumber02() {
		return number02;
	}

	public void setNumber02(Integer number02) {
		this.number02 = number02;
	}

	public Integer getNumber03() {
		return number03;
	}

	public void setNumber03(Integer number03) {
		this.number03 = number03;
	}

	public Integer getNumber04() {
		return number04;
	}

	public void setNumber04(Integer number04) {
		this.number04 = number04;
	}

	public Integer getNumber05() {
		return number05;
	}

	public void setNumber05(Integer number05) {
		this.number05 = number05;
	}

	public Integer getNumber06() {
		return number06;
	}

	public void setNumber06(Integer number06) {
		this.number06 = number06;
	}

	public List<Integer> getNumbers() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(this.getNumber01());
		numbers.add(this.getNumber02());
		numbers.add(this.getNumber03());
		numbers.add(this.getNumber04());
		numbers.add(this.getNumber05());
		numbers.add(this.getNumber06());
		return numbers;
	}
	
	
	public String query() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("number01: '");
		sb.append(number01);
		sb.append("', ");
		sb.append("number02: '");
		sb.append(number02);
		sb.append("', ");
		sb.append("number03: '");
		sb.append(number03);
		sb.append("', ");
		sb.append("number04: '");
		sb.append(number04);
		sb.append("', ");
		sb.append("number05: '");
		sb.append(number05);
		sb.append("', ");
		sb.append("number06: '");
		sb.append(number06);
		sb.append("'}");
		return String.valueOf(sb);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GAME [");
		sb.append(this.getNumber01());
		sb.append(", ");
		sb.append(this.getNumber02());
		sb.append(", ");
		sb.append(this.getNumber03());
		sb.append(", ");
		sb.append(this.getNumber04());
		sb.append(", ");
		sb.append(this.getNumber05());
		sb.append(", ");
		sb.append(this.getNumber06());
		sb.append("]");
		return sb.toString();
	}

}

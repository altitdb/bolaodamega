package com.bolaodamega.megasena.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Game {

    @EmbeddedId
    private GamePK gamePk = new GamePK();
    
    public void setGamePk(GamePK gamePk) {
        this.gamePk = gamePk;
    }

    public GamePK getGamePk() {
        return gamePk;
    }

    public Integer getNumber01() {
        return gamePk.getNumber01();
    }

    public void setNumber01(Integer number01) {
        this.gamePk.setNumber01(number01);
    }

    public Integer getNumber02() {
        return gamePk.getNumber02();
    }

    public void setNumber02(Integer number02) {
        this.gamePk.setNumber02(number02);
    }

    public Integer getNumber03() {
        return gamePk.getNumber03();
    }

    public void setNumber03(Integer number03) {
        this.gamePk.setNumber03(number03);
    }

    public Integer getNumber04() {
        return gamePk.getNumber04();
    }

    public void setNumber04(Integer number04) {
        this.gamePk.setNumber04(number04);
    }

    public Integer getNumber05() {
        return gamePk.getNumber05();
    }

    public void setNumber05(Integer number05) {
        this.gamePk.setNumber05(number05);
    }

    public Integer getNumber06() {
        return gamePk.getNumber06();
    }

    public void setNumber06(Integer number06) {
        this.gamePk.setNumber06(number06);
    }

	public List<Integer> getNumbers() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(getNumber01());
		numbers.add(getNumber02());
		numbers.add(getNumber03());
		numbers.add(getNumber04());
		numbers.add(getNumber05());
		numbers.add(getNumber06());
		return numbers;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GAME [");
        sb.append(gamePk.getNumber01());
        sb.append(", ");
        sb.append(gamePk.getNumber02());
        sb.append(", ");
        sb.append(gamePk.getNumber03());
        sb.append(", ");
        sb.append(gamePk.getNumber04());
        sb.append(", ");
        sb.append(gamePk.getNumber05());
        sb.append(", ");
        sb.append(gamePk.getNumber06());
        sb.append("]");
        return sb.toString();
    }

    
}

package com.bolaodamega.megasena.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GamePK implements Serializable {

    private static final long serialVersionUID = 23L;
    @Column
    private Integer number01;
    @Column
    private Integer number02;
    @Column
    private Integer number03;
    @Column
    private Integer number04;
    @Column
    private Integer number05;
    @Column
    private Integer number06;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((number01 == null) ? 0 : number01.hashCode());
        result = prime * result
                + ((number02 == null) ? 0 : number02.hashCode());
        result = prime * result
                + ((number03 == null) ? 0 : number03.hashCode());
        result = prime * result
                + ((number04 == null) ? 0 : number04.hashCode());
        result = prime * result
                + ((number05 == null) ? 0 : number05.hashCode());
        result = prime * result
                + ((number06 == null) ? 0 : number06.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GamePK other = (GamePK) obj;
        if (number01 == null) {
            if (other.number01 != null)
                return false;
        } else if (!number01.equals(other.number01))
            return false;
        if (number02 == null) {
            if (other.number02 != null)
                return false;
        } else if (!number02.equals(other.number02))
            return false;
        if (number03 == null) {
            if (other.number03 != null)
                return false;
        } else if (!number03.equals(other.number03))
            return false;
        if (number04 == null) {
            if (other.number04 != null)
                return false;
        } else if (!number04.equals(other.number04))
            return false;
        if (number05 == null) {
            if (other.number05 != null)
                return false;
        } else if (!number05.equals(other.number05))
            return false;
        if (number06 == null) {
            if (other.number06 != null)
                return false;
        } else if (!number06.equals(other.number06))
            return false;
        return true;
    }

}
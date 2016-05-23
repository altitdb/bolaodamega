package com.bolaodamega.megasena.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.bolaodamega.megasena.roles.NumbersLateralRole;
import com.bolaodamega.megasena.roles.NumbersOddsAndEvenRole;
import com.bolaodamega.megasena.roles.NumbersSameColumnRole;
import com.bolaodamega.megasena.roles.NumbersSameRowRole;
import com.bolaodamega.megasena.roles.NumbersSequentialRole;
import com.bolaodamega.megasena.roles.Role;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Role attribute) {
        return attribute.value();
    }

    @Override
    public Role convertToEntityAttribute(Integer dbData) {
        switch (dbData) {
        case 1: {
            return new NumbersSequentialRole();
        }
        case 2: {
        	return new NumbersOddsAndEvenRole();
        }
        case 3: {
        	return new NumbersSameRowRole();
        }
        case 4: {
        	return new NumbersSameColumnRole();
        }
        case 5: {
        	return new NumbersLateralRole();
        }
        default:
            return null;
        }
    }

}

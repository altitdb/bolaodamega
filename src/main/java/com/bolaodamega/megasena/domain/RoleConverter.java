package com.bolaodamega.megasena.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

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
        case 0: {
            return new NumbersSequentialRole();
        }
        }
        return null;
    }

}

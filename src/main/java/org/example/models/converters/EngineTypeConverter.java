package org.example.models.converters;

import jakarta.persistence.AttributeConverter;
import org.example.models.enums.EngineType;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EngineTypeConverter implements AttributeConverter<EngineType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EngineType attribute) {
//        System.out.println(attribute.getEngineTypeCode());
        return attribute == null ? null : attribute.getEngineTypeCode();
    }

    @Override
    public EngineType convertToEntityAttribute(Integer dbData) {
        for (EngineType roleType : EngineType.values()) {
            if (roleType.getEngineTypeCode() == dbData) {
                return roleType;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}
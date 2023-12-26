package org.example.models.converters;

import jakarta.persistence.AttributeConverter;
import org.example.models.enums.ModelCategory;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ModelCategoryConverter implements AttributeConverter<ModelCategory, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ModelCategory attribute) {
//        System.out.println(attribute.getModelCategoryCode());
        return attribute == null ? null : attribute.getModelCategoryCode();
    }

    @Override
    public ModelCategory convertToEntityAttribute(Integer dbData) {
        for (ModelCategory roleType : ModelCategory.values()) {
            if (roleType.getModelCategoryCode() == dbData) {
                return roleType;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}
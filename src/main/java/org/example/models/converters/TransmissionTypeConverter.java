package org.example.models.converters;
import jakarta.persistence.AttributeConverter;
import org.example.models.enums.TransmissionType;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransmissionTypeConverter implements AttributeConverter<TransmissionType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TransmissionType attribute) {
        System.out.println(attribute.getTransmissionTypeCode());
        return attribute == null ? null : attribute.getTransmissionTypeCode();
    }

    @Override
    public TransmissionType convertToEntityAttribute(Integer dbData) {
        for (TransmissionType roleType : TransmissionType.values()) {
            if (roleType.getTransmissionTypeCode() == dbData) {
                return roleType;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}

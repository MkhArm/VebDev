package org.example.models.converters;
import jakarta.persistence.AttributeConverter;
import org.example.models.enums.UserRoleType;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleTypeConverter implements AttributeConverter<UserRoleType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserRoleType attribute) {
//        System.out.println(attribute.getUserRoleTypeCode());
        return attribute == null ? null : attribute.getUserRoleTypeCode();
    }

    @Override
    public UserRoleType convertToEntityAttribute(Integer dbData) {
        for (UserRoleType roleType : UserRoleType.values()) {
            if (roleType.getUserRoleTypeCode() == dbData) {
                return roleType;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}

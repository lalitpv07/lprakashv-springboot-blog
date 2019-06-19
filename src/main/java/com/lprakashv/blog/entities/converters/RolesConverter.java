package com.lprakashv.blog.entities.converters;

import com.lprakashv.blog.constants.Role;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;

public class RolesConverter implements AttributeConverter<List<Role>, Long> {
  @Override
  public Long convertToDatabaseColumn(List<Role> attribute) {
    Long dbVal = attribute.stream().map(Role::getVal).reduce((x, y) -> x*y).orElse(null);
    if (dbVal == null) {
      //TODO
      throw new RuntimeException("");
    }
    return dbVal;
  }

  @Override
  public List<Role> convertToEntityAttribute(Long dbData) {
    return Arrays.stream(Role.values()).filter(role -> dbData % role.getVal() == 0).collect(Collectors.toList());
  }
}

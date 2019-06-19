package com.lprakashv.blog.entities;

import com.lprakashv.blog.constants.Role;
import com.lprakashv.blog.entities.converters.RolesConverter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String username;

  @NotNull
  private String name;

  @NotNull
  private String password;

  @NotNull
  private String email;

  @Convert(converter = RolesConverter.class)
  private List<Role> roles;
}

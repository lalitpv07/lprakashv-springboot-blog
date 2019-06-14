package com.lprakashv.blog.entities;

import com.lprakashv.blog.constants.Role;
import com.lprakashv.blog.entities.converters.RolesConverter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BlogUser implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String username;

  @NotNull
  private String password;

  @NotNull
  private String email;

  @Convert(converter = RolesConverter.class)
  private List<Role> roles;

  @OneToMany(mappedBy = "author")
  private List<Post> posts;
}

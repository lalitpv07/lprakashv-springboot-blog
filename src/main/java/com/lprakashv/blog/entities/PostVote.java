package com.lprakashv.blog.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PostVote {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY)
  private Person person;

  @NotNull
  private Boolean vote;
}

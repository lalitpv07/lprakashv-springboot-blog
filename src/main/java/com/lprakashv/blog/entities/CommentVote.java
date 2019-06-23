package com.lprakashv.blog.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CommentVote implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Comment comment;

  @ManyToOne(fetch = FetchType.LAZY)
  private Person person;

  @NotNull
  private Boolean vote;
}

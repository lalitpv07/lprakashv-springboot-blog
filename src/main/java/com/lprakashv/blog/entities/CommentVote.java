package com.lprakashv.blog.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

  @ManyToOne
  private Comment comment;

  @ManyToOne
  private Person person;
}

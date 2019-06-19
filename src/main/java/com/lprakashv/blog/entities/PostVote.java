package com.lprakashv.blog.entities;

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
public class PostVote {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Post post;

  @ManyToOne
  private Person person;
}

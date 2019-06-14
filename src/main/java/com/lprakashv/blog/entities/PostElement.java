package com.lprakashv.blog.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PostElement implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Post post;

  private String content;

  private Integer priority;
}

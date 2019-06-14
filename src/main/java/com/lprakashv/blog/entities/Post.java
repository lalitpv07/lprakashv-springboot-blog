package com.lprakashv.blog.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String slug;

  @NotNull
  @ManyToOne
  private BlogUser author;

  @NotNull
  private String title;

  @OneToMany(mappedBy = "post")
  private List<PostElement> postElements;

  private BigInteger votes;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date postedOn;
}

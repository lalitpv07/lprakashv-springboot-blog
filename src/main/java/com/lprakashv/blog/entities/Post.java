package com.lprakashv.blog.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  private Person author;

  @NotNull
  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private List<PostTag> postTags;

  @Temporal(TemporalType.TIMESTAMP)
  private Date postedOn;
}

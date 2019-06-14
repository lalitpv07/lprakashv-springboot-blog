package com.lprakashv.blog.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private BlogUser commentedBy;

  @NotNull
  @ManyToOne
  private Post post;

  private BigInteger votes;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date commentedOn;
}

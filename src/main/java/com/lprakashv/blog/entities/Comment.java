package com.lprakashv.blog.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Person person;

  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
  private Set<CommentVote> commentVotes = new HashSet<>();

  private String content;

  private Date commentedOn;

  public void addCommntVote(Person voter, boolean vote) {
    CommentVote cv = new CommentVote();
    cv.setPerson(voter);
    cv.setVote(vote);
    cv.setComment(this);

    commentVotes.add(cv);
  }

  public long totalVotes() {
    return commentVotes.stream().map(cv -> cv.getVote()?1L:-1L).reduce(Long::sum).orElse(0L);
  }
}

package com.lprakashv.blog.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;
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
  @ManyToOne(fetch = FetchType.LAZY)
  private Person author;

  @NotNull
  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private List<PostTag> postTags = new ArrayList<>();

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private List<Comment> comments = new ArrayList<>();

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private Set<PostVote> postVotes = new HashSet<>();

  @Temporal(TemporalType.TIMESTAMP)
  private Date postedOn;

  public void addPostVote(Person voter, boolean vote) {
    PostVote pv = new PostVote();
    pv.setPerson(voter);
    pv.setVote(vote);
    pv.setPost(this);

    postVotes.add(pv);
  }

  public long totalVotes() {
    return postVotes.stream().map(cv -> cv.getVote()?1L:-1L).reduce(Long::sum).orElse(0L);
  }

  public void addTag(String tag) {
    PostTag postTag = new PostTag();
    postTag.setTag(tag);
    postTag.setPost(this);

    postTags.add(postTag);
  }

  public Comment addComment(Person commentedBy, String commentString) {
    Comment comment = new Comment();
    comment.setPerson(commentedBy);
    comment.setContent(commentString);
    comment.setCommentedOn(new Date());
    comment.setPost(this);

    comments.add(comment);

    return comment;
  }
}

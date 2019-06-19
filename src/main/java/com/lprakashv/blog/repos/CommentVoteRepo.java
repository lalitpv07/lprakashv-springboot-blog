package com.lprakashv.blog.repos;

import com.lprakashv.blog.entities.CommentVote;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CommentVoteRepo extends CrudRepository<CommentVote, Long> {
  List<CommentVote> findByCommentId(Long commentId);
}

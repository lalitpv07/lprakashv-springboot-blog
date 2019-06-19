package com.lprakashv.blog.repos;

import com.lprakashv.blog.entities.PostVote;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostVoteRepo extends CrudRepository<PostVote, Long> {
  List<PostVote> findByPostId(Long postId);
}

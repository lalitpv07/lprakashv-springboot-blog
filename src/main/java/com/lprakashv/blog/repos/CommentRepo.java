package com.lprakashv.blog.repos;

import com.lprakashv.blog.entities.Comment;
import com.lprakashv.blog.entities.Post;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {
  List<Comment> findByPostIdOrderByCommentedOnDesc(Long postId);
}

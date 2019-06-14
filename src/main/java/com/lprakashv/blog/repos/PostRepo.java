package com.lprakashv.blog.repos;

import com.lprakashv.blog.entities.Post;
import com.lprakashv.blog.entities.BlogUser;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {
  List<Post> findByAuthorOrderByPostedOnDesc(BlogUser author);

  List<Post> findByOrderByPostedOnDesc();

  List<Post> findBySlug(String slug);
}

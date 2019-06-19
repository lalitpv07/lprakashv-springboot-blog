package com.lprakashv.blog.repos;

import com.lprakashv.blog.entities.Post;
import com.lprakashv.blog.entities.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {
  List<Post> findByAuthorOrderByPostedOnDesc(Person author);

  List<Post> findByOrderByPostedOnDesc();

  Optional<Post> findBySlug(String slug);
}

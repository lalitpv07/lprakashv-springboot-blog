package com.lprakashv.blog.repos;

import com.lprakashv.blog.entities.BlogUser;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<BlogUser, Long> {
  Optional<BlogUser> findByUsername(String username);
}

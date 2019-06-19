package com.lprakashv.blog.repos;

import com.lprakashv.blog.entities.Person;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<Person, Long> {
  Optional<Person> findByUsername(String username);
}

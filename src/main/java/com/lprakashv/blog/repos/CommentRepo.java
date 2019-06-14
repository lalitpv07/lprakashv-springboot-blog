package com.lprakashv.blog.repos;

import com.lprakashv.blog.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, Long> {

}

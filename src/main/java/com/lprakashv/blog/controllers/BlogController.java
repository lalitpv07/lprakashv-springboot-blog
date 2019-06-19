package com.lprakashv.blog.controllers;

import com.lprakashv.blog.entities.Comment;
import com.lprakashv.blog.entities.Post;
import com.lprakashv.blog.repos.CommentRepo;
import com.lprakashv.blog.repos.CommentVoteRepo;
import com.lprakashv.blog.repos.PostRepo;
import com.lprakashv.blog.repos.PostVoteRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {
  @Autowired
  PostRepo postRepo;

  @Autowired
  CommentRepo commentRepo;

  @Autowired
  PostVoteRepo postVoteRepo;

  @Autowired
  CommentVoteRepo commentVoteRepo;

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("post", postRepo.findAll().iterator().next());
    return "home";
  }

  @GetMapping("/blog/{slug}")
  public String blog(@PathVariable String slug, Model model) {
    Post post = postRepo.findBySlug(slug).get();
    List<Comment> comments = commentRepo.findByPostIdOrderByCommentedOnDesc(post.getId());
    model.addAttribute("title", post.getTitle());
    model.addAttribute("post", post);
    model.addAttribute("comments", comments);
    model.addAttribute("postVotes", postVoteRepo.findByPostId(post.getId()).size());
    Map<String, Integer> commentsMap = new HashMap<>();
    for (Comment c: comments) {
      commentsMap.put(c.getId().toString(), commentVoteRepo.findByCommentId(c.getId()).size());
    }
    model.addAttribute("commentVotes", commentsMap);
    return "blog";
  }
}

package com.lprakashv.blog.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
  @GetMapping("/")
  public String guest() {
    return "home";
  }

  @GetMapping("/admin")
  @Secured("ROLE_ADMIN")
  public String admin() {
    return "Hello Admin";
  }

  @GetMapping("/user")
  @Secured("ROLE_USER")
  public String user() throws Exception {
    throw new Exception("");
    //return "Hello User";
  }

  @GetMapping("/author")
  @Secured("ROLE_AUTHOR")
  public String author() {
    return "Hello Author";
  }
}

package com.lprakashv.blog;

import com.lprakashv.blog.constants.Role;
import com.lprakashv.blog.entities.*;
import com.lprakashv.blog.repos.CommentRepo;
import com.lprakashv.blog.repos.PostRepo;
import com.lprakashv.blog.repos.UserRepo;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogApplication {

	private UserRepo userRepo;
	private PostRepo postRepo;
	private CommentRepo commentRepo;

	@Autowired
	public BlogApplication(UserRepo userRepo, PostRepo postRepo, CommentRepo commentRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.commentRepo = commentRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@PostConstruct
	public void initdb() {
		Person bu = new Person();
		bu.setEmail("lprakashv@gmail.com");
		bu.setUsername("lprakashv");
		bu.setName("Lalit Prakash Vatsal");
		bu.setPassword(new BCryptPasswordEncoder(11).encode("lpv0707"));
		bu.setRoles(Arrays.asList(Role.ROLE_ADMIN));

		userRepo.save(bu);

		Post post = new Post();

		post.setSlug("first-post");
		post.setTitle("First Post");

		post.setAuthor(bu);

		String sb = "<h3>Some Title</h3>" +
				"<p>One of the great things about Thymeleaf Fragments is that we can also grab any part of a template just using the simple selectors, through classes, ids, or simply by tags.\n" +
				"\n" +
				"This page, for example, includes some components from general.html file: an aside block and the div.another block:</p>" +
				"<h3>Some Other Title</h3>" +
				"<p>We can pass parameters to a fragment in order to change some specific part of it. To do that, the fragment must be defined as a function call, where we must declare a list of parameters.\n" +
				"\n" +
				"In this example, we define a fragment for a generic form field:</p>";
		post.setContent(sb);

		post.setPostedOn(new Date());

		post.addTag("tag1");
		post.addTag("tag2");
		post.addTag("tag3");

		Comment c1 = post.addComment(bu, "This is my first comment");
		Comment c2 = post.addComment(bu, "Some random following comment");

		postRepo.save(post);

		c2.addCommntVote(bu, false);
		commentRepo.save(c2);
	}
}

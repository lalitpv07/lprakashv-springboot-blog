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

		/*PostTag pt1 = new PostTag();
		pt1.setPost(post);
		pt1.setTag("tag1");

		PostTag pt2 = new PostTag();
		pt2.setPost(post);
		pt2.setTag("tag2");

		PostTag pt3 = new PostTag();
		pt3.setPost(post);
		pt3.setTag("tag3");*/


		post.setPostedOn(new Date());
		//post.setPostTags(Arrays.asList(pt1, pt2, pt3));
		post.addTag("tag1");
		post.addTag("tag2");
		post.addTag("tag3");

		Comment c1 = post.addComment(bu, "This is my first comment");
		Comment c2 = post.addComment(bu, "Some random following comment");

		postRepo.save(post);

		c2.addCommntVote(bu, false);
		commentRepo.save(c2);

		/*Comment c1 = new Comment();
		c1.setPerson(bu);
		c1.setContent("This is my first comment");
		c1.setCommentedOn(new Date(System.currentTimeMillis()-700000L));
		c1.setPost(post);

		Comment c2 = new Comment();
		c2.setPerson(bu);
		c2.setContent("This is my second comment");
		c2.setCommentedOn(new Date(System.currentTimeMillis()-70000L));
		c2.setPost(post);

		commentRepo.saveAll(Arrays.asList(c1, c2));*/
	}
}

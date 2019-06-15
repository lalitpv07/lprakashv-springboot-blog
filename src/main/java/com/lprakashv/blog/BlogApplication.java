package com.lprakashv.blog;

import com.lprakashv.blog.constants.Role;
import com.lprakashv.blog.entities.BlogUser;
import com.lprakashv.blog.repos.UserRepo;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogApplication {

	private UserRepo userRepo;

	@Autowired
	public BlogApplication(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	/*@PostConstruct
	public void initdb() {
		BlogUser bu = new BlogUser();
		bu.setEmail("lprakashv@gmail.com");
		bu.setUsername("lprakashv");
		bu.setPassword(new BCryptPasswordEncoder(11).encode("lpv0707"));
		bu.setRoles(Arrays.asList(Role.ROLE_ADMIN));

		userRepo.save(bu);
	}*/
}

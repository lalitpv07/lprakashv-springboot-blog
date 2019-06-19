package com.lprakashv.blog.services;

import com.lprakashv.blog.entities.Person;
import com.lprakashv.blog.models.BlogUserDetails;
import com.lprakashv.blog.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private UserRepo userRepo;

  @Autowired
  public UserDetailsServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //TODO
    Person person = userRepo.findByUsername(username).orElse(null);
    return new BlogUserDetails(person);
  }
}

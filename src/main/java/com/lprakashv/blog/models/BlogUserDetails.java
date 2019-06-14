package com.lprakashv.blog.models;

import com.lprakashv.blog.constants.Role;
import com.lprakashv.blog.entities.BlogUser;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class BlogUserDetails implements UserDetails {
  private BlogUser blogUser;

  public BlogUserDetails(BlogUser blogUser) {
    this.blogUser = blogUser;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    int size = blogUser.getRoles().size();
    List<String> roleStringList = blogUser.getRoles().stream().map(Role::name).collect(Collectors.toList());
    return AuthorityUtils.createAuthorityList(roleStringList.toArray(new String[size]));
  }

  @Override
  public String getPassword() {
    return blogUser.getPassword();
  }

  @Override
  public String getUsername() {
    return blogUser.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

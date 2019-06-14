package com.lprakashv.blog.constants;

public enum Role {
  ROLE_GUEST(2),
  ROLE_USER(3),
  ROLE_AUTHOR(5),
  ROLE_ADMIN(7)
  ;

  private long val;

  Role(long val) {
    this.val = val;
  }

  public long getVal() {
    return val;
  }
}

package model;

import java.util.Date;

public abstract class User {
  private String nickname;
  private String id;
  private Date date;

  public User(String nickname, String id, Date date) {
    this.nickname = nickname;
    this.id = id;
    this.date = date;
  }

  public String getNickname() {
    return nickname;
  }

  public String getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }
}
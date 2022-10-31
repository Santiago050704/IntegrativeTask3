package model;

import java.util.Date;

public abstract class ConsumerUser extends User {
  public ConsumerUser(String nickname, String id, Date date) {
    super(nickname, id, date);
  }
}
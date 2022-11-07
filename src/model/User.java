package model;

import java.time.LocalDate;

/**
 * This abstract class contains the common attributes and methods of the users in the platform.
 */
public abstract class User {

  private String nickname;
  private String id;
  private LocalDate date;

  /**
   * User: Constructor method that allows to initialize the attributes of user type objects.
   * @param nickname: String: Nickname of the user.
   * @param id: String: ID of the user.
   */
  public User(String nickname, String id) {
    this.nickname = nickname;
    this.id = id;
    this.date = LocalDate.now();
  }

  /**
   * getNickname: This method returns the nickname of the user.
   * @return nickname: String: nickname of the user.
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * getId: This method returns the ID of the user.
   * @return id: String: ID of the user.
   */
  public String getId() {
    return id;
  }

  /**
   * getDate: This method returns the date the user joined the platform.
   * @return date: LocalDate: Date the user joined the platform.
   */
  public LocalDate getDate() {
    return date;
  }
}
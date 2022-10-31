package model;

import java.util.Date;

public abstract class ProducerUser extends User {
  private String name;
  private String imageURL;

  public ProducerUser(String nickname, String id, Date date, String name, String imageURL) {
    super(nickname, id, date);
    this.name = name;
    this.imageURL = imageURL;
  }

  public String getName() {
    return name;
  }

  public String getImageURL() {
    return imageURL;
  }
}
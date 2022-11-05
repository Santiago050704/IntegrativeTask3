package model;

import java.util.Date;

public abstract class ProducerUser extends User {
  private String name;
  private String imageURL;
  private int accumulatedNumberOfReproductions;
  private double totalTimePlayedByConsumers;

  public ProducerUser(String nickname, String id, String name, String imageURL) {
    super(nickname, id);
    this.name = name;
    this.imageURL = imageURL;
    accumulatedNumberOfReproductions = 0;
    totalTimePlayedByConsumers = 0;
  }

  public String getName() {
    return name;
  }

  public String getImageURL() {
    return imageURL;
  }
}
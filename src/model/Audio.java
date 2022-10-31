package model;

public abstract class Audio {
  private String name;
  private String imageURL;
  private double duration;
  private int numberOfReproductions;

  public Audio(String name, String imageURL, double duration, int numberOfReproductions) {
    this.name = name;
    this.imageURL = imageURL;
    this.duration = duration;
    this.numberOfReproductions = numberOfReproductions;
  }

  public String getName() {
    return name;
  }

  public String getImageURL() {
    return imageURL;
  }

  public double getDuration() {
    return duration;
  }

  public int getNumberOfReproductions() {
    return numberOfReproductions;
  }
}
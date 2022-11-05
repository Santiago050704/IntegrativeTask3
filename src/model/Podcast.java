package model;

public class Podcast extends Audio {
  String description;
  PodcastCategory podcastCategory;

  public Podcast(String name, String imageURL, double duration, String description, PodcastCategory podcastCategory) {
    super(name, imageURL, duration);
    this.description = description;
    this.podcastCategory = podcastCategory;
  }
  
  public String getDescription() {
    return description;
  }

  public String getPodcastCategory() {
    return podcastCategory.toString();
  }
}
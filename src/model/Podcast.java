package model;

/**
 * This class contains the attributes and methods of the podcast in the platform.
 */
public class Podcast extends Audio {
  String description;
  PodcastCategory podcastCategory;

  /**
   * Podcast: Constructor method that allows to initialize the attributes of podcast type objects.
   * @param name: String: Name of the podcast.
   * @param imageURL: String: URL of the distinctive image of the podcast.
   * @param duration: double: Podcast duration.
   * @param description: String: Description of the podcast content.
   * @param podcastCategory: PodcastCategory: Category to which the podcast belongs.
   */
  public Podcast(String name, String imageURL, double duration, String description, PodcastCategory podcastCategory) {
    super(name, imageURL, duration);
    this.description = description;
    this.podcastCategory = podcastCategory;
  }
  
  /**
   * getDescription: This method returns the description of the podcast content.
   * @return description: String: Description of the podcast content.
   */
  public String getDescription() {
    return description;
  }

  /**
   * getPodcastCategory: This method returns the category of the podcast.
   * @return podcastCategory: String: Category of the podcast.
   */
  public String getPodcastCategory() {
    return podcastCategory.toString();
  }
}
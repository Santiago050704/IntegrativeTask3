package model;

/**
 * This abstract class contains the common attributes and methods of the audios in the platform.
 */
public abstract class Audio {
  private String name;
  private String imageURL;
  private double duration;
  private int numberOfReproductions;

  /**
   * Audio: Constructor method that allows to initialize the attributes of audio type objects.
   * @param name: String: Name of the audio.
   * @param imageURL: String: URL of the audio image (album or podcast).
   * @param duration: double: Audio duration in minutes.
   */
  public Audio(String name, String imageURL, double duration) {
    this.name = name;
    this.imageURL = imageURL;
    this.duration = duration;
    this.numberOfReproductions = 0;
  }

  /**
   * getName: This method returns the name of the audio.
   * @return name: String: Name of the audio.
   */
  public String getName() {
    return name;
  }

  /**
   * getImageURL: This method returns the URL of the audio image.
   * @return imageURL: String: URL of the audio image.
   */
  public String getImageURL() {
    return imageURL;
  }

  /**
   * getDuration: This method returns the duration of the audio.
   * @return duration: double: Duration of the audio.
   */
  public double getDuration() {
    return duration;
  }

  /**
   * getNumberOfReproductions: This method returns the number of plays of the audio.
   * @return numberOfReproductions: int: Number of plays of the audio.
   */
  public int getNumberOfReproductions() {
    return numberOfReproductions;
  }
}
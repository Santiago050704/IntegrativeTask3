package model;

import java.util.ArrayList;

/**
 * This class contains the attributes and methods of the content creators in the platform.
 */
public class ContentCreatorUser extends ProducerUser {

  private ArrayList<Podcast> podcasts;

  /**
   * ContentCreatorUser: Constructor method that allows to initialize the attributes of content creator user type objects.
   * @param nickname: String: Nickname of the content creator.
   * @param id: String: ID of the content creator.
   * @param name: String: Name of content creator.
   * @param imageURL: String: URL of the content creator's image.
   */
  public ContentCreatorUser(String nickname, String id, String name, String imageURL) {
    super(nickname, id, name, imageURL);
    podcasts = new ArrayList<Podcast>();
  }

  /**
   * getPodcasts: This method returns the content creator's podcast arraylist. 
   * @return podcasts: ArrayList<Podcast>: Content creator's podcast arraylist.
   */
  public ArrayList<Podcast> getPodcasts() {
    return podcasts;
  }
}
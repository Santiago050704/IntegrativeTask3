package model;

import java.util.ArrayList;

/**
 * This class contains the attributes and methods of the artist in the platform.
 */
public class ArtistUser extends ProducerUser {

  private ArrayList<Song> songs;

  /**
   * ArtistUser: Constructor method that allows to initialize the attributes of artist type objects.
   * @param nickname: String: Nickname of the artist.
   * @param id: String: Artist ID.
   * @param name: String: Name of the artist.
   * @param imageURL: String: URL of the artist's image.
   */
  public ArtistUser(String nickname, String id, String name, String imageURL) {
    super(nickname, id, name, imageURL);
    songs = new ArrayList<Song>();
  }

  /**
   * getSongs: This method returns the artist's song arraylist.
   * @return songs: ArrayList<Song>: Artist's song arraylist.
   */
  public ArrayList<Song> getSongs() {
    return songs;
  }
}
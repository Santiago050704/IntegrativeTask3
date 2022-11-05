package model;

import java.util.ArrayList;

public class ArtistUser extends ProducerUser {

  private ArrayList<Song> songs;

  public ArtistUser(String nickname, String id, String name, String imageURL) {
    super(nickname, id, name, imageURL);
    songs = new ArrayList<Song>();
  }

  public ArrayList<Song> getSongs() {
    return songs;
  }
}
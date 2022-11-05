package model;

import java.util.ArrayList;

public class ContentCreatorUser extends ProducerUser {

  private ArrayList<Podcast> podcasts;

  public ContentCreatorUser(String nickname, String id, String name, String imageURL) {
    super(nickname, id, name, imageURL);
    podcasts = new ArrayList<Podcast>();
  }

  public ArrayList<Podcast> getPodcasts() {
    return podcasts;
  }
}
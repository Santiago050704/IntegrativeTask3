package model;

import java.util.Date;

public class ArtistUser extends ProducerUser {
  public ArtistUser(String nickname, String id, Date date, String name, String imageURL) {
    super(nickname, id, date, name, imageURL);
  }
}
package model;

import java.util.ArrayList;

public class PremiumUser extends ConsumerUser {

  private ArrayList<Playlist> playlists;

  public PremiumUser(String nickname, String id) {
    super(nickname, id);
    playlists = new ArrayList<Playlist>();
  }

  public ArrayList<Playlist> getPlaylists() {
    return playlists;
  }

}
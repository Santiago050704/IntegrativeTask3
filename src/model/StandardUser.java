package model;

public class StandardUser extends ConsumerUser {

  public static final int MAX_NUMBER_OF_PLAYLISTS = 20;

  private Playlist[] playlists;
  private int maxNumberOfSongsToBuy;

  public StandardUser(String nickname, String id) {
    super(nickname, id);
    playlists = new Playlist[MAX_NUMBER_OF_PLAYLISTS];
    maxNumberOfSongsToBuy = 100;
  }

  public int getMaxNumberOfSongsToBuy() {
    return maxNumberOfSongsToBuy;
  }

  public Playlist[] getPlaylists() {
    return playlists;
  }

}
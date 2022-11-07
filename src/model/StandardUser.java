package model;

/**
 * This class contains the attributes and methods of the standard users in the platform.
 */
public class StandardUser extends ConsumerUser {

  public static final int MAX_NUMBER_OF_PLAYLISTS = 20;

  private Playlist[] playlists;
  private int maxNumberOfSongsToBuy;

  /**
   * StandardUser: Constructor method that allows to initialize the attributes of standard user type objects.
   * @param nickname: String: Nickname of the standard user.
   * @param id: String: ID of the standard user.
   */
  public StandardUser(String nickname, String id) {
    super(nickname, id);
    playlists = new Playlist[MAX_NUMBER_OF_PLAYLISTS];
    maxNumberOfSongsToBuy = 100;
  }

  /**
   * getMaxNumberOfSongsToBuy: This method returns the maximum number of songs that a standard user can have.
   * @return maxNumberOfSongsToBuy: int: Maximum number of songs that a standard user can have.
   */
  public int getMaxNumberOfSongsToBuy() {
    return maxNumberOfSongsToBuy;
  }

  /**
   * getPlaylists: This method returns the array of playlists that the standard user has.
   * @return playlists: Playlist[]: Array of playlists that the standard user has.
   */
  public Playlist[] getPlaylists() {
    return playlists;
  }

}
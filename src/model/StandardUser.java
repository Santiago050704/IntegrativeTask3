package model;

public class StandardUser extends ConsumerUser {

  private int maxNumberOfSongsToBuy;

  public StandardUser(String nickname, String id) {
    super(nickname, id);
    maxNumberOfSongsToBuy = 100;
  }

  public int getMaxNumberOfSongsToBuy() {
    return maxNumberOfSongsToBuy;
  }

}
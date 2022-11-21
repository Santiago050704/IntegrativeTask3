package model;

/**
 * This class contains the attributes and methods of the standard users in the platform.
 */
public class StandardUser extends ConsumerUser /*implements AudioPlayback*/{
  private int maxNumberOfSongsToBuy;
  private int reproductionNumber;

  /**
   * StandardUser: Constructor method that allows to initialize the attributes of standard user type objects.
   * @param nickname: String: Nickname of the standard user.
   * @param id: String: ID of the standard user.
   */
  public StandardUser(String nickname, String id) {
    super(nickname, id);
    maxNumberOfSongsToBuy = 100;
  }

  /**
   * getMaxNumberOfSongsToBuy: This method returns the maximum number of songs that a standard user can have.
   * @return maxNumberOfSongsToBuy: int: Maximum number of songs that a standard user can have.
   */
  public int getMaxNumberOfSongsToBuy() {
    return maxNumberOfSongsToBuy;
  }

  /*public String playbackAudio(Audio audio) {
    String msj = "";
    if (audio instanceof Song) {
      reproductionNumber++;
    } else {
      if (reproductionNumber >= 2) {
        reproductionNumber = 0;
      }
    }
    msj = "The audio " + audio.getName() + " is playing...";
    return msj;
  }*/

  public int getReproductionNumber() {
    return reproductionNumber;
  }

  public void setReproductionNumber() {
    reproductionNumber++;
  }
}
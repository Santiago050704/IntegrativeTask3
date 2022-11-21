package model;

public class PremiumUser extends ConsumerUser /*implements AudioPlayback*/{

  public PremiumUser(String nickname, String id) {
    super(nickname, id);
  }

  /*public String playbackAudio(Audio audio) {
    String msj = "";
    msj = "The audio " + audio.getName() + " is playing...";
    return msj;
  }*/
}
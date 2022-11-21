package model;

import java.util.ArrayList;

/**
 * This abstract class contains the common attributes and methods of the consumer users in the platform.
 */
public abstract class ConsumerUser extends User {
  private ArrayList<Playlist> playlists;
  private double accumulatedPlayTimeOfSongs;
  private double accumulatedPlayTimeOfPodcasts;
  private MusicalGenre mostListenedGenre;
  private PodcastCategory mostListenedPodcastCategory;
  private ArtistUser mostListenedArtist;
  private ContentCreatorUser mostListenedContentCreatorUser;

  /**
   * ConsumerUser: Constructor method that allows to initialize the attributes of consumer user type objects.
   * @param nickname: String: Nickname of the consumer user.
   * @param id: String: Consumer user ID.
   */
  public ConsumerUser(String nickname, String id) {
    super(nickname, id);
    playlists = new ArrayList<Playlist>();
    accumulatedPlayTimeOfSongs = 0;
    accumulatedPlayTimeOfPodcasts = 0;
  }

  public ArrayList<Playlist> getPlaylists() {
    return playlists;
  }
}
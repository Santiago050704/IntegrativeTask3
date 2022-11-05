package model;

import java.util.ArrayList;

public abstract class ConsumerUser extends User {

  private ArrayList<Playlist> playlists;
  private double accumulatedPlayTimeOfSongs;
  private double accumulatedPlayTimeOfPodcasts;
  private MusicalGenre mostListenedGenre;
  private PodcastCategory mostListenedPodcastCategory;
  private ArtistUser mostListenedArtist;
  private ContentCreatorUser mostListenedContentCreatorUser;

  public ConsumerUser(String nickname, String id) {
    super(nickname, id);
    playlists = new ArrayList<Playlist>();
    accumulatedPlayTimeOfSongs = 0;
    accumulatedPlayTimeOfPodcasts = 0;
  }
}
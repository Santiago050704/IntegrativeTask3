package model;

import java.util.ArrayList;

public class NTAudios {
  ArrayList<User> users;

  public NTAudios() {
    users = new ArrayList<User>();
  }

  public String registerProducerUser(String nickname, String id, String name, String imageURL, int choice) {
    String msj = "";
    int posUser = searchUserById(id);
    boolean wasAdded = false;
    if (posUser == -1) {
      switch (choice) {
        case 1:
          ArtistUser artistUser = new ArtistUser(nickname, id, name, imageURL);
          users.add(artistUser);
          wasAdded = true;
          msj = "The artist was correctly registered.";
          break;

        case 2:
          ContentCreatorUser contentCreatorUser = new ContentCreatorUser(nickname, id, name, imageURL);
          users.add(contentCreatorUser);
          wasAdded = true;
          msj = "The content creator was correctly registered.";
          break;
      }
    } else {
      msj = "The user already exists within the platform.";
    }
    return msj;
  }
  
  public String registerConsumerUser(String nickname, String id, int choice) {
    String msj = "";
    int posUser = searchUserById(id);
    boolean wasAdded = false;
    if (posUser == -1) {
      switch (choice) {
        case 1:
          StandardUser standardUser = new StandardUser(nickname, id);
          users.add(standardUser);
          wasAdded = true;
          msj = "The standard user was correctly registered.";
          break;

        case 2:
          PremiumUser premiumUser = new PremiumUser(nickname, id);
          users.add(premiumUser);
          wasAdded = true;
          msj = "The premium user was correctly registered.";
          break;
      }
    } else {
      msj = "The user already exists within the platform.";
    }
    return msj;
  }

  public String registerSong(String name, String imageURL, double duration, String album, String musicalGenre,
      double saleValue, String userId) {
    String msj = "";
    int posUser = searchUserById(userId);
    int posSong = searchSongByName(userId, name);
    MusicalGenre musicGenre;
    boolean theMusicalGenreExists = confirmMusicalGenre(musicalGenre);
    boolean wasAdded = false;
    if (posUser != -1) {
      if (theMusicalGenreExists == true) {
        if (users.get(posUser) instanceof ArtistUser) {
          if (posSong == -1) {
            musicGenre = MusicalGenre.valueOf(musicalGenre.toUpperCase());
            Song song = new Song(name, imageURL, duration, album, musicGenre, saleValue);
            ((ArtistUser) (users.get(posUser))).getSongs().add(song);
            wasAdded = true;
            msj = "The song was successfully registered.";
          } else {
            msj = "The artist already has a song with the name entered.";
          }
        } else {
          msj = "The entered user ID is not of an artist, so it cannot have songs.";
        }
      } else {
        msj = "The entered musical genre does not exist.";
      }
    } else {
      msj = "The user does not exist within the platform.";
    }
    return msj;
  }
  
  public String registerPodcast(String name, String imageURL, double duration, String description,
      String podcastCategory, String userId) {
    String msj = "";
    int posUser = searchUserById(userId);
    int posPodcast = searchPodcastByName(userId, name);
    PodcastCategory categoryOfPodcast;
    boolean thePodcastCategoryExists = confirmPodcastCategory(podcastCategory);
    boolean wasAdded = false;
    if (posUser != -1) {
      if (thePodcastCategoryExists == true) {
        if (users.get(posUser) instanceof ContentCreatorUser) {
          if (posPodcast == -1) {
            categoryOfPodcast = PodcastCategory.valueOf(podcastCategory.toUpperCase());
            Podcast podcast = new Podcast(name, imageURL, duration, description, categoryOfPodcast);
            ((ContentCreatorUser) (users.get(posUser))).getPodcasts().add(podcast);
            wasAdded = true;
            msj = "The podcast was successfully registered.";
          } else {
            msj = "The content creator already has a podcast with the name entered.";
          }
        } else {
          msj = "The entered user ID is not of an content creator, so it cannot have podcasts.";
        }
      } else {
        msj = "The entered podcast category does not exist.";
      }
    } else {
      msj = "The user does not exist within the platform.";
    }
    return msj;
  }
  
  public String createAPlaylist(String name, ) {
    
  }
  
  public boolean confirmMusicalGenre(String musicalGenre) {
    String[] musicalGenres = { "Rock", "Pop", "Trap", "House" };
    boolean wasFound = false;
    for (int i = 0; i < musicalGenres.length && !wasFound; i++) {
      if (musicalGenre.equalsIgnoreCase(musicalGenres[i])) {
        wasFound = true;
      }
    }
    return wasFound;
  }

  public boolean confirmPodcastCategory(String podcastCategory) {
    String[] podcastCategories = { "Policy", "Entertainment", "Videogames", "Fashion" };
    boolean wasFound = false;
    for (int i = 0; i < podcastCategories.length && !wasFound; i++) {
      if (podcastCategory.equalsIgnoreCase(podcastCategories[i])) {
        wasFound = true;
      }
    }
    return wasFound;
  }
  
  public int searchUserById(String userId) {
    int pos = -1;
    boolean wasFound = false;
    for (int i = 0; i < users.size() && !wasFound; i++) {
      if (users.get(i) != null && users.get(i).getId().equalsIgnoreCase(userId)) {
        pos = i;
        wasFound = true;
      }
    }
    return pos;
  }

  public int searchSongByName(String userId, String songName) {
    int pos = -1;
    boolean wasFound = false;
    int posUser = searchUserById(userId);
    if (posUser != -1) {
      for (int i = 0; i < ((ArtistUser) (users.get(posUser))).getSongs().size() && !wasFound; i++) {
        if (users.get(posUser) != null
            && ((ArtistUser) (users.get(posUser))).getSongs().get(i).getName().equalsIgnoreCase(songName)) {
          pos = i;
          wasFound = true;
        }
      }
    }
    return pos;
  }

  public int searchPodcastByName(String userId, String podcastName) {
    int pos = -1;
    boolean wasFound = false;
    int posUser = searchUserById(userId);
    if (posUser != -1) {
      for (int i = 0; i < ((ContentCreatorUser) (users.get(posUser))).getPodcasts().size() && !wasFound; i++) {
        if (users.get(posUser) != null
            && ((ContentCreatorUser) (users.get(posUser))).getPodcasts().get(i).getName().equalsIgnoreCase(podcastName)) {
          pos = i;
          wasFound = true;
        }
      }
    }
    return pos;
  }

}
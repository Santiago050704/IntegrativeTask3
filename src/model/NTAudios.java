package model;

import java.util.ArrayList;

/**
 * This class allows executing most of the methods that represent the functionalities of the program.
 */
public class NTAudios {
  ArrayList<User> users;

  /**
   * NTAudios: Constructor method that allows to initialize the arraylist of users of the platform.
   */
  public NTAudios() {
    users = new ArrayList<User>();
  }

  /**
   * registerProducerUser: This method allows registering producer users within the user arraylist of the platform, if the user to be created does not yet exist.
   * @param nickname: String: Nickname of the producer user.
   * @param id: String: ID of the producer user.
   * @param name: String: Name of the producer user.
   * @param imageURL: String: URL of the image representing the producer user.
   * @param choice: int: Choice that allows to create and add an artist or a content creator.
   * @return msj: String: Confirmation message if the producer user was added or not.
   */
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
  
  /**
   * registerConsumerUser: This method allows registering consumer users within the user arraylist of the platform, if the user to be created does not yet exist.
   * @param nickname: String: Nickname of the consumer user.
   * @param id: String: ID of the consumer user.
   * @param choice: int: Choice that allows to create and add an standard or a premium user.
   * @return msj: String: Confirmation message if the consumer user was added or not.
   */
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

  /**
   * registerSong: This method allows to register songs within the arraylist of songs that an artist has, if the song does not yet exist within the artist.
   * @param name: String: Name of the song.
   * @param imageURL: String: URL of the image that represents the album of the song.
   * @param duration: double: Time in minutes that a song lasts.
   * @param album: String: Album to which the song belongs.
   * @param musicalGenre: String(Enum): Musical genre of the song.
   * @param saleValue: double: Sales value of the song.
   * @param userId: ID of the artist to which the song belongs.
   * @return msj: String: Confirmation message if the song was created and added within the artist it belongs to.
   */
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
  
  /**
   * registerPodcast: This method allows to register podcasts within the arraylist of podcasts that a content creator has, if the podcast does not yet exist within the * content creator.
   * @param name: String: Name of the podcast.
   * @param imageURL: String: URL of the distinctive image representing the podcast.
   * @param duration: double: Time in minutes that a podcast lasts.
   * @param description: String: Description of the podcast.
   * @param podcastCategory: String(Enum): Category of the podcast.
   * @param userId: String: ID of the content creator to which the podcast belongs.
   * @return msj: String: Confirmation message if the podcast was created and added within the content creator it belongs to.
   */
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
  
  /**
   * createAPlaylist: This method allows you to create a playlist within a consumer user. If you are a standard user, you will only have 20 playlists.
   * @param name: String: Name of the playlist.
   * @param consumerId: String: ID of the consumer user who will have the playlist.
   * @return msj: String: Confirmation message if the playlist could be created within the consumer user.
   */
  public String createAPlaylist(String name, String consumerId) {
    String msj = "";
    boolean wasAdded = false;
    int posConsumer = searchUserById(consumerId);
    int posPlaylist = searchPlaylistByName(consumerId, name);
    if (posConsumer != -1) {
      if (users.get(posConsumer) instanceof StandardUser) {
        if (posPlaylist == -1) {
          Playlist playlist = new Playlist(name);
          for (int i = 0; i < ((StandardUser) (users.get(posConsumer))).getPlaylists().length && !wasAdded; i++) {
            if (((StandardUser) (users.get(posConsumer))).getPlaylists()[i] == null) {
              ((StandardUser) (users.get(posConsumer))).getPlaylists()[i] = playlist;
              wasAdded = true;
              msj = "The playlist was successfully created in the standard user.";
            } else {
              msj = "This standard user has already reached the limit number of playlists.";
            }
          }
        } else {
          msj = "The standard user already has a playlist with that name.";
        }
      } else if (users.get(posConsumer) instanceof PremiumUser) {
        if (posPlaylist == -1) {
          Playlist playlist = new Playlist(name);
          ((PremiumUser) (users.get(posConsumer))).getPlaylists().add(playlist);
          wasAdded = true;
          msj = "The playlist was successfully created in the premium user.";
        } else {
          msj = "The premium user already has a playlist with that name.";
        }
      } else {
        msj = "The user ID entered does not belong to a consumer user.";
      }
    } else {
      msj = "The user entered does not exist within the platform.";
    }
    return msj;
  }

  /**
   * editPlaylist: This method allows to edit a playlist (add songs or podcasts).
   * @param audioName: String: Name of the audio to be added.
   * @param producerId: String: ID of the producer user to which the audio to be added belongs.
   * @param playlistName: String: Name of the playlist to be edited.
   * @param consumerId: String: ID of the consumer user to which the playlist belongs.
   * @param choice: int: Integer representing the option to add a song or podcast.
   * @return msj: String: Confirmation message if the audio can be added to the playlist. In addition, the playlist matrix and the auto-generated code are displayed.
   */
  public String editPlaylist(String audioName, String producerId, String playlistName, String consumerId, int choice) {
    String msj = "";
    int posProducer = searchUserById(producerId);
    int posConsumer = searchUserById(consumerId);
    int posSong = searchSongByName(producerId, audioName);
    int posPodcast = searchPodcastByName(producerId, audioName);
    int posPlaylist = searchPlaylistByName(consumerId, playlistName);

    if(posProducer != -1){
      if (posConsumer != -1) {
        switch (choice) {
          case 1:
            if (users.get(posProducer) instanceof ArtistUser) {
              if(posPlaylist != -1){
                if(posSong != -1){
                  if(users.get(posConsumer) instanceof StandardUser){
                    for(int i = 0; i < ((StandardUser)(users.get(posConsumer))).getPlaylists()[posPlaylist].getAudioList().size(); i++){
                      if(((StandardUser)(users.get(posConsumer))).getPlaylists()[posPlaylist].getAudioList().get(i) != null && !((StandardUser)(users.get(posConsumer))).getPlaylists()[posPlaylist].getAudioList().get(i).getName().equalsIgnoreCase(audioName)){
                        ((StandardUser)(users.get(posConsumer))).getPlaylists()[posPlaylist].getAudioList().add(((ArtistUser)(users.get(posProducer))).getSongs().get(posSong));
                        msj = "The song was successfully added to the playlist. " + runMatrix(playlistName, consumerId);
                      } else {
                        msj = "There is already a song with that name in the playlist.";
                      }
                    }
                  }else if(users.get(posConsumer) instanceof PremiumUser){
                    for(int i = 0; i < ((PremiumUser)(users.get(posConsumer))).getPlaylists().get(posPlaylist).getAudioList().size(); i++){
                      if(((PremiumUser)(users.get(posConsumer))).getPlaylists().get(posPlaylist).getAudioList().get(i) != null && !((PremiumUser)(users.get(posConsumer))).getPlaylists().get(posPlaylist).getAudioList().get(i).getName().equalsIgnoreCase(audioName)){
                        ((PremiumUser)(users.get(posConsumer))).getPlaylists().get(posPlaylist).getAudioList().add(((ArtistUser)(users.get(posProducer))).getSongs().get(posSong));
                        msj = "The song was successfully added to the playlist." + runMatrix(playlistName, consumerId);
                      } else {
                        msj = "There is already a song with that name in the playlist.";
                      }
                    }
                  }else{
                    msj = "The user to whom you want to add the song is not a consumer user.";
                  }
                } else {
                  msj = "The song you want to add to the playlist is not within the artist you entered.";
                }
              } else {
                msj = "The playlist to which you want to add the song does not exist.";
              }
            } 
            break;
          
          case 2:
            if (users.get(posProducer) instanceof ContentCreatorUser) {
              if (posPlaylist != -1) {
                if (posPodcast != -1) {
                  if (users.get(posConsumer) instanceof StandardUser) {
                    for (int i = 0; i < ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getAudioList().size(); i++) {
                      if (((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getAudioList().get(i) != null && !((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getAudioList().get(i).getName().equalsIgnoreCase(audioName)) {
                        ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getAudioList().add(((ContentCreatorUser) (users.get(posProducer))).getPodcasts().get(posPodcast));
                        msj = "The podcast was successfully added to the playlist. " + runMatrix(playlistName, consumerId);
                      } else {
                        msj = "There is already a podcast with that name in the playlist.";
                      }
                    }
                  } else if (users.get(posConsumer) instanceof PremiumUser) {
                    for(int i = 0; i < ((PremiumUser)(users.get(posConsumer))).getPlaylists().get(posPlaylist).getAudioList().size(); i++){
                      if(((PremiumUser)(users.get(posConsumer))).getPlaylists().get(posPlaylist).getAudioList().get(i) != null && !((PremiumUser)(users.get(posConsumer))).getPlaylists().get(posPlaylist).getAudioList().get(i).getName().equalsIgnoreCase(audioName)){
                        ((PremiumUser)(users.get(posConsumer))).getPlaylists().get(posPlaylist).getAudioList().add(((ContentCreatorUser)(users.get(posProducer))).getPodcasts().get(posPodcast));
                        msj = "The podcast was successfully added to the playlist." + runMatrix(playlistName, consumerId);
                      } else {
                        msj = "There is already a podcast with that name in the playlist.";
                      }
                    }
                  }else{
                    msj = "The user to whom you want to add the podcast is not a consumer user.";
                  }
                } else {
                  msj = "The song you want to add to the playlist is not within the artist you entered.";
                }
              } else {
                msj = "The playlist to which you want to add the podcast does not exist.";
              }
            }
          break;
        }
      } else {
        msj = "The consumer user to which you want to add the audio to the playlist does not exist within the platform.";
      }
    } else {
      msj = "The producer user who owns the audio does not exist within the platform.";
    }
    return msj;
  }

  /**
   * runMatrix: This method allows to traverse the playlist matrix depending on its content. If it contains only songs the path is an N, if it contains only podcasts * 
   * the path is a T, and if it contains both the path is a zigzag.
   * @param playlistName: String: Name of the playlist to go through.
   * @param consumerId: String: ID of the consumer user who owns the playlist.
   * @return msj: String: Message showing the matrix and the generated code depending on the path. Otherwise, it shows that there are no audios in the playlist.
   */
  public String runMatrix(String playlistName, String consumerId) {
    int posConsumer = searchUserById(consumerId);
    int posPlaylist = searchPlaylistByName(consumerId, playlistName);
    if (posConsumer != -1) {
      if (users.get(posConsumer) instanceof StandardUser) {
        if (posPlaylist != -1) {
          int songCounter = countSongsInAPlaylist(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist]);
          int podcastCounter = countPodcastsInAPlaylist(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist]);
          if (songCounter > 0 && podcastCounter == 0) {
            for (int i = 5; i >= 0; i--) {
              ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].setCode(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()[i][0]);
            }
            for (int i = 1; i < 5; i++) {
              ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].setCode(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()[i][i]);
            }
            for (int i = 5; i >= 0; i--) {
              ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].setCode(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()[i][5]);
            }
            msj = "Matrix: \n" + ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].showMatrix(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()) + "\n Code of playlist: " + ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCode();
            
          } else if (songCounter == 0 && podcastCounter > 0) {
            for (int i = 0; i < 3; i++) {
              ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].setCode(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()[0][i]);
            }
            for (int i = 1; i < 6; i++) {
              ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].setCode(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()[i][2]);
            }
            for (int i = 5; i >= 1; i--) {
              ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].setCode(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()[i][3]);
            }
            for (int i = 3; i < 6; i++) {
              ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].setCode(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()[0][i]);
            }
            msj = "Matrix: \n" + ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].showMatrix(((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCodeMatrix()) + "\n Code of playlist: " + ((StandardUser) (users.get(posConsumer))).getPlaylists()[posPlaylist].getCode();
            
          } else if (songCounter > 0 && podcastCounter > 0) {
            
          } else {
            msj = "The playlist has no audios inside.";
          }
        }
      } else if (users.get(posConsumer) instanceof PremiumUser) {
        if (posPlaylist != -1) {
          int songCounter = countSongsInAPlaylist(
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist));
          int podcastCounter = countPodcastsInAPlaylist(
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist));
          if (songCounter > 0 && podcastCounter == 0) {
            for (int i = 5; i >= 0; i--) {
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).setCode(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()[i][0]);
            }
            for (int i = 1; i < 5; i++) {
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).setCode(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()[i][i]);
            }
            for (int i = 5; i >= 0; i--) {
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).setCode(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()[i][5]);
            }
            msj = "Matrix: \n" + ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).showMatrix(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()) + "\n Code of playlist: " + ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCode();
            
          } else if (songCounter == 0 && podcastCounter > 0) {
            for (int i = 0; i < 3; i++) {
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).setCode(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()[0][i]);
            }
            for (int i = 1; i < 6; i++) {
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).setCode(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()[i][2]);
            }
            for (int i = 5; i >= 1; i--) {
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).setCode(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()[i][3]);
            }
            for (int i = 3; i < 6; i++) {
              ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).setCode(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()[0][i]);
            }
            msj = "Matrix: \n" + ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).showMatrix(((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCodeMatrix()) + "\n Code of playlist: " + ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(posPlaylist).getCode();
            
          } else if (songCounter > 0 && podcastCounter > 0) {
            
          } else {
            msj = "The playlist has no audios inside.";
          }        
        }
      }
    }
    return msj;
  }
  
  /**
   * countSongsInAPlaylist: This method allows to count the songs within a playlist.
   * @param playlist: ArrayList<Audio>: Arraylist where the songs will be counted.
   * @return songCounter: int: Song counter.
   */
  public int countSongsInAPlaylist(ArrayList<Audio> playlist) {
    int songCounter = 0;
    for (int i = 0; i < playlist.size(); i++) {
      if (playlists.get(i) instanceof Song) {
        songCounter++;
      }
    }
    return songCounter;
  }

  /**
   * countPodcastsInAPlaylist: This method allows to count the podcasts within a playlist.
   * @param playlist: ArrayList<Audio>: Arraylist where the podcasts will be counted.
   * @return podcastCounter: int: Podcast counter.
   */
  public int countPodcastsInAPlaylist(ArrayList<Audio> playlist) {
    int podcastCounter = 0;
    for (int i = 0; i < playlist.size(); i++) {
      if (playlist.get(i) instanceof Podcast) {
        podcastCounter++;
      }
    }
    return podcastCounter;
  }
  
  /**
   * confirmMusicalGenre: This method allows to confirm that the user enters the correct enumeration of musical genres.
   * @param musicalGenre: String: Musical genre.
   * @return wasFound: boolean: Boolean that confirms whether the enum exists or not.
   */
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

  /**
   * confirmPodcastCategory: This method allows to confirm that the user enters the correct enumeration of podcast categories.
   * @param podcastCategory: String: Podcast category.
   * @return wasFound: boolean: Boolean that confirms whether the enum exists or not.
   */
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
  
  /**
   * searchUserById: Method to search for a user within the user arraylist.
   * @param userId: String: ID of the user to search for.
   * @return pos: int: Position of the user within the user arraylist. If it does not exist, returns -1.
   */
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

  /**
   * searchSongByName: Method that allows to search for a song within an artist's song arraylist.
   * @param userId: String: ID of the user to whom the song belongs.
   * @param songName: String: Name of the song to be searched.
   * @return pos: int: Position of the song within the song arraylist. If it does not exist, returns -1.
   */
  public int searchSongByName(String userId, String songName) {
    int pos = -1;
    boolean wasFound = false;
    int posUser = searchUserById(userId);
    if (posUser != -1) {
      for (int i = 0; i < ((ArtistUser) (users.get(posUser))).getSongs().size() && !wasFound; i++) {
        if (((ArtistUser)(users.get(posUser))).getSongs().get(i) != null && ((ArtistUser) (users.get(posUser))).getSongs().get(i).getName().equalsIgnoreCase(songName)) {
          pos = i;
          wasFound = true;
        }
      }
    }
    return pos;
  }

  /**
   * searchPodcastByName: Method that allows to search for a podcast within an content creator's podcast arraylist.
   * @param userId: String: ID of the user to whom the podcast belongs.
   * @param podcastName: String: Name of the podcast to be searched.
   * @return pos: int: Position of the podcast within the podcast arraylist. If it does not exist, returns -1.
   */
  public int searchPodcastByName(String userId, String podcastName) {
    int pos = -1;
    boolean wasFound = false;
    int posUser = searchUserById(userId);
    if (posUser != -1) {
      for (int i = 0; i < ((ContentCreatorUser) (users.get(posUser))).getPodcasts().size() && !wasFound; i++) {
        if (((ContentCreatorUser)(users.get(posUser))).getPodcasts().get(i) != null && ((ContentCreatorUser) (users.get(posUser))).getPodcasts().get(i).getName().equalsIgnoreCase(podcastName)) {
          pos = i;
          wasFound = true;
        }
      }
    }
    return pos;
  }
  
  /**
   * searchPlaylistByName: Method that allows to search for a playlist within a user's playlist arraylist.
   * @param consumerId: String: ID of the user to whom the playlist belongs.
   * @param name: String: Name of the playlist to be searched.
   * @return pos: int: Position of the playlist within the playlist arraylist or array. If it does not exist, returns -1.
   */
  public int searchPlaylistByName(String consumerId, String name) {
    int pos = -1;
    boolean wasFound = false;
    int posConsumer = searchUserById(consumerId);
    if (posConsumer != -1) {
      if (users.get(posConsumer) instanceof StandardUser) {
        for (int i = 0; i < ((StandardUser) (users.get(posConsumer))).getPlaylists().length && !wasFound; i++) {
          if (((StandardUser)(users.get(posConsumer))).getPlaylists()[i] != null && ((StandardUser) (users.get(posConsumer))).getPlaylists()[i].getName().        equalsIgnoreCase(name)) {
            pos = i;
            wasFound = true;
          }
        }
      } else if (users.get(posConsumer) instanceof PremiumUser) {
        for (int i = 0; i < ((PremiumUser) (users.get(posConsumer))).getPlaylists().size() && !wasFound; i++) {
          if (((PremiumUser)(users.get(posConsumer))).getPlaylists().get(i) != null  && ((PremiumUser) (users.get(posConsumer))).getPlaylists().get(i).getName().equalsIgnoreCase(name)) {
            pos = i;
            wasFound = true;
          }
        }
      }
    }
    return pos;
  }

}
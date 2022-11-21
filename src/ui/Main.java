package ui;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthListUI;

import model.MusicalGenre;
import model.NTAudios;

/**
 * This class allows executing the program and contains all the view methods with which the user will interact.
 */
public class Main{
  private Scanner reader;
  private NTAudios controllerNTAudios;

  /**
   * Main: This constructor method initializes the objects of the Scanner and NTAudios classes.
   */
  public Main(){
    reader = new Scanner(System.in);
    controllerNTAudios = new NTAudios();
  }

  public static void main(String[] args) {

    Main main = new Main();
    /*main.controllerNTAudios.registerProducerUser("hj", "p", "gf", "jkjk", 1);
    main.controllerNTAudios.registerProducerUser("hj", "u", "gf", "jkjk", 2);
    main.controllerNTAudios.registerConsumerUser("jkjk", "l", 1);
    main.controllerNTAudios.registerConsumerUser("jkjk", "m", 1);
    main.controllerNTAudios.registerConsumerUser("jkjk", "n", 1);
    main.controllerNTAudios.registerSong("hjhj", "hhh", 7, "jhjhj", "pop", 89, "p");
    main.controllerNTAudios.registerSong("you", "hhh", 7, "jhjhj", "pop", 89, "p");
    main.controllerNTAudios.registerPodcast("re", "jhhjhjhj", 9, "jhjhj", "policy", "u");
    main.controllerNTAudios.createAPlaylist("i", "l");
    main.controllerNTAudios.createAPlaylist("q", "l");*/
    

    int option = 0;

    do {

      option = main.getOptionShowMenu();
      main.executeOption(option);

    } while (option != 0);

    main.reader.close();
  }
  
  /**
   * uiRegisterProducerUsers: This method asks for the data needed to create a producer user: Artist or Content creator.
   */
  public void uiRegisterProducerUsers() {
    String nickname;
    String id;
    String name;
    String imageURL;
    int choice = 0;
    System.out.println("What type of producer user do you want to register?");
    System.out.println(
        "(1) Artist. \n" +
            "(2) Content creator.");
    choice = reader.nextInt();

    switch (choice) {
      case 1:
        System.out.println("<<< Register Artist >>>");
        System.out.println("Enter the artist's nickname.");
        nickname = reader.next();
        System.out.println("Enter the artist's ID.");
        id = reader.next();
        System.out.println("Enter the artist's name.");
        name = reader.next();
        System.out.println("Enter the URL of the artist's image or photo.");
        imageURL = reader.next();

        System.out.println(controllerNTAudios.registerProducerUser(nickname, id, name, imageURL, choice));
        break;

      case 2:
        System.out.println("<<< Register Content creator >>>");
        System.out.println("Enter the content creator's nickname.");
        nickname = reader.next();
        System.out.println("Enter the content creator's ID.");
        id = reader.next();
        System.out.println("Enter the content creator's name.");
        name = reader.next();
        System.out.println("Enter the URL of the content creator's image or photo.");
        imageURL = reader.next();

        System.out.println(controllerNTAudios.registerProducerUser(nickname, id, name, imageURL, choice));
        break;

      default:
        System.out.println("Invalid option.");
        break;
    }
  }
  
  /**
   * uiRegisterConsumerUsers: This method asks for the data needed to create a consumer user: Standard or Premium.
   */
  public void uiRegisterConsumerUsers() {
    String nickname;
    String id;
    int choice = 0;
    System.out.println("What type of consumer user do you want to register?");
    System.out.println(
        "(1) Standard. \n" +
            "(2) Premium.");
    choice = reader.nextInt();

    switch (choice) {
      case 1:
        System.out.println("<<< Register Standard user >>>");
        System.out.println("Enter the standard user's nickname.");
        nickname = reader.next();
        System.out.println("Enter the standard user's ID.");
        id = reader.next();

        System.out.println(controllerNTAudios.registerConsumerUser(nickname, id, choice));
        break;

      case 2:
        System.out.println("<<< Register Premium user >>>");
        System.out.println("Enter the premium user's nickname.");
        nickname = reader.next();
        System.out.println("Enter the premium user's ID.");
        id = reader.next();

        System.out.println(controllerNTAudios.registerConsumerUser(nickname, id, choice));
        break;

      default:
        System.out.println("Invalid option.");
        break;
    }
  }

  /**
   * uiRegisterAudios: This method asks for the data needed to create an audio: Song or Podcast.
   */
  public void uiRegisterAudios() {
    String name;
    String imageURL;
    double duration;
    String album;
    String musicalGenre;
    double saleValue;
    String description;
    String podcastCategory;
    String userId;
    int choice = 0;
    System.out.println("What type of audio do you want to register?");
    System.out.println(
        "(1) Song. \n" +
            "(2) Podcast.");
    choice = reader.nextInt();

    switch (choice) {
      case 1:
        System.out.println("<<< Register Song >>>");
        System.out.println("Enter the name of the song.");
        name = reader.next();
        System.out.println("Enter the URL of the album cover image to which the song belongs.");
        imageURL = reader.next();
        System.out.println("Enter the duration of the song.");
        duration = reader.nextDouble();
        System.out.println("Enter the album of the song.");
        album = reader.next();
        System.out.println("Enter the musical genre of the song.");
        musicalGenre = reader.next();
        System.out.println("Enter the sale value of the song.");
        saleValue = reader.nextDouble();
        System.out.println("Enter the ID of the artist to which the song belongs.");
        userId = reader.next();

        System.out
            .println(controllerNTAudios.registerSong(name, imageURL, duration, album, musicalGenre, saleValue, userId));
        break;

      case 2:
        System.out.println("<<< Register Podcast >>>");
        System.out.println("Enter the name of the podcast.");
        name = reader.next();
        System.out.println("Enter the URL of the distinctive image of the podcast.");
        imageURL = reader.next();
        System.out.println("Enter the duration of the podcast.");
        duration = reader.nextDouble();
        System.out.println("Enter the description of the podcast.");
        description = reader.next();
        System.out.println("Enter the podcast category.");
        podcastCategory = reader.next();
        System.out.println("Enter the ID of the content creator to which the podcast belongs.");
        userId = reader.next();

        System.out.println(
            controllerNTAudios.registerPodcast(name, imageURL, duration, description, podcastCategory, userId));
        break;

      default:
        System.out.println("Invalid option.");
        break;
    }

  }
  

  /**
   * uiCreateAPlaylist: This method asks for the data needed to create a playlist.
   */
  public void uiCreateAPlaylist() {
    String name;
    String consumerId;

    System.out.println("Enter the name of the playlist.");
    name = reader.next();
    System.out.println("Enter the ID of the consumer user who will have the playlist.");
    consumerId = reader.next();

    System.out.println(controllerNTAudios.createAPlaylist(name, consumerId));
  }

  /**
  * uiEditPlaylist: This method asks for the data needed to edit a playlist: add song or podcast to the playlist.
  */
  public void uiEditPlaylist() {
    String audioName;
    String producerId;
    String playlistName;
    String consumerId;
    System.out.println("What do you want to do? \n" + 
    "(1) Add an audio to the playlist. \n" + 
        "(2) Delete an audio from the playlist.");

    int option = 0;
    option = reader.nextInt();
    switch (option) {
      case 1:
      System.out.println("<<< Add audio to the playlist >>>");
      System.out.println("Enter the name of the audio you want to add to the playlist.");
      audioName = reader.next();
      System.out.println("Enter the ID of the producer user to which the audio you want to add belongs.");
      producerId = reader.next();
      System.out.println("Enter the name of the playlist you want to edit.");
      playlistName = reader.next();
      System.out.println("Enter the ID of the consumer user to which the playlist belongs.");
      consumerId = reader.next();

      System.out.println(controllerNTAudios.addAudioToThePlaylist(audioName, producerId, playlistName, consumerId));
        break;

      case 2:
        System.out.println("<<< Delete audio from the playlist >>>");
        System.out.println("Enter the name of the audio you want to remove from the playlist.");
        audioName = reader.next();
        System.out.println("Enter the ID of the producer user to which the audio you want to delete belongs.");
        producerId = reader.next();
        System.out.println("Enter the name of the playlist you want to edit.");
        playlistName = reader.next();
        System.out.println("Enter the ID of the consumer user to which the playlist belongs.");
        consumerId = reader.next();

        System.out.println(controllerNTAudios.deleteAudioFromThePlaylist(audioName, producerId, playlistName, consumerId));
        break;

      default:
      System.out.println("Invalid option.");
        break;
    }
  }

  public void uiSharePlaylist() {
    String consumerSharerId;
    String playlistName;
    long code;
    String codeToString;
    String consumerReceptorId;

    System.out.println("Enter the ID of the consumer user who will share the playlist.");
    consumerSharerId = reader.next();
    System.out.println("Enter the name of the playlist to be shared.");
    playlistName = reader.next();
    System.out.println(controllerNTAudios.runMatrix(playlistName, consumerSharerId));
    System.out.println("Enter the code of the playlist to be shared.");
    code = reader.nextLong();
    codeToString = Long.toString(code);
    System.out.println("Enter the ID of the user who will receive the playlist.");
    consumerReceptorId = reader.next();

    System.out.println(controllerNTAudios.sharePlaylist(consumerSharerId, codeToString, consumerReceptorId));
  }

  public void uiSimulateThePlaybackOfAnAudio() {
    String consumerId;
    String audioName;
    String playlistName;

    System.out.println("Enter the ID of the consumer user who has the audio to be played.");
    consumerId = reader.next();
    System.out.println("Enter the name of the audio to be played.");
    audioName = reader.next();
    System.out.println("Enter the name of the playlist where the audio to be played is located.");
    playlistName = reader.next();

    System.out.println(controllerNTAudios.simulateThePlaybackOfAnAudio(consumerId, audioName, playlistName));
  }

  public void uiBuySong() {
    String consumerId;
    String namePlaylist;
    String songName;
    double saleValue;

    System.out.println("Enter the ID of the user who wants to buy the song.");
    consumerId = reader.next();
    System.out.println("Enter the name of the playlist where the song to be purchased will be added.");
    namePlaylist = reader.next();
    System.out.println("Enter the name of the song to be purchased.");
    songName = reader.next();
    controllerNTAudios.showSong(songName);
    System.out.println("Enter the money.");
    saleValue = reader.nextDouble();

    System.out.println(controllerNTAudios.buySong(consumerId, namePlaylist, songName, saleValue));
  }

  /**
  * getOptionShowMenu: This method displays and allows to choose the option that the platform will execute.
  * @return option: int: Integer representing the option chosen by the user.
  */
  public int getOptionShowMenu() {
    int option = 0;
    System.out.println("<<<<< Welcome to NTAudios >>>>>");
    System.out.println(
    "(0) Exit. \n" +
    "(1) Register producer users: Artists and Content creators. \n" +
    "(2) Register consumer users: Standard and Premium. \n" +
    "(3) Register audios: songs and podcasts. \n" +
    "(4) Create a playlist. \n" +
    "(5) Edit a playlist. \n" + 
    "(6) Share a playlist. \n" + 
    "(7) Simulate the playback of a song or podcast. \n" + 
    "(8) Buy a song. \n" + 
    "(9) Generate reports with the registered data.");
    option = reader.nextInt();
    return option;
  }
  
  public void generateReports() {
    int option = 0;
    System.out.println(
    "(1) For audio types, report the total accumulated plays across the platform. \n" + 
    "(2) Report the name and number of plays of the most played song genre for a user. \n" + 
    "(3) Report the name and number of plays of the most played song genre for the platform. \n" + 
    "(4) Report the name and number of plays of the most listened podcast category for a user. \n" + 
    "(5) Report the name and number of plays of the most listened podcast category for the platform. \n" + 
    "(6) Report the name and number of plays of the top 5 artists and top 5 content creators. \n" + 
    "(7) Report the name, genre or category and total number of plays of the top 10 songs and top 10 podcasts. \n" + 
    "(8) Report the number of songs sold and total sales value for each genre. \n" + 
    "(9) Report the total number of sales and the total sales value of the best-selling song on the platform.");
    
    option = reader.nextInt();

    switch (option) {
      case 1:
      System.out.println("<<< For audio types, report the total accumulated plays across the platform >>>");
        break;

      case 2:
      System.out.println("<<< Report the name and number of plays of the most played song genre for a user >>>");
        break;

      case 3:
      System.out.println("<<< Report the name and number of plays of the most played song genre for the platform >>>");
        break;

      case 4:
      System.out.println("<<< Report the name and number of plays of the most listened podcast category for a user >>>");
        break;

      case 5:
      System.out.println("<<< Report the name and number of plays of the most listened podcast category for the platform >>>");
        break;
        
      case 6:
      System.out.println("<<< Report the name and number of plays of the top 5 artists and top 5 content creators >>>");
        break;

      case 7:
      System.out.println("<<< Report the name, genre or category and total number of plays of the top 10 songs and top 10 podcasts >>>");
        break;

      case 8:
      System.out.println("<<< Report the number of songs sold and total sales value for each genre >>>");
        break;

      case 9:
      System.out.println("<<< Report the total number of sales and the total sales value of the best-selling song on the platform >>>");
        break;

      default:
      System.out.println("Invalid option.");
        break;
    }
  }

  /**
  * executeOption: This method executes the option chosen by the user.
  * @param option: int: Integer representing the option chosen by the user.
  */
  public void executeOption(int option){

    switch (option) {
      case 0:
        System.out.println("Exit program.");
        break;
        
      case 1:
        System.out.println("<<< Register producer users: Artists and Content creators >>>");
        uiRegisterProducerUsers();
				break; 

      case 2:
        System.out.println("<<< Register consumer users: Standard and Premium >>>");
        uiRegisterConsumerUsers();
				break; 

      case 3:
        System.out.println("<<< Register audios: songs and podcasts >>>");
        uiRegisterAudios();
        break;
        
      case 4:
        System.out.println("<<< Create a playlist >>>");
        uiCreateAPlaylist();
        break;

      case 5:
        System.out.println("<<< Edit a playlist >>>");
        uiEditPlaylist();
        break;
        
      case 6:
        System.out.println("<<< Share a playlist >>>");
        uiSharePlaylist();
        break;

      case 7:
        System.out.println("<<< Simulate the playback of a song or podcast >>>");
        uiSimulateThePlaybackOfAnAudio();
        break;

      case 8:
        System.out.println("<<< Buy a song >>>");
        uiBuySong();
        break;

      case 9:
        System.out.println("<<< Generate reports with the registered data >>>");
        generateReports();
        break;

			default: 
				System.out.println("Invalid Option.");
				break; 
		}
	}
}
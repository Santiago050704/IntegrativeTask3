package ui;

import java.util.Scanner;

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

    System.out.println("<<< Create a playlist >>>");
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
    int choice = 0;

    System.out.println("<<< Edit a playlist >>>");
    System.out.println("What type of audio do you want to add to the playlist?");
    System.out.println(
      "(1) Song. \n" + 
      "(2) Podcast."
    );
    choice = reader.nextInt();
    switch (choice) {
      case 1:
        System.out.println("<<< Add a song to a playlist >>>");
        System.out.println("Enter the name of the song you want to add to the playlist.");
        audioName = reader.next();
        System.out.println("Enter the ID of the artist to which the song you want to add belongs.");
        producerId = reader.next();
        System.out.println("Enter the name of the playlist you want to edit.");
        playlistName = reader.next();
        System.out.println("Enter the ID of the consumer user to which the playlist belongs.");
        consumerId = reader.next();

        System.out.println(controllerNTAudios.editPlaylist(audioName, producerId, playlistName, consumerId, choice));
        break;

      case 2:
        System.out.println("<<< Add a podcast to a playlist >>>");
        System.out.println("Enter the name of the podcast you want to add to the playlist.");
        audioName = reader.next();
        System.out.println("Enter the ID of the content creator to which the podcast you want to add belongs.");
        producerId = reader.next();
        System.out.println("Enter the name of the playlist you want to edit.");
        playlistName = reader.next();
        System.out.println("Enter the ID of the consumer user to which the playlist belongs.");
        consumerId = reader.next();

        System.out.println(controllerNTAudios.editPlaylist(audioName, producerId, playlistName, consumerId, choice));
        break;

      default:
      System.out.println("Invalid option.");
        break;
    }
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
    "(5) Edit a playlist.");
    option = reader.nextInt();
    return option;
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

			default: 
				System.out.println("Invalid Option.");
				break; 
		}
	}
}
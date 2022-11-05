package ui;

import java.util.Scanner;

import model.MusicalGenre;
import model.NTAudios;

public class Main{
  private Scanner reader;
  private NTAudios controllerNTAudios;

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
    "(6) Share a playlist.");
    option = reader.nextInt();
    return option;
  }

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
				break; 

      case 6:
        System.out.println("<<< Share a playlist >>>");
        break;

			default: 
				System.out.println("Invalid Option.");
				break; 
		}
	}
}
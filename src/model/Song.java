package model;

/**
 * This class contains all the attributes and methods of a song.
 */
public class Song extends Audio {
  private String album;
  private MusicalGenre musicalGenre;
  private double saleValue;
  private int numberOfSales;

  /**
   * Song: This constructor method allows to initialize all the attributes of a song object.
   * @param name: String: Name of the song.
   * @param imageURL: String: URL of the album image of the song.
   * @param duration: double: Duration in minutes of the song.
   * @param album: String: Album to which the song belongs.
   * @param musicalGenre: MusicalGenre: Musical genre of the song.
   * @param saleValue: double: Sales value of the song.
   */
  public Song(String name, String imageURL, double duration, String album, MusicalGenre musicalGenre, double saleValue) {
    super(name, imageURL, duration);
    this.album = album;
    this.musicalGenre = musicalGenre;
    this.saleValue = saleValue;
    this.numberOfSales = 0;
  }
  
  /**
   * getAlbum: This method returns the album name of the song.
   * @return album: String: Album to which the song belongs.
   */
  public String getAlbum() {
    return album;
  }

  /**
   * getMusicalGenre: This method returns the musical genre of the song.
   * @return musicalGenre: String: Musical genre of the song.
   */
  public String getMusicalGenre() {
    return musicalGenre.toString();
  }

  /**
   * getSaleValue: This method returns the sale value of the song.
   * @return saleValue: double: Sales value of the song.
   */
  public double getSaleValue() {
    return saleValue;
  }

  /**
   * getNumberOfSales: This method returns the number of sales of the song.
   * @return numberOfSales: int: Number of sales of the song.
   */
  public int getNumberOfSales() {
    return numberOfSales;
  }
}
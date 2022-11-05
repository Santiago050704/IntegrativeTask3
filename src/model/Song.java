package model;

public class Song extends Audio {
  private String album;
  private MusicalGenre musicalGenre;
  private double saleValue;
  private int numberOfSales;

  public Song(String name, String imageURL, double duration, String album, MusicalGenre musicalGenre, double saleValue) {
    super(name, imageURL, duration);
    this.album = album;
    this.musicalGenre = musicalGenre;
    this.saleValue = saleValue;
    this.numberOfSales = 0;
  }
  
  public String getAlbum() {
    return album;
  }

  public String getMusicalGenre() {
    return musicalGenre.toString();
  }

  public double getSaleValue() {
    return saleValue;
  }

  public int getNumberOfSales() {
    return numberOfSales;
  }
}
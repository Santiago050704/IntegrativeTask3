package model;

public class Song extends Audio {
  private String album;
  private MusicalGenre musicalGenre;
  private double saleValue;
  private int numberOfSales;

  public Song(String name, String imageURL, double duration, int numberOfReproductions, String album, MusicalGenre musicalGenre, double saleValue, int numberOfSales) {
    super(name, imageURL, duration, numberOfReproductions);
    this.album = album;
    this.musicalGenre = musicalGenre;
    this.saleValue = saleValue;
    this.numberOfSales = numberOfSales;
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
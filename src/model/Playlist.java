package model;

import java.util.ArrayList;

public class Playlist {
  private String name;
  private int code;

  private ArrayList<Audio> audioList;

  public Playlist(String name, int code) {
    this.name = name;
    this.code = code;
    audioList = new ArrayList<Audio>();
  }
}
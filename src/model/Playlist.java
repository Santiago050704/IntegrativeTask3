package model;

import java.util.ArrayList;
import java.util.Random;

public class Playlist {
  private String name;
  private String code;
  private Random random;
  private int[][] codeMatrix;

  private ArrayList<Audio> audioList;

  public Playlist(String name) {
    this.name = name;
    code = null;
    audioList = new ArrayList<Audio>();
    codeMatrix = new int[6][6];
    fillMatrix(codeMatrix);
  }

  public String getName() {
    return name;
  }

  public void fillMatrix(int[][] codeMatrix) {
    random = new Random();
    for (int i = 0; i < codeMatrix.length; i++) {
      for (int j = 0; j < codeMatrix.length; j++) {
        codeMatrix[i][j] = random.nextInt(10);
      }
    }
  }

  public void showMatrix(int[][] codeMatrix) {
    for (int i = 0; i < codeMatrix.length; i++) {
      for (int j = 0; j < codeMatrix.length; j++) {
        System.out.print(codeMatrix[i][j]);
      }
      System.out.println("");
    }
  }

}
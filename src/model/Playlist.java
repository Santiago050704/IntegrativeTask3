package model;

import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.SourceDataLine;

/**
 * This class contains all the attributes and methods of a playlist.
 */
public class Playlist {
  private String name;
  private String code;
  private Random random;
  private int[][] codeMatrix;

  private ArrayList<Audio> audioList;

  /**
   * Playlist: This constructor method allows to initialize all the attributes of a playlist object.
   * @param name: String: Name of the playlist.
   */
  public Playlist(String name) {
    this.name = name;
    code = "";
    audioList = new ArrayList<Audio>();
    codeMatrix = new int[6][6];
    fillMatrix(codeMatrix);
  }

  /**
   * getName: Method to obtain the name of the playlist.
   * @return name: String: Name of the playlist.
   */
  public String getName() {
    return name;
  }

  /**
   * getAudioList: Method that returns the arraylist of audios of class playlist.
   * @return audioList: ArrayList<Audio>: Arraylist of audios.
   */
  public ArrayList<Audio> getAudioList() {
    return audioList;
  }

  /**
   * getCodeMatrix: Method that returns the matrix of a playlist.
   * @return codeMatrix: int[][]: Playlist matrix.
   */
  public int[][] getCodeMatrix() {
    return codeMatrix;
  }

  /**
   * setCode: Method that allows to edit the playlist code.
   * @param num: int: Integer to be converted to String to be concatenated to the code.
   */
  public void setCode(int num) {
    code += Integer.toString(num);
  }

  public void resetPlaylistCode() {
    code = "";
  }

  /**
   * getCode: Method to obtain the playlist code.
   * @return code: String: Auto-generated matrix code, which is generated depending on the contents of the matrix.
   */
  public String getCode() {
    return code;
  }

  /**
   * fillMatrix: Method that allows to fill the playlist matrix with random numbers from 0 to 9.
   * @param codeMatrix: int[][]: Matrix to be filled.
   */
  public void fillMatrix(int[][] codeMatrix) {
    random = new Random();
    for (int i = 0; i < codeMatrix.length; i++) {
      for (int j = 0; j < codeMatrix.length; j++) {
        codeMatrix[i][j] = random.nextInt(10);
      }
    }
  }

  /**
   * showMatrix: Method that allows to display the content of the playlist matrix.
   * @param codeMatrix: int[][]: Matrix to be displayed.
   * @return msj: String: Message displayed by the matrix.
   */
  public String showMatrix(int[][] codeMatrix) {
    String msj = "";
    for (int i = 0; i < codeMatrix.length; i++) {
      for (int j = 0; j < codeMatrix.length; j++) {
        msj += Integer.toString(codeMatrix[i][j]) + "  ";
        if (j == 5) {
          msj += "\n";
        }
        //System.out.print(codeMatrix[i][j]);
        
      }
      //System.out.println("");
      
    }
    return msj;
  }
}
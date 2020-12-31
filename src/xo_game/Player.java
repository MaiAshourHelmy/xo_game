
package xo_game;


public class Player {
   private static String name;
  private static String userName; 
  private static int totalScore; 

    public Player() {
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Player.userName = userName;
    }

    public static int getTotalScore() {
        return totalScore;
    }

    public static void setTotalScore(int totalScore) {
        Player.totalScore = totalScore;
    }
     
}

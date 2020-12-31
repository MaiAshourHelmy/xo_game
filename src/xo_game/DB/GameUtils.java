
package xo_game.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

public class GameUtils {
   private Connection connection;
    private PreparedStatement pst = null;
    private ResultSet rs;
    private Statement stmt = null;

    public GameUtils() {
        try {

            DriverManager.registerDriver(new ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/TICTACTOE", "AHM", "AHM");
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           /* rs = stmt.executeQuery("SELECT * FROM PLAYER ");
            rs.first();*/

        } catch (SQLException ex) {
            System.out.println("3" + ex.getMessage());
        }
    }
    public void exist(){
        try {
            if(!connection.isClosed()){
                connection.close();
                pst.close();
                rs.close();
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("4" + ex.getMessage());
        }
    } 
    public int insertGame(String userName1, String userName2, int score1, int score2) throws SQLException {
        System.out.println(userName1 + " " + userName2 + " "+ score1+ " "+  score2);
        // SQL Insert
        String sql = "INSERT INTO GAME (USER_NAME_1, USER_NAME_2, SCORE_1, SCORE_2) VALUES (?, ?, ?, ?)";

        pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, userName1);
        pst.setString(2, userName2);
        pst.setInt(3, score1);
        pst.setInt(4, score2);
       int rows = pst.executeUpdate();
       System.out.println("rows = " + rows);
       return rows;

    }
    public void insertRcord(String index, String value) throws SQLException {
        System.out.println(index + " " + value);
        // SQL Insert
        String sql = "INSERT INTO RECORD (SEQINDEX, SEQVALUE) VALUES (?,?)";

        pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, index);
        pst.setString(2, value);
       
       int rows = pst.executeUpdate();
       System.out.println("rows = " + rows);
      

    }
    public String selectRecord(){
         String record = "";
       try {
          
           rs = stmt.executeQuery("SELECT * FROM RECORD ");
           rs.first();
          record += rs.getString(2);
           record += "#" + rs.getString(3);
          
       } catch (SQLException ex) {
           Logger.getLogger(GameUtils.class.getName()).log(Level.SEVERE, null, ex);
       }
        return record;
    }
}

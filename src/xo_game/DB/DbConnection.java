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

public class DbConnection {

    private Connection connection;
    // private static DbConnection single_instance = null; 
    private PreparedStatement pst = null;
    private ResultSet rs;
    private Statement stmt = null;

    public DbConnection() {
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
//  public static DbConnection getInstance() 
//    { 
//        if (single_instance == null) 
//            single_instance = new DbConnection(); 
//  
//        return single_instance; 
//    }

    public int signUp(String name, String userName, String password) throws SQLException {
        int isSignUp = 0;
        if (checkUserNameIsExist(userName)) {
            isSignUp = 1;
            System.out.println("eeeeeeeee");
            return isSignUp;
        }
        // SQL Insert
        String sql = "INSERT INTO PLAYER (NAME_PLAYER,USER_NAME,PASSWORD) VALUES (?,?,?)";

        pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, name);
        pst.setString(2, userName);
        pst.setString(3, password);
        pst.executeUpdate();
       // rs.absolute(-1);
       
        return isSignUp;

    }

    public String LogIn(String userName, String password) {
        int isExist = 0;
        String returnUserName = "0";
        try {
            String sql = "SELECT * FROM   PLAYER WHERE USER_NAME = ? AND PASSWORD = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, userName);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                isExist = 1;
                returnUserName = "1" + userName;
            }
           
            
        } catch (SQLException ex) {
           System.out.println("5" + ex.getMessage());
        }

        return returnUserName;
    }

    private boolean checkUserNameIsExist(String userName) {
        boolean isExist = false;
        try {
            String sql = "SELECT * FROM   PLAYER WHERE USER_NAME = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, userName);
            rs = pst.executeQuery();
            if (rs.next()) {
                isExist = true;
            }
            
        } catch (SQLException ex) {
           System.out.println("6" + ex.getMessage());
        }
       return isExist;
    }
    public String returnPlayerName(String userName){
        String name = "";
        try {
             //rs = stmt.executeQuery("SELECT * FROM PLAYER ");
          //  rs.first();
            String sql = "SELECT * FROM   PLAYER WHERE USER_NAME = ? ";
            pst = connection.prepareStatement(sql);
            pst.setString(1, userName);
            rs = pst.executeQuery();
           if( rs.next()){ name = rs.getString(2);}
          
            System.out.println("name = " + name);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

}

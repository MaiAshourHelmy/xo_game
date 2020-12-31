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

//            rs = stmt.executeQuery("SELECT * FROM GAME ");
            /* rs = stmt.executeQuery("SELECT * FROM PLAYER ");
            rs.first();*/
        } catch (SQLException ex) {
            System.out.println("3" + ex.getMessage());
        }
    }

    public void exist() {
        try {
            if (!connection.isClosed()) {
                connection.close();
                pst.close();
                rs.close();
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("4" + ex.getMessage());
        }
    }

    private int returnId(String userName) {
        int idPlayer = -1;
        try {
            String sql = "SELECT ID FROM PLAYER WHERE USER_NAME = ?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, userName);
            rs = pst.executeQuery();
            if (rs.next()) {
                idPlayer = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("6" + ex.getMessage());
        }

        return idPlayer;
    }

    public int insertGame(String userWinner, String userLoser, String isTied, String index, String value, boolean isRecord) throws SQLException {
//        System.out.println(userName1 + " " + userName2 + " "+ score1+ " "+  score2);
        // SQL Insert
        String sql = "INSERT INTO GAME (PLAYER_WINNER, PLAYER_LOSER, GAME_TIED) VALUES (?, ?, ?)";

        pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, userWinner);
        pst.setString(2, userLoser);
        pst.setString(3, isTied);
//        pst.setInt(4, score2);
        int rows = -1;
        rows = pst.executeUpdate();
        int idGame = -1;
        if (rows != -1) {
            if (rows > 0) {
                // get the ID back
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGame = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
//            int idGame = rs.getInt(1);
            System.out.println("ID GAme :" + idGame);
            System.out.println("userWinner :" + userWinner);
            System.out.println("userLoser :" + userLoser);

            int idWinner = -1, idLoser = -1;

            if (!userWinner.equals("Computer") && !userWinner.equals("Player 2")) {
                idWinner = returnId(userWinner);
            }

            if (!userLoser.equals("Computer") && !userLoser.equals("Player 2")) {
                idLoser = returnId(userLoser);
            }
            
            System.out.println(idWinner);
            System.out.println(idLoser);

            insertPlayerGame(idGame, 2, 2);
//
            if (isRecord) {
                insertRcord(index, value, idGame);
            }

        }

        System.out.println("rows = " + rows);

        return rows;
    }

    public void insertPlayerGame(int IDGame, int IDPlayer1, int IDPlayer2) throws SQLException {
//        System.out.println(index + " " + value);
        // SQL Insert
        String sql = "INSERT INTO PLAYER_GAME (ID_GAME, ID_PLAYER1,ID_PLAYER2) VALUES (?,?,?)";

        pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, IDGame);
        pst.setInt(2, IDPlayer1);
        pst.setInt(3, IDPlayer2);

        int rows = pst.executeUpdate();

        System.out.println("rows = " + rows);
    }

    public void insertRcord(String index, String value, int GAMEID) throws SQLException {
        System.out.println(index + " " + value);
        // SQL Insert
        String sql = "INSERT INTO RECORD (INDEX, CHAR_VALUE,GAMED_ID) VALUES (?,?,?)";

        pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, index);
        pst.setString(2, value);
        pst.setInt(3, GAMEID);

        int rows = pst.executeUpdate();
        System.out.println("rows = " + rows);
    }

    public String selectRecord() {
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

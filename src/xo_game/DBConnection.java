package xo_game;

import org.apache.derby.jdbc.ClientDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mai
 */
public class DBConnection {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    Statement stmt = null;

    // to initialize the data base
    DBConnection() {
        initDB();
    }

    public void initDB() {

        try {

            DriverManager.registerDriver(new ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/XO_DB", "AHM", "ahm123456789");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    // to insert the user info into data base
    public void insertDB(String name, String user_name, String password) throws SQLException {
        // SQL Insert
        String sql = "INSERT INTO USER_INFO (NAME,USER_NAME,PASSWORD) VALUES (?,?,?)";

        pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, name);
        pst.setString(2, user_name);
        pst.setString(3, password);
        pst.executeUpdate();
        /*if(!pst.isClosed())
{​​
pst.close();
}​​*/

    }

    public void selectDB(String name, String user_name, String password) {

    }

}

package xo_game.server;

import xo_game.DB.DbConnection;
import xo_game.DB.GameUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread {

    BufferedReader dis;
    PrintStream ps;
    String str = null;
    String[] signUpInput = null;
    DbConnection utils;
    GameUtils game;
    int r;
    static Vector<ClientHandler> clientsVector
            = new Vector<ClientHandler>();

    public ClientHandler(Socket cs) {
        try {

            utils = new DbConnection();
            game = new GameUtils();
            dis = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            ps = new PrintStream(cs.getOutputStream());
            r = 0;
            clientsVector.add(this);
            start();
        } catch (IOException ex) {
            System.out.println("1" + ex.getMessage());
        }
    }

    public void run() {
        while (true) {
            try {

                str = dis.readLine();
                System.out.println("str = " + str);
                splitInput(str);
                switch (signUpInput[0]) {
                    case "signUp": {
                        signUp();
                        break;
                    }
                    case "logIn": {
                        logIn();
                        break;
                    }
                    case "exist": {
                        utils.exist();
                        game.exist();
                        return;
                    }
                    case "nameOfPlayer": {
                        String name = utils.returnPlayerName(signUpInput[1]);
                        System.out.println("name = " + name);
                        ps.println(name);
                        break;
                    }
                    case "game": {
                        try {
                           game.insertGame(signUpInput[1], signUpInput[2], Integer.parseInt(signUpInput[3]), Integer.parseInt(signUpInput[4]));
                            System.out.println("hello");
                        } catch (SQLException ex) {
                            System.out.println("game " + ex.getMessage());
                        }
                        break;
                    }
                    case "insertRecord":{
                        game.insertRcord(signUpInput[1], signUpInput[2]);
                        break;
                    }case "returnRecord":{
                    System.out.println("selectRecord = " + game.selectRecord());
                      ps.println(game.selectRecord());
                        break;
                    }
                }

            } catch (IOException ex) {
                System.out.println("2" + ex.getMessage());
                return;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void splitInput(String input) {
        signUpInput = null;
        signUpInput = str.split("#");
       
    }


    private void signUp() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    r = utils.signUp(signUpInput[1], signUpInput[2], signUpInput[3]);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                ps.println(r);
            }
        }).start();
    }

    private void logIn() {
        new Thread(new Runnable() {

            @Override
            public void run() {

                String r = utils.LogIn(signUpInput[1], signUpInput[2]);

                ps.println(r);
            }
        }).start();
    }
}

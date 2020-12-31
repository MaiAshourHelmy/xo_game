
package xo_game.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer {

    ServerSocket serverSocket;
    
    public TicTacToeServer(){
        try {
            serverSocket = new ServerSocket(5005);
            while (true) {
            Socket s = serverSocket.accept();
            new ClientHandler(s);
        }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public static void main(String[] args) {
        new TicTacToeServer();
    }
}

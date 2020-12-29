/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntializeSocket {
   private Socket mySocket;
   private BufferedReader dis;
   private PrintStream ps;

    public IntializeSocket() {
       try {
           mySocket = new Socket("127.0.0.1", 5005);
           dis = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
           ps = new PrintStream(mySocket.getOutputStream());
       } catch (IOException ex) {
           Logger.getLogger(IntializeSocket.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public BufferedReader getDis() {
        return dis;
    }

    public PrintStream getPs() {
        return ps;
    }

   
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo_game;

import java.awt.Button;

/**
 *
 * @author mai
 */
public class my_object {
    String player1;
    String player2;
    String winner;
    String loser;
    boolean tie;

    public my_object(String player1, String player2, String winner, String loser,boolean tie) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
        this.loser = loser;
        this.tie = tie;
    }
    
    
}

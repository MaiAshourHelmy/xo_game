/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author abdelrahman
 */
public class Game {

    
    // creating class enum
    public enum Board {
        EMPTY, X, O
    };

    
    private Board currentPlayer = Board.X;

    
    // Declaration 2D arr from Board
    private Board[] board;

    
    // Default Constructor
    public Game() {
        // Initialization 2D arr from Board
        board = new Board[9];

        // reset values of array
        for (int i = 0; i < 9; i++) {
            //    for (int j = 0; j < 3; j++) {
            board[i] = Board.EMPTY;
            //    }
        }
    }

    
    public void resetBoard() {

        // reset values of array
        for (int i = 0; i < 9; i++) {
            board[i] = Board.EMPTY;
        }

    }
    
//    // thread when player tries a move
//    public synchronized boolean move(int location, Player player) {
//        if (player == currentPlayer && board[location] == null) {
//            board[location] = currentPlayer;
//            currentPlayer = currentPlayer.opponent;
//            currentPlayer.otherPlayerMoved(location);
//            return true;
//        }
//        return false;
//    }

    public boolean isFullBoard() {

        // reset values of array
        for (int i = 0; i < 9; i++) {
            if (board[i] == Board.O || board[i] == Board.X) {
                return true;
            }
        }

        return false;
    }

    
    public Board getCurrentPlayer() {
        return currentPlayer;
    }

    
    public void setCurrentPlayer(Board currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    // get specific item from array
    public Board getBoard(int x) {
        return board[x];
    }

    
    public void chooseAplayer(JLabel l) {

        if (currentPlayer == Board.X) {

            currentPlayer = Board.O;
            l.setText("O turn");
        } else {
            currentPlayer = Board.X;
            l.setText("X turn");
        }

    }

    
    // set specific item from array
    public boolean setBoard(int x, Board b) {

        // check item of array empty or not
        if (board[x] == Board.EMPTY) {
            board[x] = b;
            return true;
        } else {
            return false;
        }
    }

    
    public boolean indexIsEmptyOrNot(int x) {

        // check item of array empty or not
        return board[x] == Board.EMPTY;
        
    }


    public boolean hasWinner() {
        return (board[0] != Board.EMPTY && board[0] == board[1] && board[0] == board[2])
                || (board[3] != Board.EMPTY && board[3] == board[4] && board[3] == board[5])
                || (board[6] != Board.EMPTY && board[6] == board[7] && board[6] == board[8])
                || (board[0] != Board.EMPTY && board[0] == board[3] && board[0] == board[6])
                || (board[1] != Board.EMPTY && board[1] == board[4] && board[1] == board[7])
                || (board[2] != Board.EMPTY && board[2] == board[5] && board[2] == board[8])
                || (board[0] != Board.EMPTY && board[0] == board[4] && board[0] == board[8])
                || (board[2] != Board.EMPTY && board[2] == board[4] && board[2] == board[6]);
    }
    

    public static int getIndexFromBoard(String nameLabel) {

        int index = -1;

        switch (nameLabel) {
            case "1":
                index = 0;
                break;
            case "2":
                index = 1;
                break;
            case "3":
                index = 2;
                break;
            case "4":
                index = 3;
                break;
            case "5":
                index = 4;
                break;
            case "6":
                index = 5;
                break;
            case "7":
                index = 6;
                break;
            case "8":
                index = 7;
                break;
            case "9":
                index = 8;
                break;

        }

        return index;
    }

    
    public int genRandmInt() {
        Random rand = new Random();

        return rand.nextInt((8 - 1) + 1) + 1;
        //return rand.nextInt(9);
    }

}

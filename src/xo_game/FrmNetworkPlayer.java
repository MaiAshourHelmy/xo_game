/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo_game;

import model.Game;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author abdelrahman
 */
public class FrmNetworkPlayer extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
   
    private static int PORT = 5005;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    Game g = new Game();
    int index = 0;
    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    boolean isFull = false;
    
    public FrmNetworkPlayer() {
        initComponents();
        
        try {
            // Setup networking
            socket = new Socket("127.0.0.1", PORT);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            
        } catch (IOException ex) {
            Logger.getLogger(FrmNetworkPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setNameLabels();
        //lTurn.setText("Player one turn");

    }
    
    public void play() throws Exception {
        String response;
        try {
            response = in.readLine();
            System.out.println(response);
            if (response.startsWith("WELCOME")) {
                char mark = response.charAt(8);
                System.out.println(mark);

//                icon = new ImageIcon(mark == 'X' ? "E:\\Abdulrahman M. Hsn\\ITP\\Java\\Labs\\Lab9\\TicTacToeGame\\src\\tictactoegame\\x.gif" : "E:\\Abdulrahman M. Hsn\\ITP\\Java\\Labs\\Lab9\\TicTacToeGame\\src\\tictactoegame\\o.gif");
//                opponentIcon = new ImageIcon(mark == 'X' ? "E:\\Abdulrahman M. Hsn\\ITP\\Java\\Labs\\Lab9\\TicTacToeGame\\src\\tictactoegame\\o.gif" : "E:\\Abdulrahman M. Hsn\\ITP\\Java\\Labs\\Lab9\\TicTacToeGame\\src\\tictactoegame\\x.gif");
//
//                frame.setTitle("Tic Tac Toe - Player " + mark);
                lTurn.setText("Tic Tac Toe - Player " + mark);
            }
            while (true) {
                response = in.readLine();
                if (response.startsWith("VALID_MOVE")) {
                    lTurn.setText("Valid move, please wait");
                    
                } else if (response.startsWith("OPPONENT_MOVED")) {
                    int loc = Integer.parseInt(response.substring(15));
//                    board[loc].setIcon(opponentIcon);
//                    board[loc].repaint();
                    lTurn.setText("Opponent moved, your turn");
                } else if (response.startsWith("VICTORY")) {
                    lTurn.setText("You win");
                    break;
                } else if (response.startsWith("DEFEAT")) {
                    lTurn.setText("You lose");
                    break;
                } else if (response.startsWith("TIE")) {
                    lTurn.setText("You tied");
                    break;
                } else if (response.startsWith("MESSAGE")) {
                    lTurn.setText(response.substring(8));
                    System.out.println(response.substring(8));
                }
            }
            out.println("QUIT");
        } finally {
            socket.close();
        }
    }
    
    private void setNameLabels() {
        
        jLabel1.setName("1");
        jLabel2.setName("2");
        jLabel3.setName("3");
        jLabel4.setName("4");
        jLabel5.setName("5");
        jLabel6.setName("6");
        jLabel7.setName("7");
        jLabel8.setName("8");
        jLabel9.setName("9");
        
    }
    
    private void ReDraw() {
        String one = jLabel1.getText();
        String two = jLabel2.getText();
        String three = jLabel3.getText();
        String four = jLabel4.getText();
        String five = jLabel5.getText();
        String six = jLabel6.getText();
        String seven = jLabel7.getText();
        String eight = jLabel8.getText();
        String nine = jLabel9.getText();
        
        if (one != "" && two != "" && three != "" && four != "" && five != "" && six != "" && seven != "" && eight != "" && nine != "") {
            JOptionPane.showMessageDialog(this, "The match has been drawn !!!", "Match result", JOptionPane.INFORMATION_MESSAGE);
            isFull = true;
            resetLabels();
        }
        
    }
    
    private void resetLabels() {
        
        jLabel1.setText("");
        jLabel2.setText("");
        jLabel3.setText("");
        jLabel4.setText("");
        jLabel5.setText("");
        jLabel6.setText("");
        jLabel7.setText("");
        jLabel8.setText("");
        jLabel9.setText("");
        
        g.resetBoard();
        g.chooseAplayer(lTurn);
        
    }
    
    private void xWins() {
        JOptionPane.showMessageDialog(this, "X WINS", "Winner", JOptionPane.INFORMATION_MESSAGE);
        isFull = true;
        resetLabels();
    }
    
    private void oWins() {
        JOptionPane.showMessageDialog(this, "O WINS", "Winner", JOptionPane.INFORMATION_MESSAGE);
        isFull = true;
        resetLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBoard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lPlayer1 = new javax.swing.JLabel();
        lTurn = new javax.swing.JLabel();
        lscorePlayer2 = new javax.swing.JLabel();
        lPlayer3 = new javax.swing.JLabel();
        lscorePlayer1 = new javax.swing.JLabel();
        exit_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(186, 79, 84));
        setMinimumSize(new java.awt.Dimension(611, 388));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBoard.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBoard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelBoard.setLayout(new java.awt.GridLayout(3, 3));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 186, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(122, 181, 148));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(189, 32, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(105, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(162, 72, 126));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(168, 162, 48));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel6, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(78, 121, 185));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(224, 124, 42));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel8, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Bodoni MT Poster Compressed", 1, 120)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(193, 24, 23));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 10));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel9, java.awt.BorderLayout.CENTER);

        jPanelBoard.add(jPanel11);

        getContentPane().add(jPanelBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 790, 420));

        jPanel3.setBackground(new java.awt.Color(186, 79, 84));
        jPanel3.setForeground(new java.awt.Color(186, 79, 84));

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnReset.setForeground(new java.awt.Color(120, 0, 46));
        btnReset.setText("Restart");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 20));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnExit1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnExit1.setForeground(new java.awt.Color(120, 0, 46));
        btnExit1.setText("Back");
        btnExit1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 20));
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 460, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 890, 550));

        jPanel2.setBackground(new java.awt.Color(120, 0, 46));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setEnabled(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(611, 100));

        lPlayer1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lPlayer1.setForeground(new java.awt.Color(255, 255, 255));
        lPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPlayer1.setText("Player 1");

        lTurn.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lTurn.setForeground(new java.awt.Color(255, 255, 255));
        lTurn.setText("Turn");

        lscorePlayer2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lscorePlayer2.setForeground(new java.awt.Color(255, 255, 255));
        lscorePlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lscorePlayer2.setText("0");

        lPlayer3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lPlayer3.setForeground(new java.awt.Color(255, 255, 255));
        lPlayer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPlayer3.setText("Player 2");

        lscorePlayer1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lscorePlayer1.setForeground(new java.awt.Color(255, 255, 255));
        lscorePlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lscorePlayer1.setText("0");

        exit_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-close-window-40.png"))); // NOI18N
        exit_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_labelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lPlayer3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 603, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lscorePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lTurn)
                        .addGap(262, 262, 262)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lPlayer1)
                    .addComponent(lscorePlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(exit_label))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exit_label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lPlayer3)
                        .addComponent(lPlayer1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lscorePlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lscorePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Sounds.playSound("game.wav");        
        playing(jLabel1);
    }//GEN-LAST:event_jLabel1MouseClicked
    

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Sounds.playSound("game.wav");        
        playing(jLabel2);
    }//GEN-LAST:event_jLabel2MouseClicked
    

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Sounds.playSound("game.wav");
        playing(jLabel3);
    }//GEN-LAST:event_jLabel3MouseClicked
    

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Sounds.playSound("game.wav");
        playing(jLabel4);
    }//GEN-LAST:event_jLabel4MouseClicked
    

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Sounds.playSound("game.wav");
        playing(jLabel5);
    }//GEN-LAST:event_jLabel5MouseClicked
    

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Sounds.playSound("game.wav");
        playing(jLabel6);
    }//GEN-LAST:event_jLabel6MouseClicked
    

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Sounds.playSound("game.wav");
        playing(jLabel8);

    }//GEN-LAST:event_jLabel8MouseClicked
    

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Sounds.playSound("game.wav");
        playing(jLabel9);
    }//GEN-LAST:event_jLabel9MouseClicked
    

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Sounds.playSound("game.wav");
        playing(jLabel7);
    }//GEN-LAST:event_jLabel7MouseClicked
    
    

    private void exit_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit_labelMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        Sounds.playSound("buttonClick.wav");
        resetLabels();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        Sounds.playSound("buttonClick.wav");
        game_modes gm =new game_modes();
        gm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExit1ActionPerformed
    
    private void playing(JLabel label) {
        
        index = Game.getIndexFromBoard(label.getName());
        
        if (g.setBoard(index, g.getCurrentPlayer())) {
            label.setText(g.getBoard(index).toString());
        }
        
        if (g.hasWinner()) {
            System.out.println("player " + g.getCurrentPlayer());
            if (g.getCurrentPlayer().toString() == "X") {
                xWins();
                scorePlayerOne += 1;
                lscorePlayer1.setText(String.valueOf(scorePlayerOne));
                
            } else {
                oWins();
                scorePlayerTwo += 1;
                lscorePlayer2.setText(String.valueOf(scorePlayerTwo));
                g.setCurrentPlayer(Game.Board.O);
            }
            
            g.chooseAplayer(lTurn);
            ReDraw();
        } else {
            
            g.chooseAplayer(lTurn);
            ReDraw();
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmNetworkPlayer().setVisible(true);
        FrmNetworkPlayer fnp = new FrmNetworkPlayer();
        fnp.setVisible(true);
        try {
            fnp.play();
        } catch (Exception ex) {
            Logger.getLogger(FrmNetworkPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel exit_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelBoard;
    private javax.swing.JLabel lPlayer1;
    private javax.swing.JLabel lPlayer3;
    private javax.swing.JLabel lTurn;
    private javax.swing.JLabel lscorePlayer1;
    private javax.swing.JLabel lscorePlayer2;
    // End of variables declaration//GEN-END:variables
}

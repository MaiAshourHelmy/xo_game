/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo_game;

import model.Record;
import model.IntializeSocket;
import model.Game;
import model.Player;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author abdelrahman
 */
public class FrmSinglePlayer extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
  
    Game g = new Game();
    int index = 0;
    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    boolean isFull = false;
    String nameOfPlayer1 = "";
    IntializeSocket socket;
    ArrayList<Record> record;

    public FrmSinglePlayer() {
        initComponents();
        setNameLabels();
        socket = new IntializeSocket();
        record = new ArrayList<>();
        lTurn.setText("Player one turn");
        socket.getPs().println("nameOfPlayer#" + Player.getUserName());
        try {
            nameOfPlayer1 = socket.getDis().readLine();
            System.out.println("nameOfPlayer1 = " + nameOfPlayer1);
            Player.setName(nameOfPlayer1);
            lPlayer1.setText(Player.getName());
            lPlayer3.setText("Robot");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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
            createDialogSaveRecord();
//            scorePlayerOne = 0;
//            scorePlayerTwo = 0;
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

    private void registerMovesInDb(boolean isRecord) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String index = "";
                String value = "";
//                            String userWinner, String userLoser, boolean isTied, String index, String value, boolean isRecord

                for (int i = 0; i < record.size(); i++) {
                    index += String.valueOf(record.get(i).getIndex());
                    value += String.valueOf(record.get(i).getValue());
                }

                System.out.println("is Full" + isFull);
                if (isFull) {
                    socket.getPs().println("game#" + "" + "#" + "" + "#" + "true" + "#" + index + "#" + value + "#" + isRecord);
                } else {

                    System.out.println("S" + scorePlayerOne);
                    System.out.println("S" + scorePlayerTwo);
                    if (scorePlayerOne == 1) {
                        System.out.println("playeeeeeeeeeeeeeeeeeeeeeer");
                        socket.getPs().println("game#" + Player.getUserName() + "#" + "Robot" + "#" + "false" + "#" + index + "#" + value + "#" + isRecord);
                    } else {
                        System.out.println("Roboooooooooooooooot");
                        socket.getPs().println("game#" + "Robot" + "#" + Player.getUserName() + "#" + "false" + "#" + index + "#" + value + "#" + isRecord);
                    }
                }

                record.removeAll(record);
                System.out.println("size: " + record.size());

                scorePlayerOne = 0;
                scorePlayerTwo = 0;
            }
        }).start();

//        scorePlayerOne = 0;
//        scorePlayerTwo = 0;
    }

    private void xWins() {
        JOptionPane.showMessageDialog(this, "X WINS", "Winner", JOptionPane.INFORMATION_MESSAGE);
//        createDialogSaveRecord();
        resetLabels();
    }

    private void oWins() {
        JOptionPane.showMessageDialog(this, "O WINS", "Winner", JOptionPane.INFORMATION_MESSAGE);
//        createDialogSaveRecord();
        resetLabels();
    }

    private void playingRobot(JLabel label) {

        index = Game.getIndexFromBoard(label.getName());

        if (g.setBoard(index, g.getCurrentPlayer())) {
            label.setText(g.getBoard(index).toString());
        }

        if (g.hasWinner()) {
            System.out.println("player " + g.getCurrentPlayer());
            if (g.getCurrentPlayer().toString() == "X") {
                xWins();
                scorePlayerOne += 1;

            } else {
                oWins();
                scorePlayerTwo += 1;
                g.setCurrentPlayer(Game.Board.O);
            }
            
            createDialogSaveRecord();
        }

        g.chooseAplayer(lTurn);
        ReDraw();
    }

    private void playRopot() {

        while (true) {
            int position = g.genRandmInt();
            Record r1 = new Record(position, 'O');
            record.add(r1);
            System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());

            if (g.indexIsEmptyOrNot(position)) {
                setXORO(position);
                //System.out.println("empty");
                break;
            } else {

                if (!g.indexIsEmptyOrNot(0) && !g.indexIsEmptyOrNot(1) && !g.indexIsEmptyOrNot(2) && !g.indexIsEmptyOrNot(3) && !g.indexIsEmptyOrNot(4)
                        && !g.indexIsEmptyOrNot(5) && !g.indexIsEmptyOrNot(6) && !g.indexIsEmptyOrNot(7) && !g.indexIsEmptyOrNot(8)) {
                    break;
                }

            }

        }

    }

    private void setXORO(int position) {

        switch (position) {
            case 0:
                if (jLabel1.getText().toString() == "") {
                    playingRobot(jLabel1);
                }
                break;
            case 1:
                if (jLabel2.getText().toString() == "") {
                    playingRobot(jLabel2);
                }
                break;
            case 2:
                if (jLabel3.getText().toString() == "") {
                    playingRobot(jLabel3);
                }
                break;
            case 3:
                if (jLabel4.getText().toString() == "") {
                    playingRobot(jLabel4);
                }
                break;
            case 4:
                if (jLabel5.getText().toString() == "") {
                    playingRobot(jLabel5);
                }
                break;
            case 5:
                if (jLabel6.getText().toString() == "") {
                    playingRobot(jLabel6);
                }
                break;
            case 6:
                if (jLabel7.getText().toString() == "") {
                    playingRobot(jLabel7);
                }
                break;
            case 7:
                if (jLabel8.getText().toString() == "") {
                    playingRobot(jLabel8);
                }
                break;
            case 8:
                if (jLabel9.getText().toString() == "") {
                    playingRobot(jLabel9);
                }
                break;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lPlayer1 = new javax.swing.JLabel();
        lTurn = new javax.swing.JLabel();
        lscorePlayer2 = new javax.swing.JLabel();
        lPlayer3 = new javax.swing.JLabel();
        lscorePlayer1 = new javax.swing.JLabel();
        exit_label = new javax.swing.JLabel();
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
        btnExit1 = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(186, 79, 84));
        setMinimumSize(new java.awt.Dimension(611, 388));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        lscorePlayer2.setText("o");

        lPlayer3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lPlayer3.setForeground(new java.awt.Color(255, 255, 255));
        lPlayer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPlayer3.setText("Player 2");

        lscorePlayer1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lscorePlayer1.setForeground(new java.awt.Color(255, 255, 255));
        lscorePlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lscorePlayer1.setText("X");

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
                    .addComponent(lPlayer3)
                    .addComponent(lscorePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(271, 271, 271)
                .addComponent(lTurn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lscorePlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lPlayer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit_label))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lPlayer1)
                            .addComponent(lPlayer3)))
                    .addComponent(exit_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lscorePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lscorePlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

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

        getContentPane().add(jPanelBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 800, 430));

        jPanel3.setBackground(new java.awt.Color(186, 79, 84));
        jPanel3.setForeground(new java.awt.Color(186, 79, 84));

        btnExit1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnExit1.setForeground(new java.awt.Color(120, 0, 46));
        btnExit1.setText("Back");
        btnExit1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 20));
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnReset.setForeground(new java.awt.Color(120, 0, 46));
        btnReset.setText("Restart");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 20));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(460, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 890, 550));

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

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        Sounds.playSound("buttonClick.wav");
        game_modes gm =new game_modes();
        gm.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnExit1ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        Sounds.playSound("buttonClick.wav");
        resetLabels();
    }//GEN-LAST:event_btnResetActionPerformed

    private void playing(JLabel label) {
        char value = ' ';
        index = Game.getIndexFromBoard(label.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        record.add(r1);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        if (g.setBoard(index, g.getCurrentPlayer())) {
            label.setText(g.getBoard(index).toString());

            if (g.hasWinner()) {
                System.out.println("player " + g.getCurrentPlayer());
                if (g.getCurrentPlayer().toString() == "X") {
                    xWins();
                    scorePlayerOne += 1;

                } else {
                    oWins();
                    scorePlayerTwo += 1;
//                    g.setCurrentPlayer(Game.Board.O);
                }
                createDialogSaveRecord();

                g.chooseAplayer(lTurn);
                ReDraw();

            } else {

                g.chooseAplayer(lTurn);
                playRopot();
                ReDraw();
            }
        }
    }

    private void createDialogSaveRecord() {

        int response = JOptionPane.showConfirmDialog(this, "Do you want record game?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            registerMovesInDb(true);
        } else {
            registerMovesInDb(false);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSinglePlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSinglePlayer().setVisible(true);
            }
        });
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

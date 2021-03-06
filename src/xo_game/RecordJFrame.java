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
import java.awt.Component;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author abdelrahman
 */
public class RecordJFrame extends javax.swing.JFrame {

    IntializeSocket socket;
    Game g = new Game();
    int index = 0;
    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;

    boolean f = false;
    String nameOfPlayer1 = "";

    boolean isFull = false;
    String r = "";

    ArrayList<Record> record;

    public RecordJFrame() {
        System.out.println("helllo");
        initComponents();
      
       socket = new IntializeSocket();
        record = new ArrayList<>();
         setNameLabels();
        lTurn.setText("Player one turn");
        socket.getPs().println("nameOfPlayer#" + Player.getUserName());
        try {
            nameOfPlayer1 = socket.getDis().readLine();
            System.out.println("nameOfPlayer1 = " + nameOfPlayer1);
            Player.setName(nameOfPlayer1);
            
            
            lPlayer3.setText(Player.getName());
          
            lPlayer1.setText("Computer");
            socket.getPs().println("returnRecord");
            r = socket.getDis().readLine();
            System.out.println("r = " + r);
            String[] arr = r.split("#");
            System.out.println("arr = " + arr[0] + " " + arr[1]);
            for (int i = 0; i < arr[0].length(); i++) {
               
                record.add(new Record(Integer.parseInt(arr[0].charAt(i)+""), arr[1].charAt(i)));
                 System.out.println("record = " + record.get(i).getIndex());
             System.out.println("record = " + record.get(i).getValue());
            }
           signUp();
          
        } catch (IOException ex) {
            Logger.getLogger(FrmSinglePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

 private void signUp() {
        new Thread(new Runnable() {

            @Override
            public void run() {
               for (int i = 0; i < record.size(); i++) {
           
           
            try {
                 printRecord(record.get(i).getIndex(), record.get(i).getValue());
                Thread.sleep(1000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RecordJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            }
        }).start();
    }
    
    private void printRecord(int index, char c) {
        switch (index) {
            case 0:
                jLabel1.setText("" + c);
                break;
            case 1:
                jLabel2.setText("" + c);
                break;
            case 2:
                jLabel3.setText("" + c);
                break;
            case 3:
                jLabel4.setText("" + c);
                break;
            case 4:
                jLabel5.setText("" + c);
                break;
            case 5:
                jLabel6.setText("" + c);
                break;
            case 6:
                jLabel7.setText("" + c);
                break;
            case 7:
                jLabel8.setText("" + c);
                break;
            case 8:
                jLabel9.setText("" + c);
                break;
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
        // String index = "";
        // String value = "";
        /*  socket.getPs().println("game#" + Player.getUserName() + "#" + "computer#" + scorePlayerOne + "#" + scorePlayerTwo );
        for (int i = 0; i < record.size(); i++) {
            index += String.valueOf(record.get(i).getIndex());
            value+=String.valueOf(record.get(i).getValue());
        }
        socket.getPs().println("insertRecord#" + index + "#" + value);*/
        isFull = true;

        resetLabels();
    }

    private void oWins() {
        JOptionPane.showMessageDialog(this, "O WINS", "Winner", JOptionPane.INFORMATION_MESSAGE);

        //  socket.getPs().println("game#" + Player.getUserName() + "#" + "computer#" + scorePlayerOne + "#" + scorePlayerTwo );
        isFull = true;

        resetLabels();
    }

    private void setText(JLabel label) {

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
            }
        }

        g.chooseAplayer(lTurn);
        ReDraw();
    }

    private void playRopot() {

        if (!isFull) {
            while (true) {
                int position = g.genRandmInt();
                Record r1 = new Record(position, 'O');
                record.add(r1);
                System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());

                if (g.indexIsEmptyOrNot(position)) {
                    setTextInBtn(position);
                    //System.out.println("empty");
                    break;
                } else {

                    // System.out.println("no empty");
                }
                isFull = false;
            }

        }
    }

    private void setTextInBtn(int position) {

        switch (position) {
            case 0:
                if (jLabel1.getText().toString() == "") {
                    setText(jLabel1);
                }
                break;
            case 1:
                if (jLabel2.getText().toString() == "") {
                    setText(jLabel2);
                }
                break;
            case 2:
                if (jLabel3.getText().toString() == "") {
                    setText(jLabel3);
                }
                break;
            case 3:
                if (jLabel4.getText().toString() == "") {
                    setText(jLabel4);
                }
                break;
            case 4:
                if (jLabel5.getText().toString() == "") {
                    setText(jLabel5);
                }
                break;
            case 5:
                if (jLabel6.getText().toString() == "") {
                    setText(jLabel6);
                }
                break;
            case 6:
                if (jLabel7.getText().toString() == "") {
                    setText(jLabel7);
                }
                break;
            case 7:
                if (jLabel8.getText().toString() == "") {
                    setText(jLabel8);
                }
                break;
            case 8:
                if (jLabel9.getText().toString() == "") {
                    setText(jLabel9);
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
        btnReset = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(186, 79, 84));
        setMinimumSize(new java.awt.Dimension(611, 388));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(120, 0, 46));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setEnabled(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(611, 100));

        lPlayer1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lPlayer1.setForeground(new java.awt.Color(255, 255, 255));
        lPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPlayer1.setText("Computer");

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
        lPlayer3.setText("Player 1");

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
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lPlayer3)
                    .addComponent(lscorePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(lTurn)
                .addGap(240, 240, 240)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lPlayer1)
                        .addGap(41, 41, 41)
                        .addComponent(exit_label))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lscorePlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lPlayer1)
                            .addComponent(lPlayer3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lscorePlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lscorePlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(exit_label))
                .addContainerGap(12, Short.MAX_VALUE))
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

        getContentPane().add(jPanelBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 780, 410));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 460, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 890, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel1.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        record.add(r1);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        /* if (g.setBoard(index, g.getCurrentPlayer())) {
            label.setText(g.getBoard(index).toString());
        }*/
        playing(jLabel1);
    }//GEN-LAST:event_jLabel1MouseClicked


    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel2.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        record.add(r1);
        playing(jLabel2);
    }//GEN-LAST:event_jLabel2MouseClicked


    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel3.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        record.add(r1);
        playing(jLabel3);

    }//GEN-LAST:event_jLabel3MouseClicked


    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel4.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        record.add(r1);
        playing(jLabel4);
    }//GEN-LAST:event_jLabel4MouseClicked


    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel5.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        record.add(r1);
        playing(jLabel5);
    }//GEN-LAST:event_jLabel5MouseClicked


    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel6.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        record.add(r1);
        playing(jLabel6);
    }//GEN-LAST:event_jLabel6MouseClicked


    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel8.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        record.add(r1);
        playing(jLabel8);

    }//GEN-LAST:event_jLabel8MouseClicked


    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel9.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        record.add(r1);
        playing(jLabel9);
    }//GEN-LAST:event_jLabel9MouseClicked


    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        char value = ' ';
        int index = Game.getIndexFromBoard(jLabel7.getName());
        Game.Board b = g.getCurrentPlayer();
        if (b == Game.Board.X) {
            value = 'X';
        } else if (b == Game.Board.O) {
            value = 'O';
        }
        Record r1 = new Record(index, value);
        System.out.println("index = " + r1.getIndex() + "value = " + r1.getValue());
        record.add(r1);
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
            playRopot();
            ReDraw();
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
                new RecordJFrame().setVisible(true);
             

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

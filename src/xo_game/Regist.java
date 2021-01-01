/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo_game;

import model.IntializeSocket;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
;
import xo_game.LogIn;
import xo_game.Start;

/**
 *
 * @author mai
 */


public class Regist extends javax.swing.JFrame implements Runnable {
    

    IntializeSocket intializeSocket;
    String replyMsg = "1";
    Thread th;

    public Regist() {
       
            initComponents();
            
            intializeSocket = new IntializeSocket();
            th = new Thread(this);
            th.start();
       
         show_password_label.setVisible(false);
         show_password_label2.setVisible(false);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Bye Bye");
              
                     intializeSocket.getPs().println("exist");
  }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        back_label1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        submit_button_signup = new javax.swing.JButton();
        reset_button_signup = new javax.swing.JButton();
        name_txt_signup = new javax.swing.JTextField();
        user_name_txt_signup = new javax.swing.JTextField();
        password_txt_signup = new javax.swing.JPasswordField();
        confirm_password_txt_signup = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        exit_label = new javax.swing.JLabel();
        show_password_label = new javax.swing.JLabel();
        invisible_password_label = new javax.swing.JLabel();
        show_password_label2 = new javax.swing.JLabel();
        invisible_password_label2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(120, 0, 46));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle-cropped.png"))); // NOI18N

        back_label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        back_label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_label1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(back_label1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(back_label1)
                .addGap(83, 83, 83)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(186, 79, 84));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submit_button_signup.setBackground(new java.awt.Color(255, 255, 255));
        submit_button_signup.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        submit_button_signup.setForeground(new java.awt.Color(120, 0, 46));
        submit_button_signup.setText("Submit");
        submit_button_signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 20));
        submit_button_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_button_signupActionPerformed(evt);
            }
        });
        jPanel3.add(submit_button_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 370, 130));

        reset_button_signup.setBackground(new java.awt.Color(255, 255, 255));
        reset_button_signup.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        reset_button_signup.setForeground(new java.awt.Color(120, 0, 46));
        reset_button_signup.setText("Reset");
        reset_button_signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(120, 0, 46), 20));
        reset_button_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_button_signupActionPerformed(evt);
            }
        });
        jPanel3.add(reset_button_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 370, 130));

        name_txt_signup.setBackground(new java.awt.Color(186, 79, 84));
        name_txt_signup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name_txt_signup.setForeground(new java.awt.Color(255, 255, 255));
        name_txt_signup.setToolTipText("");
        name_txt_signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        name_txt_signup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                name_txt_signupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                name_txt_signupFocusLost(evt);
            }
        });
        jPanel3.add(name_txt_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 190, 30));

        user_name_txt_signup.setBackground(new java.awt.Color(186, 79, 84));
        user_name_txt_signup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_name_txt_signup.setForeground(new java.awt.Color(255, 255, 255));
        user_name_txt_signup.setToolTipText("");
        user_name_txt_signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        user_name_txt_signup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_name_txt_signupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_name_txt_signupFocusLost(evt);
            }
        });
        jPanel3.add(user_name_txt_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 190, 30));

        password_txt_signup.setBackground(new java.awt.Color(186, 79, 84));
        password_txt_signup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password_txt_signup.setForeground(new java.awt.Color(255, 255, 255));
        password_txt_signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        password_txt_signup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_txt_signupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                password_txt_signupFocusLost(evt);
            }
        });
        jPanel3.add(password_txt_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 190, 30));

        confirm_password_txt_signup.setBackground(new java.awt.Color(186, 79, 84));
        confirm_password_txt_signup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        confirm_password_txt_signup.setForeground(new java.awt.Color(255, 255, 255));
        confirm_password_txt_signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        confirm_password_txt_signup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirm_password_txt_signupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirm_password_txt_signupFocusLost(evt);
            }
        });
        jPanel3.add(confirm_password_txt_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/name-tag-20.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 20, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lock.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 20, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/confirm_the_password-book-20.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 20, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 20, 20));

        exit_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-close-window-40.png"))); // NOI18N
        exit_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_labelMouseClicked(evt);
            }
        });
        jPanel3.add(exit_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 40, 40));

        show_password_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-eye-20.png"))); // NOI18N
        show_password_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_password_labelMouseClicked(evt);
            }
        });
        jPanel3.add(show_password_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, -1));

        invisible_password_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/invisible-20.png"))); // NOI18N
        invisible_password_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invisible_password_labelMouseClicked(evt);
            }
        });
        jPanel3.add(invisible_password_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 20, 20));

        show_password_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-eye-20.png"))); // NOI18N
        show_password_label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_password_label2MouseClicked(evt);
            }
        });
        jPanel3.add(show_password_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        invisible_password_label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/invisible-20.png"))); // NOI18N
        invisible_password_label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invisible_password_label2MouseClicked(evt);
            }
        });
        jPanel3.add(invisible_password_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 20, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 220, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 70, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Username");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 120, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 120, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
       
    }


    private void back_label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_label1MouseClicked
        // TODO add your handling code here:
        Sounds.playSound("button1.wav");
        Start st = new Start();
        st.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_back_label1MouseClicked

    private void invisible_password_label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invisible_password_label2MouseClicked
        // TODO add your handling code here:
       Sounds.playSound("Push-Sound.wav");
        show_password_label2.setVisible(true);
        invisible_password_label2.setVisible(false);
        confirm_password_txt_signup.setEchoChar((char)0);
    }//GEN-LAST:event_invisible_password_label2MouseClicked

    private void show_password_label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_password_label2MouseClicked
        // TODO add your handling code here:
        //show password here
        Sounds.playSound("Push-Sound.wav");
        invisible_password_label2.setVisible(true);
        show_password_label2.setVisible(false);
        confirm_password_txt_signup.setEchoChar('*');
    }//GEN-LAST:event_show_password_label2MouseClicked

    private void invisible_password_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invisible_password_labelMouseClicked
        // TODO add your handling code here:
        Sounds.playSound("Push-Sound.wav");
        show_password_label.setVisible(true);
        invisible_password_label.setVisible(false);
        password_txt_signup.setEchoChar((char)0);
    }//GEN-LAST:event_invisible_password_labelMouseClicked

    private void show_password_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_password_labelMouseClicked
        // TODO add your handling code here:
        //show password here
        Sounds.playSound("Push-Sound.wav");
        invisible_password_label.setVisible(true);
        show_password_label.setVisible(false);
        password_txt_signup.setEchoChar('*');
    }//GEN-LAST:event_show_password_labelMouseClicked

    private void exit_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit_labelMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void confirm_password_txt_signupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirm_password_txt_signupFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_confirm_password_txt_signupFocusLost

    private void confirm_password_txt_signupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirm_password_txt_signupFocusGained
        // TODO add your handling code here:
        if (confirm_password_txt_signup.getText().equals("password")) {
            confirm_password_txt_signup.setText("");
        }
    }//GEN-LAST:event_confirm_password_txt_signupFocusGained

    private void password_txt_signupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_txt_signupFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_password_txt_signupFocusLost

    private void password_txt_signupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_txt_signupFocusGained
        // TODO add your handling code here:
        if (password_txt_signup.getText().equals("password")) {
            password_txt_signup.setText("");
        }
    }//GEN-LAST:event_password_txt_signupFocusGained

    private void user_name_txt_signupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_name_txt_signupFocusLost
        // TODO add your handling code here:
      
    }//GEN-LAST:event_user_name_txt_signupFocusLost

    private void user_name_txt_signupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_name_txt_signupFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_user_name_txt_signupFocusGained

    private void name_txt_signupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_txt_signupFocusLost
        // TODO add your handling code here:
     
    }//GEN-LAST:event_name_txt_signupFocusLost

    private void name_txt_signupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_txt_signupFocusGained
        // TODO add your handling code here:
     
    }//GEN-LAST:event_name_txt_signupFocusGained

    private void reset_button_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_button_signupActionPerformed
        // TODO add your handling code here:
        //delete user information from the form
        Sounds.playSound("buttonClick.wav");
        name_txt_signup.setText("");
        user_name_txt_signup.setText("");
        password_txt_signup.setText("");
        confirm_password_txt_signup.setText("");

    }//GEN-LAST:event_reset_button_signupActionPerformed

    private void submit_button_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_button_signupActionPerformed
        Sounds.playSound("buttonClick.wav");
        String name = name_txt_signup.getText();
        String user_name = user_name_txt_signup.getText();
        String password = password_txt_signup.getText();
        String confirmPassword = String.valueOf(confirm_password_txt_signup.getText());

        if (name == "") {
            JOptionPane.showMessageDialog(null, " Name is Mandatory");
            return;
        }

        if (user_name == "") {
            JOptionPane.showMessageDialog(null, " User Name is Mandatory");
            return;
        }
        if (password == "") {
            JOptionPane.showMessageDialog(null, " Password is Mandatory");
            return;
        }
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(null, " password must be more than 6 characters");
            return;
        }
        if (password.length() > 20) {
            JOptionPane.showMessageDialog(null, " password must be less than 20 characters");
            return;
        }
        /*if (confirmPassword == "") {
            JOptionPane.showMessageDialog(null, " Confirm Password is Mandatory");
            return;
        }
        if (password != confirmPassword) {
            JOptionPane.showMessageDialog(null, "Confirm Password must equals Password ");
            return;
        }*/

        intializeSocket.getPs().println("signUp" + "#" + name + "#" + user_name + "#" + password);

        try {
            replyMsg = intializeSocket.getDis().readLine();

        } catch (IOException ex) {
            Logger.getLogger(Regist.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (replyMsg.equals("0")) {
            LogIn login = new LogIn();
            login.setVisible(true);
            this.setVisible(false);
        } else {
            System.out.println("Exist User Name");

        }

    }//GEN-LAST:event_submit_button_signupActionPerformed

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
            java.util.logging.Logger.getLogger(Regist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Regist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Regist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Regist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Regist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_label1;
    private javax.swing.JPasswordField confirm_password_txt_signup;
    private javax.swing.JLabel exit_label;
    private javax.swing.JLabel invisible_password_label;
    private javax.swing.JLabel invisible_password_label2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField name_txt_signup;
    private javax.swing.JPasswordField password_txt_signup;
    private javax.swing.JButton reset_button_signup;
    private javax.swing.JLabel show_password_label;
    private javax.swing.JLabel show_password_label2;
    private javax.swing.JButton submit_button_signup;
    private javax.swing.JTextField user_name_txt_signup;
    // End of variables declaration//GEN-END:variables

}

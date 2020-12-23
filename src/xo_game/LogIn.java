/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xo_game;

/**
 *
 * @author mai
 */
public class LogIn extends javax.swing.JFrame {

    /** Creates new form LogIn */
    public LogIn() {
        initComponents();
        invisible_password_label.setVisible(false);
        password_txt_login.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        user_name_txt_login = new javax.swing.JTextField();
        password_txt_login = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        log_in_button_login = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        sign_up_button_login = new javax.swing.JButton();
        show_password_label = new javax.swing.JLabel();
        forget_password_label_login = new javax.swing.JLabel();
        exit_label = new javax.swing.JLabel();
        invisible_password_label = new javax.swing.JLabel();
        back_label = new javax.swing.JLabel();
        password_to_show_login = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(74, 31, 61));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle-cropped.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(186, 79, 84));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_name_txt_login.setBackground(new java.awt.Color(186, 79, 84));
        user_name_txt_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_name_txt_login.setForeground(new java.awt.Color(204, 204, 204));
        user_name_txt_login.setText("Enter Your Username");
        user_name_txt_login.setToolTipText("");
        user_name_txt_login.setBorder(null);
        user_name_txt_login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_name_txt_loginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_name_txt_loginFocusLost(evt);
            }
        });
        user_name_txt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_name_txt_loginActionPerformed(evt);
            }
        });
        jPanel3.add(user_name_txt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, 30));

        password_txt_login.setBackground(new java.awt.Color(186, 79, 84));
        password_txt_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password_txt_login.setForeground(new java.awt.Color(204, 204, 204));
        password_txt_login.setBorder(null);
        password_txt_login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_txt_loginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                password_txt_loginFocusLost(evt);
            }
        });
        jPanel3.add(password_txt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 180, 30));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 190, 10));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 20, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lock.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 40, 30));

        jPanel4.setBackground(new java.awt.Color(186, 79, 84));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        log_in_button_login.setBackground(new java.awt.Color(255, 255, 255));
        log_in_button_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        log_in_button_login.setForeground(new java.awt.Color(186, 79, 84));
        log_in_button_login.setText("Log In");
        log_in_button_login.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        log_in_button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_in_button_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(log_in_button_login, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(log_in_button_login, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, 30));

        jPanel5.setBackground(new java.awt.Color(186, 79, 84));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        sign_up_button_login.setBackground(new java.awt.Color(255, 255, 255));
        sign_up_button_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sign_up_button_login.setForeground(new java.awt.Color(186, 79, 84));
        sign_up_button_login.setText("Sign Up");
        sign_up_button_login.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sign_up_button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_up_button_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sign_up_button_login, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sign_up_button_login, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, 30));

        show_password_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-eye-20.png"))); // NOI18N
        show_password_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_password_labelMouseClicked(evt);
            }
        });
        jPanel3.add(show_password_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        forget_password_label_login.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        forget_password_label_login.setForeground(new java.awt.Color(204, 204, 204));
        forget_password_label_login.setText("    Forget Password?");
        forget_password_label_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forget_password_label_loginMouseClicked(evt);
            }
        });
        jPanel3.add(forget_password_label_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 120, -1));

        exit_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-exit-sign-20.png"))); // NOI18N
        exit_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_labelMouseClicked(evt);
            }
        });
        jPanel3.add(exit_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, -30, 20, 80));

        invisible_password_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-invisible-20.png"))); // NOI18N
        invisible_password_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invisible_password_labelMouseClicked(evt);
            }
        });
        jPanel3.add(invisible_password_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 20, 20));

        back_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-back-arrow-20.png"))); // NOI18N
        back_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_labelMouseClicked(evt);
            }
        });
        jPanel3.add(back_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 20));

        password_to_show_login.setBackground(new java.awt.Color(186, 79, 84));
        password_to_show_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password_to_show_login.setForeground(new java.awt.Color(204, 204, 204));
        password_to_show_login.setText("Enter Your Password");
        password_to_show_login.setBorder(null);
        password_to_show_login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password_to_show_loginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                password_to_show_loginFocusLost(evt);
            }
        });
        password_to_show_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_to_show_loginActionPerformed(evt);
            }
        });
        jPanel3.add(password_to_show_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 210, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
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

    private void log_in_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_in_button_loginActionPerformed
        // TODO add your handling code here:
        //go to user Profile
    }//GEN-LAST:event_log_in_button_loginActionPerformed

    private void sign_up_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_up_button_loginActionPerformed
        //TODO add your handling code here:
        //go to sign up form
        Regist reg = new Regist();
        reg.setVisible(true);
    }//GEN-LAST:event_sign_up_button_loginActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void show_password_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_password_labelMouseClicked
        // TODO add your handling code here:
        //show password here
        invisible_password_label.setVisible(true);
        show_password_label.setVisible(false);
        password_txt_login.setEchoChar((char)0);
    }//GEN-LAST:event_show_password_labelMouseClicked

    private void forget_password_label_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forget_password_label_loginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_forget_password_label_loginMouseClicked

    private void exit_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_labelMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit_labelMouseClicked

    private void user_name_txt_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_name_txt_loginFocusGained
        // TODO add your handling code here:
       if(user_name_txt_login.getText().equals("Enter Your Username"))
       {
           user_name_txt_login.setText("");
            
       }
    }//GEN-LAST:event_user_name_txt_loginFocusGained

    private void user_name_txt_loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_name_txt_loginFocusLost
        // TODO add your handling code here:
          if(user_name_txt_login.getText().equals(""))
        {
            user_name_txt_login.setText("Enter Your Username");
            
        }
    }//GEN-LAST:event_user_name_txt_loginFocusLost

    private void password_txt_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_txt_loginFocusGained
        // TODO add your handling code here:
         if(password_txt_login.getText().equals("password"))
         {
        password_txt_login.setText("");
         }
     
    }//GEN-LAST:event_password_txt_loginFocusGained

    private void password_txt_loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_txt_loginFocusLost
        // TODO add your handling code here:

    
    }//GEN-LAST:event_password_txt_loginFocusLost

    private void invisible_password_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invisible_password_labelMouseClicked
        // TODO add your handling code here:
        
        show_password_label.setVisible(true);
        invisible_password_label.setVisible(false);
        password_txt_login.setEchoChar('*');
        
    }//GEN-LAST:event_invisible_password_labelMouseClicked

    private void back_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_labelMouseClicked
        // TODO add your handling code here:
        Start st = new Start();
        st.setVisible(true);
    }//GEN-LAST:event_back_labelMouseClicked

    private void password_to_show_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_to_show_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_to_show_loginActionPerformed

    private void user_name_txt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_name_txt_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_name_txt_loginActionPerformed

    private void password_to_show_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_to_show_loginFocusGained
        // TODO add your handling code here:
            if(password_to_show_login.getText().equals("Enter Your Password"))
       {
           password_to_show_login.setText("");
            password_txt_login.setVisible(true);
            password_to_show_login.setVisible(false);
            
           
       
       }
    }//GEN-LAST:event_password_to_show_loginFocusGained

    private void password_to_show_loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_to_show_loginFocusLost
        // TODO add your handling code here:
            if(password_to_show_login.getText().equals(""))
        {
            password_to_show_login.setText("Enter Your Password");
            
            
        }
    }//GEN-LAST:event_password_to_show_loginFocusLost

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_label;
    private javax.swing.JLabel exit_label;
    private javax.swing.JLabel forget_password_label_login;
    private javax.swing.JLabel invisible_password_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton log_in_button_login;
    private javax.swing.JTextField password_to_show_login;
    private javax.swing.JPasswordField password_txt_login;
    private javax.swing.JLabel show_password_label;
    private javax.swing.JButton sign_up_button_login;
    private javax.swing.JTextField user_name_txt_login;
    // End of variables declaration//GEN-END:variables

}

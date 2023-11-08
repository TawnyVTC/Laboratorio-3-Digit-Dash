/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TercerLab;


import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;




/**
 *
 * @author TAWTOCA
 */


public class Azar extends javax.swing.JFrame {
    
    Random random = new Random();
    
    JButton[] botones = new JButton[4]; // Un array (vector) de 4 botones

    String Iconos[] = new String[4];

    String Iconos2[] = new String[4];
    
    public Azar() {
        
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/logo/Com.png")).getImage());
        
        Again.setVisible(false);
        
        Iconos[0] = "/Botones/Suma 2.png";
        Iconos[1] = "/Botones/Resta 2.png";
        Iconos[2] = "/Botones/Multi 2.png";
        Iconos[3] = "/Botones/Div 2.png";
        
        Iconos2[0] = "/Botones/Suma.png";
        Iconos2[1] = "/Botones/Resta.png";
        Iconos2[2] = "/Botones/Multi.png";
        Iconos2[3] = "/Botones/Div.png";
        
        botones[0] = Suma;
        botones[1] = Resta;
        botones[2] = Multi;
        botones[3] = Div;

    }
    // Método para reproducir el sonido
    public void reproducirSonido(String nombreArchivo) {
        try {
            // Carga el archivo de sonido
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(nombreArchivo));
            
            // Obtiene un clip de audio
            Clip clip = AudioSystem.getClip();
            
            // Abre el flujo de audio y carga el clip
            clip.open(audioInputStream);
            
            // Agrega un listener para manejar eventos del clip
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        // Libera los recursos después de reproducir el sonido
                        event.getLine().close();
                    }
                }
            });
            
            // Reproduce el sonido
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        Div = new javax.swing.JButton();
        Suma = new javax.swing.JButton();
        Resta = new javax.swing.JButton();
        Multi = new javax.swing.JButton();
        Dado = new javax.swing.JButton();
        Again = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Digit Dash");
        setLocation(new java.awt.Point(275, 105));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(12, 236, 221));
        jPanel1.setForeground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Div.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Div.png"))); // NOI18N
        Div.setBorder(null);
        Div.setBorderPainted(false);
        Div.setContentAreaFilled(false);
        Div.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Div.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Div 2.png"))); // NOI18N
        Div.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Div 2.png"))); // NOI18N
        Div.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Div 2.png"))); // NOI18N
        Div.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DivMouseEntered(evt);
            }
        });
        Div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DivActionPerformed(evt);
            }
        });
        jPanel1.add(Div, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 160, 60));

        Suma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Suma.png"))); // NOI18N
        Suma.setBorder(null);
        Suma.setBorderPainted(false);
        Suma.setContentAreaFilled(false);
        Suma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Suma.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Suma 2.png"))); // NOI18N
        Suma.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Suma 2.png"))); // NOI18N
        Suma.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Suma 2.png"))); // NOI18N
        Suma.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SumaMouseMoved(evt);
            }
        });
        Suma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SumaMouseEntered(evt);
            }
        });
        Suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SumaActionPerformed(evt);
            }
        });
        jPanel1.add(Suma, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 160, 60));

        Resta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Resta.png"))); // NOI18N
        Resta.setBorder(null);
        Resta.setBorderPainted(false);
        Resta.setContentAreaFilled(false);
        Resta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Resta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Resta 2.png"))); // NOI18N
        Resta.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Resta 2.png"))); // NOI18N
        Resta.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Resta 2.png"))); // NOI18N
        Resta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RestaMouseEntered(evt);
            }
        });
        Resta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestaActionPerformed(evt);
            }
        });
        jPanel1.add(Resta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 160, 60));

        Multi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Multi.png"))); // NOI18N
        Multi.setBorder(null);
        Multi.setBorderPainted(false);
        Multi.setContentAreaFilled(false);
        Multi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Multi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Multi 2.png"))); // NOI18N
        Multi.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Multi 2.png"))); // NOI18N
        Multi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Multi 2.png"))); // NOI18N
        Multi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MultiMouseEntered(evt);
            }
        });
        Multi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultiActionPerformed(evt);
            }
        });
        jPanel1.add(Multi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 160, 60));

        Dado.setToolTipText("");
        Dado.setBorder(null);
        Dado.setBorderPainted(false);
        Dado.setContentAreaFilled(false);
        Dado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Dado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DadoActionPerformed(evt);
            }
        });
        jPanel1.add(Dado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 50, 50));

        Again.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        Again.setForeground(new java.awt.Color(102, 0, 204));
        Again.setText("De Nuevo");
        Again.setBorder(null);
        Again.setBorderPainted(false);
        Again.setContentAreaFilled(false);
        Again.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Again.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Again.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Again.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Again.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgainActionPerformed(evt);
            }
        });
        jPanel1.add(Again, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 30));

        Volver.setBorderPainted(false);
        Volver.setContentAreaFilled(false);
        Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 40, 50));

        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 40, 50));

        Fondo.setDisplayedMnemonic('F');
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Ruleta.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgainActionPerformed
        

        for (int i = 0; i <= 3; i++){
            botones[i].setEnabled(true);
            botones[i].setIcon(new ImageIcon(getClass().getResource(Iconos2[i])));
        }

        Again.setVisible(false);
    }//GEN-LAST:event_AgainActionPerformed

    private void DadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DadoActionPerformed

        int n = random.nextInt(botones.length);
        
        ImageIcon alt = new ImageIcon(getClass().getResource("/img/Random.png"));
        if(Again.isVisible()==false){

            for (int i = 0; i < 4; i++){
                
                if (botones[n]!= botones[i]){
                    botones[i].setIcon(alt);
                    botones[i].setEnabled(false);
                }else{
                    botones[n].setIcon(new ImageIcon(getClass().getResource(Iconos[n])));
                }
            }

            Again.setVisible(true);

        }
    }//GEN-LAST:event_DadoActionPerformed

    private void SumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SumaActionPerformed
        SumeInfo s = new SumeInfo();
        setVisible(false);
        s.setVisible(true);
        
    }//GEN-LAST:event_SumaActionPerformed

    private void RestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestaActionPerformed
        RestaInfo r = new RestaInfo();
        setVisible(false);
        r.setVisible(true);
    }//GEN-LAST:event_RestaActionPerformed

    private void MultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultiActionPerformed
        MultInfo m = new MultInfo();
        setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_MultiActionPerformed

    private void DivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DivActionPerformed
        DivInfo d = new DivInfo();
        setVisible(false);
        d.setVisible(true);
    }//GEN-LAST:event_DivActionPerformed

    private void SumaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SumaMouseEntered
       reproducirSonido("/logo/Sonido.wav");
    }//GEN-LAST:event_SumaMouseEntered

    private void SumaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SumaMouseMoved
        
    }//GEN-LAST:event_SumaMouseMoved

    private void MultiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MultiMouseEntered
        reproducirSonido("/logo/Sonido.wav");
    }//GEN-LAST:event_MultiMouseEntered

    private void DivMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DivMouseEntered
        reproducirSonido("/logo/Sonido.wav");
    }//GEN-LAST:event_DivMouseEntered

    private void RestaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RestaMouseEntered
        reproducirSonido("/logo/Sonido.wav");
    }//GEN-LAST:event_RestaMouseEntered

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Inicio i = new Inicio();
        setVisible(false);
        i.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(Azar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Azar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Azar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Azar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Azar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Again;
    private javax.swing.JButton Dado;
    private javax.swing.JButton Div;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton Multi;
    private javax.swing.JButton Resta;
    private javax.swing.JButton Salir;
    private javax.swing.JButton Suma;
    private javax.swing.JButton Volver;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TercerLab;

import java.awt.Color;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
/**
 *
 * @author TAWTOCA
 */
public class Mult extends javax.swing.JFrame {

    /**
     * Creates new form Suma
     */
    public static class Node {
        int num, num2, resultado;
        Node next;
        Node prev;

        Node(int nu1, int nu2) {
            this.num = nu1;
            this.num2 = nu2;
            this.resultado = nu1 * nu2;
            this.next = null;
            this.prev = null;
        }
    }
    Random random = new Random();
    JRadioButton[] Opcion = new JRadioButton[3];
    JLabel[] Camino = new JLabel[5];
    int[] numbers = new int[10];
    int[] Use = new int[2000];
    int cs = 0;
    int p = 0 ;
    int I = 0;
    
   public final Node crearQ() {
        int i = 0;
            while (i < numbers.length) {
                int num = random.nextInt(10) + 1;
                boolean isUsed = false;

                for (int j = 0; j < i; j++) {
                    if (num == Use[j]) {
                        isUsed = true;
                        break;
                    }
                }

                if (!isUsed) {
                    numbers[i]=num;

                    Use[i] = num;
                    i++;
                }
            }

        Node node1 = new Node(numbers[0], numbers[1]);
        Node node2 = new Node(numbers[2], numbers[3]);
        Node node3 = new Node(numbers[4], numbers[5]);
        Node node4 = new Node(numbers[6], numbers[7]);
        Node node5 = new Node(numbers[8], numbers[9]);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node1;
        node1.prev = node5;

        return node1;
    }

    
    
    Node pregunta = crearQ();
    
    
    public Mult() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/logo/Com.png")).getImage());
        
        
        
        Opcion[0] = o1;
        Opcion[1] = o2;
        Opcion[2] = o3;
        
        Camino[0] = c1;
        Camino[1] = c2;
        Camino[2] = c3;
        Camino[3] = c4;
        Camino[4] = c5;
        
        displayQ(pregunta,n1,n2);

        
//        azar(); 
    }

public final void displayQ(Node node, JLabel n1Label, JLabel n2Label) {
        for (int i = 0; i < Use.length; i++){
            Use[i] = 0;
        }
        
        int tempNum = node.num;
        int tempNum2 = node.num2;
    
        n1Label.setText(String.valueOf(tempNum));
        n2Label.setText(String.valueOf(tempNum2));

        int i = 0;
        while (i < 3) {
            int num = random.nextInt(3);
            boolean isUsed = false;

            for (int j = 0; j < i; j++) {
                if (num == Use[j]) {
                    isUsed = true;
                    break;
                }
            }

            if (!isUsed) {
                if (i == 0) {
                    Opcion[num].setText(String.valueOf(node.resultado));
                } else if (i == 1) {
                    Opcion[num].setText(String.valueOf(node.resultado * 2));
                } else if (i == 2) {
                    Opcion[num].setText(String.valueOf(node.resultado + 3 ));
                }

                Use[i] = num;
                i++;
            }
        }
    }
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
    public final void Answer(Node node, JLabel n1Label, JLabel n2Label){
        
        for (int i = 0; i < 3; i++){
            if (Opcion[i].isSelected()){
                int producto = Integer.parseInt(Opcion[i].getText());
                // Comparar la suma del usuario con el resultado almacenado en el nodo
                if (producto == node.resultado) {
                    LineBorder border = (LineBorder) Camino[cs].getBorder();
                    Color col = border.getLineColor();

                    Camino[cs].setBackground(col);
                    p++;
                    P.setText(String.valueOf(p));
                    cs += 1;
                    reproducirSonido("/logo/Bien.wav");
                } else {
                    if (cs == 0){
                        I++;
                        In.setText(String.valueOf(I));
                    } else{
                        Color col = Fondo.getBackground();
                        I++;
                        cs--;
                        Camino[cs].setBackground(col);
                        P.setText(String.valueOf(p));
                        In.setText(String.valueOf(I));
                    }
                    reproducirSonido("/logo/Mal.wav");
                }
                
                if(I == 5){
                    Perdedor p = new Perdedor();
                    setVisible(false);
                    p.setVisible(true);
                }
                int c = 0;
                
                for (JLabel Camino1 : Camino) {
                    LineBorder border = (LineBorder) Camino1.getBorder();
                    Color bor = border.getLineColor();
                    Color back = Camino1.getBackground();
                    if (bor == back){
                    
                        c++;
                    }
                }
                
                if (c == 5){
                    Ganador g = new Ganador();
                    setVisible(false);
                    g.setVisible(true);
                }
            }
            
        
        }

        
        
        Opciones.clearSelection();
        
    }

//
//    public final void azar(){
//        
//        for (int i = 0; i < Use.length; i++){
//            Use[i] = 0;
//        }
//        
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = random.nextInt(11);
//        }
//
//        n1.setText(String.valueOf(numbers[0]));
//        n2.setText(String.valueOf(numbers[1]));
//
//        int i = 0;
//        while (i < 3) {
//            int num = random.nextInt(3);
//            boolean isUsed = false;
//
//            for (int j = 0; j < i; j++) {
//                if (num == Use[j]) {
//                    isUsed = true;
//                    break;
//                }
//            }
//
//            if (!isUsed) {
//                if (i == 0) {
//                    Opcion[num].setText(String.valueOf(numbers[0] * numbers[1]));
//                } else if (i == 1) {
//                    Opcion[num].setText(String.valueOf(numbers[2] * numbers[3] + 1));
//                } else if (i == 2) {
//                    Opcion[num].setText(String.valueOf(numbers[4] * numbers[5] + 3));
//                }
//
//                Use[i] = num;
//                i++;
//            }
//        }
//    
//    }
//    
//    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Opciones = new javax.swing.ButtonGroup();
        Fondo = new javax.swing.JPanel();
        Res = new javax.swing.JButton();
        o1 = new javax.swing.JRadioButton();
        o2 = new javax.swing.JRadioButton();
        o3 = new javax.swing.JRadioButton();
        c5 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        In = new javax.swing.JLabel();
        P = new javax.swing.JLabel();
        n1 = new javax.swing.JLabel();
        Raya = new javax.swing.JLabel();
        n2 = new javax.swing.JLabel();
        por = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        Azar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Digit Dash - Multiplicación");
        setLocation(new java.awt.Point(275, 105));
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(12, 236, 221));
        Fondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 0), 4, true));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Res.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Com.png"))); // NOI18N
        Res.setBorder(null);
        Res.setBorderPainted(false);
        Res.setContentAreaFilled(false);
        Res.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Res.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Com 2.png"))); // NOI18N
        Res.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Com 2.png"))); // NOI18N
        Res.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Com 2.png"))); // NOI18N
        Res.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResActionPerformed(evt);
            }
        });
        Fondo.add(Res, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 160, 60));

        o1.setBackground(new java.awt.Color(255, 102, 196));
        Opciones.add(o1);
        o1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        o1.setForeground(new java.awt.Color(102, 0, 204));
        o1.setText("16");
        o1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 3, true));
        o1.setBorderPainted(true);
        o1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        o1.setOpaque(true);
        o1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        Fondo.add(o1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 60, 40));

        o2.setBackground(new java.awt.Color(255, 204, 0));
        Opciones.add(o2);
        o2.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        o2.setForeground(new java.awt.Color(102, 0, 204));
        o2.setText("16");
        o2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 3, true));
        o2.setBorderPainted(true);
        o2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        o2.setOpaque(true);
        o2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        Fondo.add(o2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 60, 40));

        o3.setBackground(new java.awt.Color(255, 102, 196));
        Opciones.add(o3);
        o3.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        o3.setForeground(new java.awt.Color(102, 0, 204));
        o3.setText("16");
        o3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 3, true));
        o3.setBorderPainted(true);
        o3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        o3.setOpaque(true);
        o3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        Fondo.add(o3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 60, 40));

        c5.setBackground(new java.awt.Color(12, 236, 221));
        c5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 196), 4, true));
        c5.setOpaque(true);
        Fondo.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, 60));

        c4.setBackground(new java.awt.Color(12, 236, 221));
        c4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 4, true));
        c4.setOpaque(true);
        Fondo.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 90, 60));

        c3.setBackground(new java.awt.Color(12, 236, 221));
        c3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 0), 4, true));
        c3.setOpaque(true);
        Fondo.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 80, 60));

        c2.setBackground(new java.awt.Color(12, 236, 221));
        c2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 4, true));
        c2.setOpaque(true);
        Fondo.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 80, 60));

        c1.setBackground(new java.awt.Color(12, 236, 221));
        c1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 196), 4, true));
        c1.setOpaque(true);
        Fondo.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 70, 70));

        In.setFont(new java.awt.Font("Forte", 0, 48)); // NOI18N
        In.setForeground(new java.awt.Color(102, 0, 204));
        In.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        In.setText("0");
        In.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Fondo.add(In, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 90, 90));

        P.setFont(new java.awt.Font("Forte", 0, 48)); // NOI18N
        P.setForeground(new java.awt.Color(102, 0, 204));
        P.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        P.setText("0");
        P.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Fondo.add(P, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 90, 90));

        n1.setFont(new java.awt.Font("Forte", 0, 48)); // NOI18N
        n1.setForeground(new java.awt.Color(102, 0, 204));
        n1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n1.setText("7");
        n1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Fondo.add(n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 60, 70));

        Raya.setFont(new java.awt.Font("Consolas", 1, 70)); // NOI18N
        Raya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Raya.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Raya.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 0, 204)));
        Raya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Raya.setIconTextGap(0);
        Raya.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Fondo.add(Raya, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 230, 10));

        n2.setFont(new java.awt.Font("Forte", 0, 48)); // NOI18N
        n2.setForeground(new java.awt.Color(102, 0, 204));
        n2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        n2.setText("5");
        n2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Fondo.add(n2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 60, 70));

        por.setFont(new java.awt.Font("Forte", 0, 48)); // NOI18N
        por.setForeground(new java.awt.Color(102, 0, 204));
        por.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        por.setText("x");
        por.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Fondo.add(por, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 50, 50));

        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Fondo.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 40, 50));

        Azar.setBorderPainted(false);
        Azar.setContentAreaFilled(false);
        Azar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Azar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AzarActionPerformed(evt);
            }
        });
        Fondo.add(Azar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 40, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Juego.png"))); // NOI18N
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResActionPerformed
        Answer(pregunta, n1, n2);
        int Producto = Integer.parseInt(n1.getText()) * Integer.parseInt(n2.getText());
        
        if(pregunta.resultado == Producto){
            
            pregunta = pregunta.next;
        }else {
            
            pregunta = pregunta.prev;
        }
        
        displayQ(pregunta,n1,n2);
        
        
        
        
        
//        int N1 =  Integer.parseInt(n1.getText());
//        int N2 =  Integer.parseInt(n2.getText());   
//        
//        
//        for (int i = 0; i < 3;i++){
//            
//            if (Opcion[i].isSelected()){
//                int r = Integer.parseInt(Opcion[i].getText());
//                if (N1 * N2 == r){
//                    LineBorder border = (LineBorder) Camino[cs].getBorder();
//                    Color col = border.getLineColor();
//
//                    Camino[cs].setBackground(col);
//                    String m = String.valueOf(cs +1);
//                    P.setText(m);
//                    cs += 1;
//                    
//                    azar();
//                    Opciones.clearSelection();
//                }
//            }
//        }
//        
        
    }//GEN-LAST:event_ResActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void AzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AzarActionPerformed
        Azar a = new Azar();
        setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_AzarActionPerformed

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
            java.util.logging.Logger.getLogger(Mult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Azar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel In;
    private javax.swing.ButtonGroup Opciones;
    private javax.swing.JLabel P;
    private javax.swing.JLabel Raya;
    private javax.swing.JButton Res;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JRadioButton o1;
    private javax.swing.JRadioButton o2;
    private javax.swing.JRadioButton o3;
    private javax.swing.JLabel por;
    // End of variables declaration//GEN-END:variables
}

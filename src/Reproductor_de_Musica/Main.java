/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Reproductor_de_Musica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author adalb
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        listModel = new DefaultListModel<>();
        jList1.setModel(listModel);
        jProgressBar.setValue(0);
        jProgressBar.setStringPainted(true);
        jProgressBar.setForeground(Color.BLUE);
        loadSongs();
        Timer();
    }
    public static DefaultListModel listModel;
    public static Reproductor reproductor=new Reproductor();
    private Timer timer;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stop = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        play = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        resume = new javax.swing.JButton();
        jProgressBar = new javax.swing.JProgressBar();
        imagenDeCancion = new javax.swing.JLabel();
        tiempoActual = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        duration1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        pause.setText("Pause");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        play.setText("Play");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        resume.setText("Resume");
        resume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeActionPerformed(evt);
            }
        });

        tiempoActual.setText("00:00");

        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        duration1.setText("00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(select)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(play)
                                        .addComponent(stop)
                                        .addComponent(pause)
                                        .addComponent(resume))))
                            .addGap(55, 55, 55)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)
                            .addComponent(imagenDeCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(add)
                            .addGap(305, 305, 305)
                            .addComponent(tiempoActual)
                            .addGap(12, 12, 12)
                            .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(duration1)))
                    .addGap(0, 9, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 34, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(select)
                            .addGap(16, 16, 16)
                            .addComponent(play)
                            .addGap(18, 18, 18)
                            .addComponent(stop)
                            .addGap(18, 18, 18)
                            .addComponent(pause)
                            .addGap(18, 18, 18)
                            .addComponent(resume))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(imagenDeCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(add)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tiempoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(duration1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 35, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        reproductor.Stop();
        jProgressBar.setValue(0);
        if (timer.isRunning()) {
            timer.stop();
            play.setEnabled(true);
            pause.setText("Pause");
            resume.setEnabled(false);
        }
    }//GEN-LAST:event_stopActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        // TODO add your handling code here:
        if(reproductor.isPlaying()){
            reproductor.pause();
            play.setEnabled(false);
        }
    }//GEN-LAST:event_pauseActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        // TODO add your handling code here:
        int selectedIndex = jList1.getSelectedIndex();
        if (selectedIndex != -1) {
            reproductor.selectSong(selectedIndex);
            reproductor.play();
            updateProgressBar();
        } else {
            JOptionPane.showMessageDialog(this, "No hay canción seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_playActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        reproductor.add();
        reproductor.addImageofSong();
    }//GEN-LAST:event_addActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        int index = jList1.getSelectedIndex();
        if (index != -1) {
            reproductor.selectSong(index);
            jProgressBar.setValue(0);
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void resumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeActionPerformed
        // TODO add your handling code here:
        if(!reproductor.isPlaying()){
            reproductor.Resume();
            play.setEnabled(true);
        }
    }//GEN-LAST:event_resumeActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
        int index = jList1.getSelectedIndex();
        if (index != -1) {
            reproductor.selectSong(index);
            jProgressBar.setValue(0);
        }
    }//GEN-LAST:event_selectActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    private void updateProgressBar() {
        if (!timer.isRunning()) {
            timer.start();
        }
    }
    
    private void Timer() {
        timer=new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reproductor.isPlaying()) {
                long currentSeconds=reproductor.getCurrentMicroS() / 1_000_000;
                long totalSeconds=reproductor.getTotalS();
                int progress = (int) ((double) currentSeconds / totalSeconds * 100);
                jProgressBar.setValue(progress);
                jProgressBar.repaint();

                long minutes = totalSeconds / 60;
                long seconds = totalSeconds % 60;
                tiempoActual.setText(String.format("%02d:%02d", minutes, seconds));

                long currentMinutes = currentSeconds / 60;
                long currentSecondsRemaining = currentSeconds % 60;
                tiempoActual.setText(String.format("%02d:%02d", currentMinutes, currentSecondsRemaining));
                }
            }
        });
    }
    
    private void loadSongs() {
        File musicFolder = new File("src/Music");
        if (musicFolder.exists() && musicFolder.isDirectory()) {
            File[] files = musicFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));
            if (files != null) {
                for (File file : files) {
                    listModel.addElement(file.getName().replace(".wav", ""));
                    reproductor.addSong(file.getAbsolutePath());
                }
            }
        }
        File imagesFolder = new File("src/Images");
        if (imagesFolder.exists() && imagesFolder.isDirectory()) {
            File[] files = imagesFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));
            if (files != null) {
                for (File file : files) {
                    listModel.addElement(file.getName().replace(".wav", ""));
                    reproductor.addImage(file.getAbsolutePath());
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    public static javax.swing.JLabel duration1;
    public static javax.swing.JLabel imagenDeCancion;
    private javax.swing.JList<String> jList1;
    public static javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    private javax.swing.JButton resume;
    private javax.swing.JButton select;
    private javax.swing.JButton stop;
    public static javax.swing.JLabel tiempoActual;
    // End of variables declaration//GEN-END:variables
}
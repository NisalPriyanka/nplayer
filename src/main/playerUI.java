/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.media.MediaPlayer;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import resources.audioPlayer;
import sun.audio.AudioPlayer;

/**
 *
 * @author Nisal Priyanka
 */
public class playerUI extends javax.swing.JFrame {

    /**
     * Creates new form playerUI
     */
    
    static String fileName;
    static String songName;
    static String selectedPath;
    DefaultListModel ListModel = new DefaultListModel();
    ArrayList<String> MusicPathlist  = new ArrayList<String>();
    static boolean ismusicPlay = false; 
    
    public playerUI() {
        
        this.setLocationRelativeTo(null);
        initComponents();
        this.setSize(420, 320);
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        play = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AudioList = new javax.swing.JList<>();
        browse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("N-Player");
        getContentPane().setLayout(null);

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play-button.png"))); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play);
        play.setBounds(80, 216, 65, 41);

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause.png"))); // NOI18N
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        getContentPane().add(pause);
        pause.setBounds(163, 216, 65, 41);

        jScrollPane1.setViewportView(AudioList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 370, 90);

        browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        getContentPane().add(browse);
        browse.setBounds(246, 216, 65, 41);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()+2f));
        jLabel1.setText("Now Playing  :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(34, 11, 90, 24);
        getContentPane().add(Title);
        Title.setBounds(130, 10, 250, 30);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(20, 170, 370, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        
        //create file choosing object
        JFileChooser choose = new JFileChooser();
        
        //adding file filter
        choose.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter ff1 = new FileNameExtensionFilter("Mp3 Audio Files","mp3");
        FileNameExtensionFilter ff2 = new FileNameExtensionFilter("Windows Audio Files","wav");
        choose.addChoosableFileFilter(ff1);
        choose.addChoosableFileFilter(ff2);
        
        //open browse dialog
        choose.showOpenDialog(null);
        File f = choose.getSelectedFile(); //get selected audio as file object
        playerUI.fileName = f.getAbsolutePath();//getting whole path
        playerUI.songName = f.getName(); //getting only name
        System.out.println(playerUI.fileName);
        System.out.println(playerUI.songName);
        
        //arrayList and ListBoxFills
        
        ListModel.addElement(playerUI.songName);
        this.AudioList.setModel(ListModel);
        
        //arrayList
        this.MusicPathlist.add(playerUI.fileName);
        
        
    }//GEN-LAST:event_browseActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        // TODO add your handling code here:
        
       
        //getting selected index
        int selectedIndex = this.AudioList.getSelectedIndex();
        System.out.println("Index Selected : "+selectedIndex);
        
        //getting arrayListPath
        String path = this.MusicPathlist.get(selectedIndex).toString();
        System.out.println("Path of Music : "+path);
        playerUI.selectedPath = path;
        
        audioPlayer pl = new audioPlayer(playerUI.selectedPath);
        
        if(playerUI.ismusicPlay==false)
        {
            pl.setStus(MediaPlayer.Status.READY);
        }
        
        pl.play();
        
        playerUI.ismusicPlay = true;
       
        
        
        
        
        
    }//GEN-LAST:event_playActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        // TODO add your handling code here:
        
        
        audioPlayer pl = new audioPlayer(playerUI.selectedPath);
//        System.out.println("Selected Path : "+playerUI.selectedPath);
        
        pl.stop();
        playerUI.ismusicPlay = false;
        
    }//GEN-LAST:event_pauseActionPerformed

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
            java.util.logging.Logger.getLogger(playerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AudioList;
    private javax.swing.JLabel Title;
    private javax.swing.JButton browse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    // End of variables declaration//GEN-END:variables
}
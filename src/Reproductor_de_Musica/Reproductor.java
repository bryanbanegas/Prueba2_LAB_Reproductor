/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reproductor_de_Musica;
import static Reproductor_de_Musica.Main.imagenDeCancion;
import static Reproductor_de_Musica.Main.listModel;
import static Reproductor_de_Musica.Main.reproductor;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author adalb
 */

/**
 *
 * @author jomel
 */
public class Reproductor extends Thread{
    private ArrayList<Canciones> playlist=new ArrayList<>();;    
    private int currentSongIndex=0,pos=-1;
    private boolean isPlaying=false, isPaused=false;
    private long currentMicroS=0, totalMicroS=0, pausedMicroS=0;
    private Clip clip;
    
    public Reproductor(){
        clip=null;
    }
    
    public long getCurrentMicroS() {
        return currentMicroS;
    }

    public long getTotalMicroS() {
        return totalMicroS;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public long getTotalS() {
        return totalMicroS/1_000_000;
    }
    
    public void selectSong(int index) {
        currentSongIndex=index;
    }
    
    public void addSong(String filePath) {
        File sourceFile = new File(filePath);
        File destinationFolder = new File("Music/");
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }
        File destinationFile = new File(destinationFolder, sourceFile.getName());
        try {
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            playlist.add(new Canciones(destinationFile.getAbsolutePath(),""));
            pos++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void add(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("WAV files", "wav"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            File musicFolder = new File("src/Music");
            if (!musicFolder.exists()) {
                musicFolder.mkdirs();
            }
            File newFile = new File(musicFolder, selectedFile.getName());
            try {
                Files.copy(selectedFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                listModel.addElement(selectedFile.getName().replace(".wav", ""));
                reproductor.addSong(newFile.getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void addImage(String filePath) {
        File sourceFile = new File(filePath);
        File destinationFolder = new File("Images/");
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }
        File destinationFile = new File(destinationFolder, sourceFile.getName());
        try {
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            playlist.get(pos).setImage(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void addImageofSong(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("WAV files", "wav"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            File musicFolder = new File("src/Images");
            if (!musicFolder.exists()) {
                musicFolder.mkdirs();
            }
            File newFile = new File(musicFolder, selectedFile.getName());
            try {
                Files.copy(selectedFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                addImage(newFile.getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void play() {
        if (!isPlaying && currentSongIndex >= 0 && currentSongIndex < playlist.size()) {
            isPlaying=true;
            String filePath = playlist.get(currentSongIndex).getName();
            ImageIcon imagen=new ImageIcon(playlist.get(currentSongIndex).getImage());
            Image Scalecard=imagen.getImage().getScaledInstance(230, 180, Image.SCALE_SMOOTH);
            imagen=new ImageIcon(Scalecard);
            imagenDeCancion.setIcon(imagen);
            try {
                if (clip==null||!clip.isOpen()) { 
                    File file = new File(filePath);
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    totalMicroS = clip.getMicrosecondLength();
                }
                if(isPaused){ 
                    clip.setMicrosecondPosition(pausedMicroS);
                } else {
                    clip.setMicrosecondPosition(0); 
                }
                clip.start();
                
                Timer timer = new Timer(100, e -> {
                    if (clip.isRunning()) {
                        currentMicroS = clip.getMicrosecondPosition();
                    } else {
                        Stop();
                    }
                });
                timer.setRepeats(true);
                timer.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void pause() {
        if (clip != null && clip.isRunning()) {
            pausedMicroS=clip.getMicrosecondPosition(); 
            clip.stop();
            isPlaying = false;
        }
    }

    public void Stop() {
        if (clip != null) {
            clip.stop();
            clip.setMicrosecondPosition(0); 
            currentMicroS = 0; 
            isPlaying = false;
        }
    }

    public void Resume() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(pausedMicroS); 
            clip.start();
            isPlaying = true;
            isPaused = false; 
        }
    }

    public void nextSong() {
        if (currentSongIndex < playlist.size() - 1) {
            currentSongIndex++;
            Stop();
            play();
        }
    }

    public void previousSong() {
        if (currentSongIndex > 0) {
            currentSongIndex--;
            Stop();
            play();
        }
    }
}

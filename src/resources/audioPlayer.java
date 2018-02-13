/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Nisal Priyanka
 */
public class audioPlayer {
    
    //store current position
    Long currentFrame;
    
    
    //current status of clip
    String status;
    static Status sts;
    
    //audioInputObject & FilePath
   
    static String filePath;
    
    //playing MP3
    Media mid;
    MediaPlayer mp;
    MediaView MediaView; 
    //constructor
    public audioPlayer(String path)
    {
        audioPlayer.filePath = path;
        
        try
        {

            mid = new Media(new File(audioPlayer.filePath).toURI().toString());
            mp = new MediaPlayer(mid);
            MediaView = new MediaView(mp);
           
            
        }
        catch(Exception e)
        {
            System.out.println("Audio Error "+e);
        }
        
    }
    
    public void setStus(Status customsts)
    {
        sts = customsts;
        System.out.println("Custome Status : "+sts);
    }
   
    public void play()
    {
        //set status     
            
       if(sts == this.sts.STOPPED || sts == sts.PAUSED || sts==sts.HALTED ||sts==sts.READY)
        {
            this.mp.play();
            sts = sts.PLAYING;
             
        }

    
    }
    
    public void pause()
    {
//        System.out.println(sts);
        if(sts == sts.PLAYING)
        {
            this.mp.pause();
            sts = sts.PAUSED;  
            System.out.println(sts);
        }
        
    }
    
    public void stop()
    {
        System.out.println(sts);
        if(sts==sts.PLAYING)
        {
            mp.stop();
            sts = sts.STOPPED;
        }
    }
    
}

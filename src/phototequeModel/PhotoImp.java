/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phototequeModel;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeListener;

/**
 *
 * @author mattiachenet
 */
public class PhotoImp implements PhotoModel {
    
    private BufferedImage photo;
    private ArrayList<ChangeListener> listenerList = new ArrayList<ChangeListener>();
    private Note annLib = new Note();
    private TextSkech textAnn = new TextSkech();

    
    Boolean isPhoto = false;
    Boolean isFlipped = false;
    Boolean isNoted= false;
    
    Boolean textInput = false;
    Boolean textInputKeyStart = false;
    Boolean txtAnnotation = false;
    
    public PhotoImp(String pathFile){
         this.setImage(pathFile);
    }
    
    @Override
    public boolean isFlip() {
       return isFlipped;
    }

    @Override
    public void flipImage(Boolean flip) {
        isFlipped = flip;
    
    }

    @Override
    public boolean isNoted() {
        return isNoted;
    }

    @Override
    public void annotateImage() {
        if(!isNoted){
            isNoted = true;
        }

    }

    @Override
    public void setImage(String filePath) {
        try {                
          photo = ImageIO.read(new File(filePath));
          isPhoto = true;
       } 
       catch (IOException ex) {
           
       }

    }

    @Override
    public void setKeyListener(ChangeListener k) {
        listenerList.add(k);

    }

    @Override
    public void setMouseListener(ChangeListener M) {
        listenerList.add(M);

    }

    @Override
    public void setMouseMotionListener(ChangeListener M) {
            listenerList.add(M);
    }

    @Override
    public void removeChangeListener(ChangeListener c) {
            listenerList.add(c);
    }

    @Override
    public void addChangeListener(ChangeListener c) {
        listenerList.add(c);
    }

    @Override
    public void includePoints(Point P) {
        annLib.includePoints(P);
    }

    @Override
    public void stopPoints() {
        annLib.stopPoints();
    }

    @Override
    public void includeChar(Character c) {
        textAnn.setChar(c);
    }

    @Override
    public TextSkech getChar() {

        return textAnn;

    }

    @Override
    public void deleteChar() {
        textAnn.deleteChar();

    }

    @Override
    public Note getAnnLib() {
        return annLib;
    }

    @Override
    public void setTextStart(Boolean state) {
        textInputKeyStart = true;

    }

    @Override
    public Boolean getTextStart() {
        return textInputKeyStart;
    }

    @Override
    public BufferedImage getImage() { 
        return photo;
    }
    
}

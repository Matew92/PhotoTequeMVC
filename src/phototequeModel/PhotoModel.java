/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phototequeModel;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.event.ChangeListener;

/**
 *
 * @author mattiachenet
 */
public interface PhotoModel{
    
    public boolean isFlip();
    public void flipImage(Boolean state);
    public boolean isNoted();
    public void annotateImage();
    public void setImage(String filePath);
    public BufferedImage getImage();
    public void setKeyListener(ChangeListener k);
    public void setMouseListener(ChangeListener M);
    public void setMouseMotionListener(ChangeListener M);
    public void removeChangeListener(ChangeListener c);
    public void addChangeListener(ChangeListener c); 
    public void includePoints(Point P);
    public void stopPoints();
    public void includeChar(Character c);
    public TextSkech getChar();
    public void deleteChar();
    public Note getAnnLib();
    public void setTextStart(Boolean state);
    public Boolean getTextStart();
    
    

    
}

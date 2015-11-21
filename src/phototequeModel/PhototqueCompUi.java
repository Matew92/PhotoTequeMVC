/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phototequeModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author mattiachenet
 */
public class PhototqueCompUi extends PhototequeUI implements MouseListener, MouseMotionListener, KeyListener{
    
    Boolean textInput = false;
    Boolean txtAnnotation = false;
    Boolean isPhoto = true;
    private Point textInputPt = new Point();

    public static PhototqueCompUi createUI(JComponent c) {
        return new PhototqueCompUi();
    }
    
     @Override
     public void installUI(JComponent c) {
         
        ((PhotoComp)c).addMouseListener(this);
        ((PhotoComp)c).addMouseMotionListener(this);
        ((PhotoComp)c).addKeyListener(this);
        ((PhotoComp)c).setFocusable(true);
    }

    @Override
    public void uninstallUI(JComponent c) {
        ((PhotoComp)c).setFocusable(false);
        ((PhotoComp)c).removeKeyListener(this);
        ((PhotoComp)c).removeMouseMotionListener(this);
        ((PhotoComp)c).removeMouseListener(this);
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        PhotoModel m;
        m = ((PhotoComp)e.getComponent()).getModel();
            if(e.getClickCount()>1){
                if(!m.isFlip()){
                         m.flipImage(true);
                         ((PhotoComp)e.getComponent()).update();
                }
                    else{ 
                        m.flipImage(true);
                        ((PhotoComp)e.getComponent()).update();
                                 }
            } else if(e.getClickCount()== 1){
                if(m.isFlip()){
                if(textInput)
                    textInput = false;
                else{
                    textInput = true;
                    textInputPt = e.getPoint(); 
                }
                ((PhotoComp) e.getComponent()).requestFocus();
                ((PhotoComp) e.getComponent()).update();
                }
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        PhotoModel m; 
        m = ((PhotoComp)e.getComponent()).getModel();
        if(m.isFlip()&& m.isNoted()){
            m.stopPoints();
            ((PhotoComp)e.getComponent()).update();
        }
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
    
        if(((PhotoComp)e.getComponent()).getModel().isFlip()){
            ((PhotoComp)e.getComponent()).getModel().includePoints(e.getPoint());
            ((PhotoComp)e.getComponent()).getModel().annotateImage();
            ((PhotoComp)e.getComponent()).update();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
    
        PhotoModel m; 
        m = ((PhotoComp)e.getComponent()).getModel();
        if((int)e.getKeyChar() == 8)
            m.deleteChar();
        else if((int)e.getKeyChar() == 27)
            textInput = false;
        else{
            m.includeChar(e.getKeyChar());
            m.setTextStart(true);
        }
        ((PhotoComp) e.getComponent()).update();
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
    
   
   @Override
    public void paint(Graphics g, JComponent c) {
        PhotoComp comp = (PhotoComp) c;
        PhotoModel model = comp.getModel();
        if(isPhoto){
            if(!model.isFlip()){
                g.drawImage(model.getImage(), 0, 0, comp.getWidth(), comp.getHeight(), null);         
            }
            else{
                g.setColor(Color.white);
                g.fillRect(0, 0, comp.getWidth(), comp.getHeight());
                if(model.isNoted()){
                    ArrayList<SketchPath> annList;
                    Note annLib = model.getAnnLib();
                    annList = model.getAnnLib().getPaths();
                    int j=0;
                    while(j < annList.size()){
                        ArrayList<Point> pth = annList.get(j).getPath();
                        int i = 0;
                        while(i < pth.size()){
                            g.setColor(Color.red);
                            if(i!=0)
                                if((pth.get(i).x != -1 && pth.get(i).y != -1) && (pth.get(i-1).x != -1 && pth.get(i-1).y != -1))
                                    g.drawLine(pth.get(i-1).x, pth.get(i-1).y, pth.get(i).x, pth.get(i).y);
                            else
                                g.drawLine(pth.get(i).x, pth.get(i).y, pth.get(i).x, pth.get(i).y);
                            i++;
                        }
                        j++;
                    }
                }
                if(model.getTextStart() && !textInput){
                    g.setColor(Color.black);
                    char[] textInputKeyChars = new char[model.getChar().getChar().size()];
                    for(int i = 0; i<model.getChar().getChar().size(); i++){
                        textInputKeyChars[i] = model.getChar().getChar().get(i);
                    }
                    g.drawChars(textInputKeyChars, 0, textInputKeyChars.length, 100, 100);
                }
                if(textInput){
                    System.out.println("a");
                    g.setColor(Color.black);
                    g.drawLine(textInputPt.x, textInputPt.y, textInputPt.x, textInputPt.y-10);
                    if(model.getTextStart()){
                        char[] textInputKeyChars = new char[model.getChar().getChar().size()];
                        for(int i = 0; i<model.getChar().getChar().size(); i++){
                            textInputKeyChars[i] = model.getChar().getChar().get(i);
                        }
                        g.drawChars(textInputKeyChars, 0, textInputKeyChars.length, textInputPt.x, textInputPt.y);
                        txtAnnotation = true;
                    }
                }
            }
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phototequeModel;

import java.io.File;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author mattiachenet
 */
public class PhotoComp extends JComponent implements ChangeListener{

    private PhotoModel model;
    
    public void setModel(PhotoModel photoModel){
        if (model != null)
                model.removeChangeListener(this);
        model = photoModel;
        model.addChangeListener(this);
    }
    
   

    @Override
    public void stateChanged(ChangeEvent e) {
    }
    
    public void setUI(PhototequeUI ui) {
        super.setUI(ui);
    }

    private void refreshUi() {
        System.out.println("a");
        PhototequeUI p = (PhototequeUI)UIManager.getUI(this);
        setUI(p);
        invalidate();
    }
    
    
    
    public PhotoModel getModel() {
        return model;
    }
    
     public PhotoComp(File file) {
        super();
        System.out.println("here");
        setModel(new PhotoImp(file.getAbsolutePath()));
        refreshUi();
    }
    
    public void update(){
        repaint();
    }
    
}

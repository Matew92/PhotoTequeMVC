/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogphototequeView;

import java.awt.GridLayout;
import java.io.File;
import javax.swing.JPanel;

import phototequeModel.PhotoComp;

/**
 *
 * @author mattiachenet
 */
class MainPanel extends JPanel{
    

    public MainPanel() {
        setLayout(new GridLayout(1, 1, 1, 1));
    }
    
    public void addPhoto(String pathFile){
        
        File file = new File(pathFile);
        PhotoComp photo = new PhotoComp(file);
        add(photo);
        //addPhoto(pathFile);
                
    }
    
    
    
}

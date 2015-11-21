/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogphototequeView;

import javax.swing.JFrame;
import javax.swing.UIManager;

import phototequeModel.PhototequeUI;
import phototequeModel.PhototqueCompUi;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author mattiachenet
 */
public class AdvProgPhototeque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        UIManager.getDefaults().put(PhototequeUI.UI_CLASS_ID, phototequeModel.PhototqueCompUi.class.getName());
        
	FrameWindow frameWindow = new FrameWindow();

	frameWindow.setSize(400, 400);
	frameWindow.setMinimumSize(new Dimension(400, 400));
	
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frameWindow.getSize();
		
        
        if(frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        if(frameSize.width > screenSize.width)
            frameSize.height = screenSize.width;
        
        frameWindow.setLocation((screenSize.width - frameSize.width)/2,
                (screenSize.height - frameSize.height)/2);
        
	frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frameWindow.setVisible(true);
        
        
    }

    
}

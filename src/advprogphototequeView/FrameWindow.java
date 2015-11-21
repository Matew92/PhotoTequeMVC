/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogphototequeView;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 *
 * @author mattiachenet
 */
class FrameWindow extends JFrame{

    
    private UpperPanel upperPanel;
    private StatusBar statusBar;
    private SubMenu menu;
    private MainPanel mainPanel;
    
    
    public FrameWindow(){
        setWindowUi();
    }

    private void setWindowUi() {
        setLayout(new BorderLayout());
        setTitle("Photeque");
        addUpperpanel();
        addStatusBar();
        addMainpanel();
        addMenu();
        
        
    }

    private void addUpperpanel() {
        upperPanel = new UpperPanel();
        add(upperPanel, BorderLayout.NORTH);
    }

    private void addStatusBar() {
        statusBar = new StatusBar();
        add(statusBar, BorderLayout.SOUTH);
    }

    private void addMenu() {
        menu = new SubMenu(statusBar.statusLabel, mainPanel, this);
        setJMenuBar(menu);
               
    }

    private void addMainpanel() {
        mainPanel = new MainPanel();
        add(mainPanel,BorderLayout.CENTER);
    }
    
}

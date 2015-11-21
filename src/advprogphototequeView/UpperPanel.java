/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogphototequeView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author mattiachenet
 */
class UpperPanel extends JPanel{
    
    public UpperPanel(){
        setLayout(new GridBagLayout());
        JToggleButton familyBtn = new JToggleButton("Family");
        JToggleButton vacaionBtn = new JToggleButton("Vacation");
        JToggleButton schoolBtn = new JToggleButton("School");
        GridBagConstraints lim = new GridBagConstraints();
        
        lim.gridx = 1;
        lim.gridy = 0;
        add(familyBtn,lim);
        lim.gridx = 2;
        lim.gridy = 0;
        add(vacaionBtn,lim);
        lim.gridx = 3;
        lim.gridy = 0;
        add(schoolBtn,lim);
    }
    
}

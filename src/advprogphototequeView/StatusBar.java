/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogphototequeView;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mattiachenet
 */
class StatusBar extends JPanel {
    
    JLabel statusLabel;
            
	public StatusBar() {
            
            setLayout(new GridBagLayout());
            statusLabel = new JLabel("status");
            setBackground(Color.white);
            GridBagConstraints lim = new GridBagConstraints();
            
            lim.gridx = 1;
            lim.gridy = 0;
            add(statusLabel,lim);
	}
    
}

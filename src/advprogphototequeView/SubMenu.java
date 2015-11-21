/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogphototequeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mattiachenet
 */
class SubMenu extends JMenuBar{
    JMenu menu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    JFileChooser filechooser;

        public SubMenu(final JLabel label,final MainPanel center,final JFrame winodw) {
            
            filechooser = new JFileChooser();
            filechooser.setFileSelectionMode(filechooser.FILES_ONLY);  
            FileFilter filter = new FileNameExtensionFilter("Image files","jpeg","jpg");
            filechooser.setFileFilter(filter);
            menu = new JMenu("File");
            menuItem = new JMenuItem("Import",KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
            menuItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Select Import");
                    
                    int returnVal = filechooser.showOpenDialog(winodw);
                    if (returnVal == filechooser.APPROVE_OPTION) {     
                        label.setText("File Selected :" + filechooser.getSelectedFile().getName());
                        center.addPhoto(filechooser.getSelectedFile().getAbsolutePath());
                    }
                    else{
                        label.setText("Open command cancelled by user." );
                    }
                }
            });
            
            menu.add(menuItem);
            menuItem = new JMenuItem("Delete",KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription("Delete a photo");
            menuItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Not yet implemented!");
                }
            });
            menu.add(menuItem);
            menuItem = new JMenuItem("Quit",KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription("Quit program");
            menuItem.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Quitting...");
                    System.exit(0);
                }
            });
            menu.add(menuItem);
            this.add(menu);
            
            menu = new JMenu("View");
            ButtonGroup group = new ButtonGroup();
            rbMenuItem = new JRadioButtonMenuItem("Photo viewer");
            rbMenuItem.setSelected(true);
            rbMenuItem.setMnemonic(KeyEvent.VK_R);
            group.add(rbMenuItem);
            menu.add(rbMenuItem);
            rbMenuItem = new JRadioButtonMenuItem("Browser");
            rbMenuItem.setMnemonic(KeyEvent.VK_R);
            group.add(rbMenuItem);
            menu.add(rbMenuItem);
            rbMenuItem = new JRadioButtonMenuItem("Split mode");
            rbMenuItem.setMnemonic(KeyEvent.VK_R);
            group.add(rbMenuItem);
            menu.add(rbMenuItem);
            this.add(menu);
        }
    }
    
    


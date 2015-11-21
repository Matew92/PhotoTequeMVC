/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phototequeModel;

import java.util.ArrayList;

/**
 *
 * @author mattiachenet
 */
class TextSkech {
private ArrayList<Character> textKey;
    
    
    public TextSkech(){
        textKey = new ArrayList<Character>();
    }
    
    public void deleteChar() {
        textKey.remove(textKey.size()-1);
    }

    public void setChar(Character c) {
        textKey.add(c);
    }

    public ArrayList<Character> getChar(){
        return textKey;
    }
    
}

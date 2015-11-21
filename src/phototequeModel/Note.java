/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phototequeModel;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author mattiachenet
 */
public class Note {
    
    private ArrayList<SketchPath> paths;
    private SketchPath currentPath;
    
    public Note(){
        paths = new ArrayList<>();
        currentPath = new SketchPath();
    }

    void stopPoints() {
        paths.add(currentPath);
        currentPath.erasePath();
    }

    void includePoints(Point P) {
        currentPath.setPath(P);
        
    }

    ArrayList<SketchPath> getPaths() {
        return paths;
    }
    
}

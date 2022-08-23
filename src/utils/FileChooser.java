package utils;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;

public class FileChooser {


    public static File openFile(Component frame) {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(frame); //Where frame is the parent component

        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        } else {
        }
        
        return file;
    }
}

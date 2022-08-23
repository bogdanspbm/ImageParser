package utils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class URLDatabase {

    private File file = null;
    private List<String> lines;

    public URLDatabase() {

    }
    
    public int getLinesCount(){
        return lines.size();
    }

    public void parseFile(File file) {
        try {
            this.file = file;
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.US_ASCII);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public List<String> getURLs(){
        return lines;
    }
}

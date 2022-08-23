/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import static utils.GlobalFunctions.urlToSearchURL;
import static utils.Settings.getBanned;

/**
 *
 * @author crewd
 */
public class URLParser {

    Document document = null;
    String url;

    public URLParser(String url) {
        try {
            this.url = url;
            document = Jsoup.connect(urlToSearchURL(url)).get();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean parse() {
        boolean flag = false;
        for (String bannedWord : getBanned()) {
            if (document.toString().contains(bannedWord)) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println(url);
        }
        
        return !flag;
    }
}

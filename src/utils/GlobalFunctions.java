package utils;

import java.util.ArrayList;
import java.util.List;

public class GlobalFunctions {

    public static String urlToSearchURL(String url) {
        String prefix = "https://yandex.ru/images/search?rpt=imageview&url=";
        String res = prefix + url;
        return res;
    }

    public static List<String> getRowByURL(String url, boolean flag) {
        List<String> res = new ArrayList<>();

        res.add(url);
        if (flag) {
            res.add("OK");
        } else {
            res.add("BANNED");
        }

        res.add(urlToSearchURL(url));

        return res;
    }
}

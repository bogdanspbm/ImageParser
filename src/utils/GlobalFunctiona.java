
package utils;

public class GlobalFunctiona {
 public static String urlToSearchURL(String url){
     String prefix = "https://yandex.ru/images/search?rpt=imageview&url=";
     String res = prefix + url;
     return res;
 }   
}

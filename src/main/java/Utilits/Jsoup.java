package Utilits;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/** Connects JSOUP.
 * host = URL to connect
 * cssQuery = path to element, for example: meta[name="description"]
 * */

public class Jsoup {

    public Elements getElements(String host, String cssQuery) {
        Elements elements = new Elements();
        try {
            Document doc = org.jsoup.Jsoup.connect(host).timeout(10 * 10000).get();
            elements = doc.select(cssQuery);
        } catch (IOException e) {
            System.out.println("IOException from Jsoup");
        }
        return elements;
    }
}
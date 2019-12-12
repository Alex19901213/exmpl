package Utilits;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 *  Custom parser. Parse links from sitemaps.
 *  Distinctive feature: Parse links from mobile sitemaps.*/
public class LinksGetter {
    private CreateNewFile createNewFile = new CreateNewFile();

    private String fName = "ParseFile.txt";
    private File input = new File(fName);
    private String[] parts;
    private String textFromDoc;
    private SortedSet<String> urls = new TreeSet<>();



    public SortedSet<String> parse(String text) throws IOException {
        createNewFile.create(fName);
        writer(text);
        input = new File(fName);
        Document doc = Jsoup.parse(input, "UTF-8", "http://");
        textFromDoc = doc.text();
        parts = textFromDoc.split(" "); //returns an array with the 2 parts
        for (String v : parts) {
            if (v.contains("http")) {
                urls.add(v);
            }}
        return urls;
    }

    private void writer(String text){
        try (FileWriter writer = new FileWriter(fName, false))
        {
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
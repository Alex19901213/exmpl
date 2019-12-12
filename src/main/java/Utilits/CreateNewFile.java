package Utilits;

import java.io.File;
import java.io.IOException;
public class CreateNewFile {
    public void create(String name) {
        try {
            String fileSeparator = System.getProperty("file.separator");
            String absoluteFilePath = "D:"+ fileSeparator + "Work" + fileSeparator + "Projects" + fileSeparator + "Sy3" + fileSeparator + name;
            File file = new File(absoluteFilePath);
            if (file.createNewFile()) {
            } else {
                file = new File(name);
                if (file.createNewFile()) {
                }
                else {}
            }
        }
        catch (IOException f)
        {
            System.out.println("Cannot create file. (CeateNewFile.class)");
        }
    }
}
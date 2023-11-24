package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final static String DEFAULT_FILE = "output.txt";
    private final static String SEP = System.getProperty("file.separator");
    private final static String FILE_NAME = System.getProperty("user.home") +
                                            SEP + "Documents" + SEP + "OOP" +
                                            SEP + "OOP" + SEP + "Esercizi OOP9" +
                                            SEP + "lab09" + SEP + 
                                            "93-simple-mvc-io" + SEP +
                                            DEFAULT_FILE;
    
    private File file;

    public Controller(){
        this.file = new File(FILE_NAME);
    }

    public void setFile(final File file){
        this.file = file;
    }

    public File getFile(){
        return this.file;
    }

    public String getFilePath(){
        return this.file.getPath();
    }

    public void setFileContent(final String content) throws IOException{
        try (final BufferedWriter bf = new BufferedWriter(new FileWriter(this.file))) {
            bf.write(content);   
        }
    }
}

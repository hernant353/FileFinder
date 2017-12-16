package Model;

import Model.Directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class UserFile{

    // The File of this Model.UserFile object.
    private File file;
    // The directory which this File is located in.
    private Directory directory;
    // The name of the File object.
    private String fileName;
    // The time stamp of the file which indicates when it was last used.
    private Long timeStamp;

    public UserFile(File file, Directory fileDirectory){
        this.file = file;
        this.directory = fileDirectory;
        this.fileName = file.getName();
        this.timeStamp = file.lastModified();
    }

    /**
     * Returns the time stamp of the file (the last modified use)
     *
     * @return Long
     */
    Long getTimeStamp(){
        return file.lastModified();
    }

    /**
     * Returns the name of the File.
     *
     * @return String
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * Returns the last modification date of this file.
     *
     * @return Date
     */
    public String getLastAccessedDate() throws IOException {
        Path thisUserFile = Paths.get(this.file.getAbsolutePath());
        BasicFileAttributes fileAttributes = Files.readAttributes(thisUserFile, BasicFileAttributes.class);
        return fileAttributes.lastAccessTime().toString();
    }

}
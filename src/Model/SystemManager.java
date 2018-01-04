package Model;

import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class SystemManager {

    // An ArrayList of all directories containing Files
    static ArrayList<Directory> directories = new ArrayList<>();

    /**
     * The indicated time stamp which will be used to return any files that have a
     * time stamp older than the indicated cutoff.
     */
    private long timeStampCutOff;

    /**
     * Initializes a new SystemManager object which will hold all the directory objects.
     */
    public SystemManager() {
    }

    /**
     * Adds a new Directory object to the current list of directories.
     *
     * @param directory: A directory object to be added to the list of directories.
     */
    public void addDirectory(Directory directory) {
        if (!directories.contains(directory)) {
            directories.add(directory);
        }
    }

    /**
     * Adds a new Directory object to the current list of directories by creating
     * a new directory object with the given path.
     *
     * @param directoryPath: the path of the directory
     */
    public void addDirectory(String directoryPath){
        Directory newDirectory = new Directory(directoryPath);
        if (!directories.contains(newDirectory)){
            directories.add(newDirectory);
        }
    }
    
    /**
     * Returns an ArrayList of the current directories.
     *
     * @return ArrayList<Directory>
     */
    public ArrayList<Directory> getDirectories() {
        return directories;
    }

    /**
     * Returns the appropriate directory by a specified path.
     *
     * @param path: the path of the directory in the user's computer.
     * @return Directory
     */
    public Directory getDirectoryByPath(String path) {
        for (Directory d : directories) {
            if (d.getDirectoryFile().getAbsolutePath().equals(path)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Searches for a Model.UserFile with the name 'name'. If there is not a
     * Model.UserFile with the given name, it will return null.
     *
     * @param name: The specified Model.UserFile name
     * @return File
     */
    public static UserFile searchFileByName(String name) {
        for (Directory dir : directories) {
            for (UserFile file : dir.getFileList()) {
                if (file.getFileName().equals(name)) {
                    return file;
                }
            }
        }
        return null;
    }

    public ArrayList<UserFile> getOldUserFiles(){
    	ArrayList<UserFile> allUserFiles = new ArrayList<>();
    	//Date date = new Date(timeStamp);
    	for (Directory dir: directories){
    	    allUserFiles.addAll(dir.extractFiles());
    	}
    	return allUserFiles;
    }

}

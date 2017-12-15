package Model;

import java.io.*;
import java.util.ArrayList;

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

    public ArrayList<UserFile> getOldUserFiles(long timeStamp){
    	ArrayList<UserFile> allUserFiles = new ArrayList<>();
    	for (Directory dir: directories){
    		ArrayList<UserFile> currentDir = dir.extractFiles();
    		for (UserFile file: currentDir){
    			if (file.getTimeStamp() < timeStamp){
    				allUserFiles.add(file);
    			}
    		}
    	}
    	return allUserFiles;
    }

}

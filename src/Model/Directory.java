package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Directory {

    // An ArrayList of all the UserFiles
    private ArrayList<UserFile> userFileList = new ArrayList<>();
    // The directory path of this Model.Directory object.
    private String directoryPath;
    // The directory File of this Model.Directory object.
    private File directoryFile;

    public Directory(String path) {
        this.directoryPath = path;
        this.directoryFile = new File(path);
    }

    /**
     * Returns the directory path of this directory.
     * 
     * @return String
     */
    private String getDirectoryPath() {
        return this.directoryPath;
    }

    /**
     * Returns an ArrayList of UserFiles contained within this 
     * Directory
     * 
     * @return ArrayList<UserFile>
     */
    ArrayList<UserFile> getFileList() {
        return this.userFileList;
    }

    /**
     * Returns the file to which this directory is referring to.
     * 
     * @return File
     */
    File getDirectoryFile() {
        return this.directoryFile;
    }


    /**
     * Extracts all the files contained within this directory and returns
     * them as UserFile objects contained within an ArrayList.
     * 
     * @return ArrayList<UserFile>
     */
    ArrayList<UserFile> extractFiles(){
    	File[] directoryFiles = this.directoryFile.listFiles();
        ArrayList<UserFile> resultFiles = new ArrayList<>();
        if (directoryFiles != null){
            for (File f : directoryFiles) {
                if (f.isFile()) {
                    if(SystemManager.searchFileByName(f.getName()) == null) {
                        UserFile file = new UserFile(f, this);
                        resultFiles.add(file);
                    }
                    else{
                        resultFiles.add(SystemManager.searchFileByName(f.getName()));
                    }
                }
                else if(f.isDirectory()){
                    Directory newDirectory = new Directory(f.getAbsolutePath());
                    resultFiles.addAll(newDirectory.extractFiles());
                }
            }
        }
        return resultFiles;
    }

    /**
     * Returns a list of all the file names stored within this directory.
     * 
     * @return ArrayList<String>
     */
    private ArrayList<String> getFileNames() {
        ArrayList<String> var1 = new ArrayList<>();
        Iterator<UserFile> var2 = this.userFileList.iterator();
        while(var2.hasNext()) {
            UserFile var3 = (UserFile)var2.next();
            var1.add(var3.getFileName());
        }
        return var1;
    }
}

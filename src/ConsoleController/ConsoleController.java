package ConsoleController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import Model.SystemManager;
import Model.UserFile;

public class ConsoleController {


    public static void main(String[] args) throws IOException {
        // Start time
        long start = System.currentTimeMillis();

        // Set default output to a text file instead of standard out
        File fileOutput = new File("output.txt");
        if (fileOutput.exists()){
            if (fileOutput.delete()){
                PrintStream out = new PrintStream(new FileOutputStream(fileOutput));
                System.setOut(out);
            }
            else{
                System.out.println("output.txt already exists and deletion failed!");
                System.exit(1);
            }
        }
        else{
            PrintStream out = new PrintStream(new FileOutputStream(fileOutput));
            System.setOut(out);
        }


        SystemManager sm = new SystemManager();
        sm.addDirectory("C:\\Users");
        ArrayList<UserFile> ufiles = sm.getOldUserFiles();
        String temp;

        for (UserFile file: ufiles){
            try {
                temp = file.getFileName() + "     " + file.getLastAccessedDate();
                System.out.println(temp);
            }
            catch (Exception e){
                System.out.println("File: " + file + " may not exist!");
                continue;
            }
        }

        // Stop time
        long stop = System.currentTimeMillis();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("The program ran for "+
                (((stop - start) / 1000) / 60) + " minutes, and " +
                (((stop - start) / 1000) % 60) + " seconds.");
    }


}

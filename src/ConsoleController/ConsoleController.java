package ConsoleController;

import java.io.IOException;
import java.util.ArrayList;
import Model.SystemManager;
import Model.UserFile;

public class ConsoleController {


    public static void main(String[] args) throws IOException {
        // Start time
        long start = System.currentTimeMillis();

        SystemManager sm = new SystemManager();
        sm.addDirectory("C:\\Users");
        ArrayList<UserFile> ufiles = sm.getOldUserFiles();

        for (UserFile file: ufiles){
            try {
                System.out.println(file.getFileName() + "     " + file.getLastAccessedDate());
            }
            catch (Exception e){
                System.out.println("File: " + file + " may not exist!");
                continue;
            }
        }

        // Stop time
        long stop = System.currentTimeMillis();
        System.out.println("\n\n The program ran for "+
                (((stop - start) / 1000) / 60) + " minutes, and " +
                (((stop - start) / 1000) % 60) + " seconds.");
    }


}

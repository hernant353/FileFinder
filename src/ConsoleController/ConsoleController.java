package ConsoleController;

import java.io.IOException;
import java.util.ArrayList;
import Model.SystemManager;
import Model.UserFile;

public class ConsoleController {


    public static void main(String[] args) throws IOException {
        SystemManager sm = new SystemManager();
        sm.addDirectory("C:\\Users");
        ArrayList<UserFile> ufiles = sm.getOldUserFiles();
        for (UserFile file: ufiles){
            System.out.println(file.getFileName() + "     " + file.getLastAccessedDate());
        }
    }


}

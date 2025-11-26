import java.io.File;
import java.nio.file.Paths;

public class RecursiveLister
{
    private FileChooserLauncher launcher;

    public RecursiveLister()
    {
        launcher = new FileChooserLauncher();
    }

    public void launchSearch()
    {
        File selectedFile = launcher.chooseFile();
        search(selectedFile);
    }

    public void search(File searchFile)
    {
        File[] dList = searchFile.listFiles();

        if(dList != null) {
            for (File f : dList) {
                if(f.isFile())
                {
                    //write something to print it to the GUI; need to print absolute path and whether it is a file or a directory
                } else if (f.isDirectory() && !f.isHidden()) {
                    //print something to the gui and recursive call
                    search(f);
                }
            }
        } else
        {
            return null;
        }

        //need to list the files from the directory
        //need a way to iterate through each of them and return their file lists
    }
}

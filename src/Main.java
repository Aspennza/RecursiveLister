import java.io.File;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        RecursiveLister lister = new RecursiveLister();
        FileChooserLauncher launcher = new FileChooserLauncher();
        File selectedFile = launcher.chooseFile();
        if(selectedFile != null) {
            ArrayList<SearchResult> output = lister.search(selectedFile);
            for (SearchResult i : output) {
                boolean isFile = i.isFile();
                String absolutePath = i.getAbsolutePath();

                System.out.println("Directory contains:\n");

                if (isFile) {
                    System.out.println("Found a file: " + absolutePath + "\n");
                } else {
                    System.out.println("Found a directory: " + absolutePath + "\n");
                }
            }
        }
    }
}
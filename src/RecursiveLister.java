import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RecursiveLister
{
    public ArrayList<SearchResult> search(File searchFile)
    {
        ArrayList<SearchResult> result = new ArrayList<>();
        File[] dList = searchFile.listFiles();

        if(dList != null) {
            for (File f : dList) {
                if(f.isFile())
                {
                    //write something to print it to the GUI; need to print absolute path and whether it is a file or a directory
                    result.add(new SearchResult(true, f.getAbsolutePath()));
                } else if (f.isDirectory() && !f.isHidden()) {
                    //print something to the gui and recursive call
                    result.add(new SearchResult(false, f.getAbsolutePath()));
                    result.addAll(search(f));
                }
            }
        }
        return result;
    }
}

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Allows the creation of objects for recursively searching a directory
 * in the file system and outputting all directories and files underneath it.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class RecursiveLister
{
    /**
     * This method accepts a directory, creates an ArrayList, and calls the recursiveFileSearch method
     * to output an ArrayList of SearchResult objects.
     * @param searchFile the File (directory) to be searched
     * @return an ArrayList of SearchResult objects
     */
    public ArrayList<SearchResult> search(File searchFile)
    {
        ArrayList<SearchResult> result = new ArrayList<>();
        recursiveFileSearch(searchFile, result);
        return result;
    }

    /**
     * This method generates an array of all files under a given directory, then categorizes
     * them as files or directories. If one is a directory, it gets recursively searched.
     * @param file the directory to be searched
     * @param result the ArrayList of SearchResults to be recursively constructed
     */
    private void recursiveFileSearch(File file, ArrayList<SearchResult> result)
    {
        File[] dList = file.listFiles();

        //This algorithm checks whether the list of subfiles is null before continuing to search
        if(dList != null) {
            //This algorithm iterates through all subfiles
            for (File f : dList) {
                //This algorithm checks if each subfile is a file or a directory and generates either a file SearchResult or a directory SearchResult
                if(f.isFile())
                {
                    result.add(new SearchResult(true, f.getAbsolutePath()));
                } else if (f.isDirectory() && !f.isHidden()) {
                    result.add(new SearchResult(false, f.getAbsolutePath()));
                    recursiveFileSearch(f, result);
                }
            }
        }
    }
}

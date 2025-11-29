import java.io.File;
import java.util.ArrayList;

/**
 * Coordinates the activity of the RecursiveLister and
 * the FileChooserLauncher by prompting a JFileChooser
 * and calling the lister's search method.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ListController
{
    //A RecursiveLister for searching the provided directory
    private final RecursiveLister lister;

    //A FileChooserLauncher for prompting the JFileChooser
    private final FileChooserLauncher launcher;

    //This constructor instantiates the RecursiveLister and FileChooserLauncher
    public ListController() {
        lister = new RecursiveLister();
        launcher = new FileChooserLauncher();
    }

    /**
     * This method prompts the JFileChooser to launch and, if a directory is returned,
     * prompts the RecursiveLister to search it.
     * @return an ArrayList of SearchResult objects containing the directories and files found by the search
     */
    public ArrayList<SearchResult> launchSearch()
    {
        File selectedFile = launcher.chooseFile();

        //This algorithm checks that the user selected a directory
        if (selectedFile != null) {
            return lister.search(selectedFile);
        }
        else {
            return null;
        }
    }

    /**
     * This method resets the program to its default state
     */
    public void reset() {
        launcher.resetChooser();
    }

    public RecursiveLister getLister() {
        return lister;
    }

    public FileChooserLauncher getLauncher() {
        return launcher;
    }
}

import java.io.File;
import java.util.ArrayList;

public class ListController
{
    private RecursiveLister lister;
    private FileChooserLauncher launcher;

    public ListController() {
        lister = new RecursiveLister();
    }

    public ArrayList<SearchResult> launchSearch()
    {
        File selectedFile = launcher.chooseFile();
        return lister.search(selectedFile);
    }
}

import java.io.File;
import java.util.ArrayList;

public class ListController
{
    private final RecursiveLister lister;
    private final FileChooserLauncher launcher;

    public ListController() {
        lister = new RecursiveLister();
        launcher = new FileChooserLauncher();
    }

    public ArrayList<SearchResult> launchSearch()
    {
        File selectedFile = launcher.chooseFile();
        if (selectedFile != null) {
            return lister.search(selectedFile);
        }
        else {
            return null;
        }
    }

    public void reset() {
        launcher.resetChooser();
    }
}

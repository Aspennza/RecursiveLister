/**
 * Creates a ListViewer object so that the ListViewer.java program
 * can be tested and run.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ListViewerRunner
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This ListViewer object creates an instance of the ListViewer.java class
        ListViewer viewer = new ListViewer();
        viewer.start();
    }
}
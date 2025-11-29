import javax.swing.*;
import java.io.File;
import java.nio.file.Path;

/**
 * Allows the creation of objects containing a JFileChooser for selecting
 * directories, basic methods for prompting the user to select a directory,
 * and a method for clearing the chooser.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class FileChooserLauncher
{
    //NOTE: This class could not be JUnit tested, as it threw an IndexOutOfBoundsException
    //whenever any of its methods were run in a headless environment (as a JFileChooser
    //cannot successfully be created in a headless JUnit environment, according to my
    //research). I attempted to refactor this class to be as compartmentalized as possible,
    //but without using methods outside the scope of this course (i.e., object mocking,
    //skipping the tests when in a headless environment, etc.), this class could not be tested.

    //This JFileChooser is used to prompt the user to pick a directory
    private JFileChooser chooser;

    private void setUpChooser() {
        chooser = new JFileChooser();
        configureChooser(chooser);
    }

    public void configureChooser(JFileChooser chooser) {
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);
    }

    /**
     * This method prompts the user to choose a file, returning the File if they pick one and returning null if they don't
     * @return a File representing the user's chosen file
     */
    public File chooseFile() {
        setUpChooser();

        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    /**
     * This method initializes a new JFileChooser and resets its directory
     */
    public void resetChooser() {
        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    }

    public JFileChooser getChooser() {
        return chooser;
    }
}

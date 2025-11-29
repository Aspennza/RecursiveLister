import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//UML

/**
 * Coordinates the GUI panel components of the program with the
 * ListController's functionality to output the results of the
 * RecursiveLister's search to the GUI.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ListViewer
{
    //This JFrame contains all the other GUI components of the program
    private JFrame frame;

    //A TitlePnl containing the logic for formatting the titlePnl
    private TitlePnl titlePnl;

    //A ControlPnl containing the logic for formatting the controlPnl
    private ControlPnl controlPnl;

    //A FileDisplayPnl containing the logic for formatting the fileDisplayPnl
    private FileDisplayPnl fileDisplayPnl;

    //A ListController that coordinates the core searching functionality of the program
    private ListController controller;

    /**
     * This method initializes the JFrame, JPanels, and ListController, as well as the GUI's ActionListeners
     */
    public void start() {
        controller = new ListController();
        generateFrame();
        setUpStartListener();
        setUpResetListener();
        setUpQuitListener();
        JOptionPane.showMessageDialog(null, "Welcome to the Recursive File Lister! Begin by pressing Start and selecting a directory whose contents you want to list.");
    }

    /**
     * This method establishes the JFrame, its panels, and its layout and settings
     */
    public void generateFrame() {
        frame = new JFrame();

        //GridBagConstraints for the titlePnl
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 1;
        gbc1.gridheight = 1;
        gbc1.weightx = 1;
        gbc1.fill = GridBagConstraints.BOTH;

        //GridBagConstraints for the controlPnl
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 1;
        gbc2.weightx = 1;
        gbc2.fill = GridBagConstraints.BOTH;

        //GridBagConstraints for the FileDisplayPnl
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.gridwidth = 1;
        gbc3.gridheight = 3;
        gbc3.weightx = 1;
        gbc3.weighty = 1;
        gbc3.fill = GridBagConstraints.BOTH;

        //This JPanel is used to store all the other elements in the GUI
        JPanel mainPnl = new JPanel();

        //This Toolkit is used to find the screen size of the computer running the GUI
        Toolkit kit = Toolkit.getDefaultToolkit();

        //This Dimension stores the screen size
        Dimension screenSize = kit.getScreenSize();

        //This int stores the height of the screen
        int screenHeight = screenSize.height;

        //This int stores the width of the screen
        int screenWidth = screenSize.width;

        mainPnl.setLayout(new GridBagLayout());
        frame.add(mainPnl);

        titlePnl = new TitlePnl();
        mainPnl.add(titlePnl, gbc1);

        controlPnl = new ControlPnl();
        mainPnl.add(controlPnl, gbc2);

        fileDisplayPnl = new FileDisplayPnl();
        mainPnl.add(fileDisplayPnl, gbc3);

        frame.setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Recursive File Lister");
        frame.setVisible(true);
    }

    /**
     * This method resets the program to its original state
     */
    public void reset()
    {
        controlPnl.reset();
        fileDisplayPnl.reset();
        controller.reset();
    }

    /**
     * This method accepts an ArrayList of SearchResult objects from the RecursiveLister
     * and formats them so they can be appended neatly to the GUI's JTextArea.
     * @param results the ArrayList of SearchResult objects from the RecursiveLister
     * @return a String containing the SearchResult data after formatting
     */
    public String formatSearchResult(ArrayList<SearchResult> results)
    {
        //A StringBuilder is used here to avoid repeated String creation in the for loop
        StringBuilder text = new StringBuilder();

        //This algorithm checks that the results ArrayList is not null before creating a formatted String
        if(results != null) {
            text.append(("Directory contains:\n"));

            //This algorithm adds the data from each SearchResult to the final String
            for (SearchResult r : results) {
                text.append(r.display()).append("\n\n");
            }
        }
        return text.toString();
    }

    /**
     * This method appends the formatted String from formatSearchResult to the GUI's JTextArea.
     * @param results the ArrayList of SearchResults from the RecursiveLister
     * @return a boolean representing whether the data was successfully appended
     */
    public boolean displaySearchResult(ArrayList<SearchResult> results)
    {
        String formatted = formatSearchResult(results);

        //This algorithm makes sure the formatted String is not empty before appending
        if(!formatted.isEmpty()) {
            fileDisplayPnl.showResults(formatted);
            return true;
        }
        return false;
    }

    /**
     * This method sets up the logic for the GUI's start button by
     * launching the file chooser and displaying the search results
     * to the GUI's JTextArea. Also deactivates and reactivates
     * JButtons as needed.
     */
    private void handleStart() {
        ArrayList<SearchResult> results = controller.launchSearch();
        boolean displayed = displaySearchResult(results);

        //If the data was successfully displayed, the start button is deactivated and reset is activated
        if (displayed) {
            controlPnl.deactivateStartBtn();
            controlPnl.activateResetBtn();
        }
    }

    /**
     * This method sets up the logic for the GUI's reset button by
     * sending the user a confirmation dialog and resetting the program if they confirm.
     */
    private void handleReset() {
        //This int tracks whether the user confirmed or denied they wanted to reset the program
        int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the program?", "Reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        //This algorithm determines whether to reset the program based on the user's input
        if(selection == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Resetting the program...");
            reset();
        } else
        {
            JOptionPane.showMessageDialog(null, "The program will stay as-is.");
        }
    }

    /**
     * This method sets up the logic for the GUI's quit button by
     * sending the user a confirmation dialog and quitting the program if they confirm.
     */
    private void handleQuit() {
        //This int tracks whether the user confirmed or denied they wanted to quit the program
        int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit? You can press Reset to reset the program.", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        //This algorithm determines whether to quit the program based on the user's input
        if(selection == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Quitting the program...");
            System.exit(0);
        } else
        {
            JOptionPane.showMessageDialog(null, "The program will remain open.");
        }
    }

    /**
     * This method sets up the ActionListener for the start button.
     */
    public void setUpStartListener() {
        controlPnl.addStartActionListener((ActionEvent ae) -> handleStart());
    }

    /**
     * This method sets up the ActionListener for the reset button.
     */
    public void setUpResetListener()
    {
        controlPnl.addResetActionListener((ActionEvent ae) -> handleReset());
    }

    /**
     * This method sets up the ActionListener for the quit button.
     */
    public void setUpQuitListener()
    {
        controlPnl.addQuitActionListener((ActionEvent ae) -> handleQuit());
    }

    public JFrame getFrame() {
        return frame;
    }

    public TitlePnl getTitlePnl() {
        return titlePnl;
    }

    public ControlPnl getControlPnl() {
        return controlPnl;
    }

    public FileDisplayPnl getFileDisplayPnl() {
        return fileDisplayPnl;
    }

    public ListController getController() {
        return controller;
    }
}

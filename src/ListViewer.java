import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//See about making JTextArea output look any cleaner
//See about making the GUI prettier
//Do code review to see if it can be more OOP/if there are any errors
//Final test runs
//JUnit
//Javadoc
//UML

public class ListViewer
{
    private JFrame frame;
    private TitlePnl titlePnl;
    private ControlPnl controlPnl;
    private FileDisplayPnl fileDisplayPnl;
    private ListController controller;

    public void start() {
        controller = new ListController();
        generateFrame();
        setUpStartListener();
        setUpResetListener();
        setUpQuitListener();
    }

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

    private void reset()
    {
        controlPnl.reset();
        fileDisplayPnl.reset();
        controller.reset();
    }

    private boolean displaySearchResult(ArrayList<SearchResult> results)
    {
        fileDisplayPnl.getFileTA().setText("");

        if(results != null) {
            fileDisplayPnl.getFileTA().append("Directory contains:\n");

            for (SearchResult r : results) {
                boolean isFile = r.isFile();
                String absolutePath = r.getAbsolutePath();

                if (isFile) {
                    fileDisplayPnl.getFileTA().append("Found a file: " + absolutePath + "\n");
                } else {
                    fileDisplayPnl.getFileTA().append("Found a directory: " + absolutePath + "\n");
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void setUpStartListener() {
        controlPnl.addStartActionListener((ActionEvent ae) ->
        {
            ArrayList<SearchResult> results = controller.launchSearch();
            boolean displayed = displaySearchResult(results);

            if (displayed) {
                controlPnl.getStartBtn().setEnabled(false);
                controlPnl.getResetBtn().setEnabled(true);
            }
        });
    }

    public void setUpResetListener()
    {
        controlPnl.addResetActionListener((ActionEvent ae) ->
        {
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
        });
    }

    public void setUpQuitListener()
    {
        controlPnl.addQuitActionListener((ActionEvent ae) -> {
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
        });
    }
}

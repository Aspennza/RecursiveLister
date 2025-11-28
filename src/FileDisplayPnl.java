import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Allows the creation of pre-designed JPanel objects with
 * a JTextArea and corresponding JLabel for displaying
 * directories and file paths found by RecursiveLister.java.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class FileDisplayPnl extends JPanel
{
    //This JLabel describes the fileTA
    JLabel fileLbl;

    //This fileTA is used to display all the directories and file paths found by RecursiveLister
    JTextArea fileTA;

    //This JScrollPane is applied to the fileTA
    JScrollPane scroller;

    //This constructor initializes the fileLbl, fileTA, and scroller and sets the layout of the panel
    public FileDisplayPnl()
    {
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        setLayout(new BorderLayout());

        fileLbl = new JLabel("File Display:");
        fileTA = new JTextArea(10, 50);
        fileTA.setEditable(false);
        scroller = new JScrollPane(fileTA);

        add(fileLbl, BorderLayout.NORTH);
        add(scroller, BorderLayout.CENTER);
    }

    /**
     * This method resets the panel to its original state
     */
    public void reset() {
        fileTA.setText("");
    }

    public JLabel getFileLbl() {
        return fileLbl;
    }

    public JTextArea getFileTA() {
        return fileTA;
    }

    public JScrollPane getScroller() {
        return scroller;
    }
}

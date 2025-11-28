import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Allows the creation of pre-designed JPanel objects with JButton controls for
 * resetting the program, launching the JFileChooser, and quitting the program.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ControlPnl extends JPanel
{
    //This JButton is used to launch the JFileChooser
    JButton startBtn;

    //This JButton is used to reset the program
    JButton resetBtn;

    //This JButton is used to quit the program
    JButton quitBtn;

    //This Font is applied to the three JButtons
    Font controlPnlFont;

    //This constructor instantiates the buttons, styles them, and gives the panel a layout
    public ControlPnl()
    {
        setLayout(new GridLayout(1, 3));
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));

        controlPnlFont = new Font("SansSerif", Font.BOLD, 14);

        startBtn = new JButton("Start");
        startBtn.setFont(controlPnlFont);
        startBtn.setBackground(new Color(61, 109, 159));
        startBtn.setForeground(new Color(255, 255, 255));
        resetBtn = new JButton("Reset");
        resetBtn.setFont(controlPnlFont);
        resetBtn.setBackground(new Color(74, 74, 74));
        resetBtn.setEnabled(false);
        resetBtn.setForeground(new Color(255, 255, 255));
        quitBtn = new JButton("Quit");
        quitBtn.setFont(controlPnlFont);
        quitBtn.setBackground(new Color(61, 109, 159));
        quitBtn.setForeground(new Color(255, 255, 255));

        add(startBtn);
        add(resetBtn);
        add(quitBtn);
    }

    /**
     * This method allows the ListViewer to change the color of the reset button when it is activated
     */
    public void styleResetBtn() {
        resetBtn.setBackground(new Color(61, 109, 159));
    }


    /**
     * This method allows the ListViewer to change the color of the start button when it is deactivated
     */
    public void styleStartBtn() {
        startBtn.setBackground(new Color(74, 74, 74));
    }

    /**
     * This method resets the panel to its original state
     */
    public void reset()
    {
        startBtn.setEnabled(true);
        resetBtn.setEnabled(false);
        resetBtn.setBackground(new Color(74, 74, 74));
        startBtn.setBackground(new Color(61, 109, 159));
    }

    /**
     * This method allows the ListViewer to establish the ActionListener for the start button
     * @param listener the ActionListener to be applied to the start button
     */
    public void addStartActionListener(ActionListener listener) {
        startBtn.addActionListener(listener);
    }

    /**
     * This method allows the ListViewer to establish the ActionListener for the reset button
     * @param listener the ActionListener to be applied to the reset button
     */
    public void addResetActionListener(ActionListener listener) {
        resetBtn.addActionListener(listener);
    }

    /**
     * This method allows the ListViewer to establish the ActionListener for the quit button
     * @param listener the ActionListener to be applied to the quit button
     */
    public void addQuitActionListener(ActionListener listener) {
        quitBtn.addActionListener(listener);
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public JButton getResetBtn() {
        return resetBtn;
    }

    public JButton getQuitBtn() {
        return quitBtn;
    }
}

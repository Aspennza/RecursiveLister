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
        styleBtn(startBtn, new Color(61, 109, 159), true);

        resetBtn = new JButton("Reset");
        styleBtn(resetBtn, new Color(74, 74, 74), false);

        quitBtn = new JButton("Quit");
        styleBtn(quitBtn, new Color(61, 109, 159), true);

        add(startBtn);
        add(resetBtn);
        add(quitBtn);
    }

    private void styleBtn(JButton btn, Color bg, boolean enabled) {
        btn.setFont(controlPnlFont);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setEnabled(enabled);
    }

    /**
     * This method allows the ListViewer to change the color of the reset button when it is activated
     */
    public void activateResetBtn() {
        resetBtn.setEnabled(true);
        resetBtn.setBackground(new Color(61, 109, 159));
    }


    /**
     * This method allows the ListViewer to change the color of the start button when it is deactivated
     */
    public void deactivateStartBtn() {
        startBtn.setEnabled(false);
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

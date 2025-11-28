import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Allows the creation of pre-designed JPanels with a JLabel
 * representing the title of the program.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class TitlePnl extends JPanel
{
    //A JLabel for the title of the program
    private JLabel titleLbl;

    //A Font for the titleLbl
    private Font titleFont;

    private static final Color BACKGROUND_COLOR = new Color(34, 39, 80);

    private static final Color TEXT_COLOR = new Color(255, 255, 255);

    //This constructor initializes the label and font and styles the panel
    public TitlePnl() {
        setBackground(BACKGROUND_COLOR);
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
        titleLbl = new JLabel("Recursive File Lister");
        titleLbl.setForeground(TEXT_COLOR);
        titleFont = new Font("Serif", Font.BOLD, 36);
        titleLbl.setFont(titleFont);
        add(titleLbl);
    }

    public JLabel getTitleLbl() {
        return titleLbl;
    }

    public Font getTitleFont() {
        return titleFont;
    }
}

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class FileDisplayPnl extends JPanel
{
    JLabel fileLbl;
    JTextArea fileTA;
    JScrollPane scroller;

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

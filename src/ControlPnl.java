import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPnl extends JPanel
{
    JButton startBtn;
    JButton resetBtn;
    JButton quitBtn;

    public ControlPnl()
    {
        setLayout(new GridLayout(1, 3));
        setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));

        startBtn = new JButton("Start");
        resetBtn = new JButton("Reset");
        resetBtn.setEnabled(false);
        quitBtn = new JButton("Quit");

        add(startBtn);
        add(resetBtn);
        add(quitBtn);
    }

    public void addStartActionListener(ActionListener listener) {
        startBtn.addActionListener(listener);
    }

    public void addResetActionListener(ActionListener listener) {
        resetBtn.addActionListener(listener);
    }

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

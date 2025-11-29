import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the ControlPnl class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class ControlPnlTest {

    //A ControlPnl object for testing the methods
    ControlPnl pnl;

    @BeforeEach
    void setUp() {
        pnl = new ControlPnl();
    }

    @Test
    void testConstructor() {
        int rows = ((GridLayout) pnl.getLayout()).getRows();
        int cols = ((GridLayout) pnl.getLayout()).getColumns();
        assertEquals(1, rows);
        assertEquals(3, cols);
        assertNotNull(pnl.getControlPnlFont());
        assertEquals("SansSerif", pnl.getControlPnlFont().getName());
        assertEquals(Font.BOLD, pnl.getControlPnlFont().getStyle());
        assertEquals(14, pnl.getControlPnlFont().getSize());
        assertNotNull(pnl.getStartBtn());
        assertNotNull(pnl.getResetBtn());
        assertNotNull(pnl.getQuitBtn());
        assertEquals("Start", pnl.getStartBtn().getText());
        assertEquals("Reset", pnl.getResetBtn().getText());
        assertEquals("Quit", pnl.getQuitBtn().getText());
        assertTrue(pnl.getStartBtn().isEnabled());
        assertFalse(pnl.getResetBtn().isEnabled());
        assertTrue(pnl.getQuitBtn().isEnabled());
        assertEquals(pnl.getControlPnlFont(), pnl.getStartBtn().getFont());
        assertEquals(pnl.getControlPnlFont(), pnl.getResetBtn().getFont());
        assertEquals(pnl.getControlPnlFont(), pnl.getQuitBtn().getFont());
    }

    @Test
    void activateResetBtn() {
        assertFalse(pnl.getResetBtn().isEnabled());
        pnl.activateResetBtn();
        assertTrue(pnl.getResetBtn().isEnabled());
    }

    @Test
    void deactivateStartBtn() {
        assertTrue(pnl.getStartBtn().isEnabled());
        pnl.deactivateStartBtn();
        assertFalse(pnl.getStartBtn().isEnabled());
    }

    @Test
    void reset() {
        pnl.getStartBtn().setEnabled(false);
        pnl.getResetBtn().setEnabled(true);
        pnl.reset();
        assertTrue(pnl.getStartBtn().isEnabled());
        assertFalse(pnl.getResetBtn().isEnabled());
    }

    @Test
    void addStartActionListener() {
        class StartListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        }

        StartListener listener = new StartListener();
        pnl.addStartActionListener(listener);
        assertNotNull(pnl.getStartBtn().getActionListeners());
    }

    @Test
    void addResetActionListener() {
        class ResetListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        }

        ResetListener listener = new ResetListener();
        pnl.addResetActionListener(listener);
        assertNotNull(pnl.getResetBtn().getActionListeners());
    }

    @Test
    void addQuitActionListener() {
        class QuitListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        }

        QuitListener listener = new QuitListener();
        pnl.addQuitActionListener(listener);
        assertNotNull(pnl.getQuitBtn().getActionListeners());
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FileDisplayPnlTest {

    FileDisplayPnl pnl;

    @BeforeEach
    void setUp() {
        pnl = new FileDisplayPnl();
    }

    @Test
    void testConstructor() {
        assertTrue(pnl.getLayout() instanceof BorderLayout);
        assertNotNull(pnl.getFileLbl());
        assertNotNull(pnl.getFileTA());
        assertNotNull(pnl.getScroller());
        assertEquals("File Display:", pnl.getFileLbl().getText());
        assertFalse(pnl.getFileTA().isEditable());
    }

    @Test
    void showResults() {
        assertEquals("", pnl.getFileTA().getText());
        pnl.showResults("Test");
        assertEquals("Test", pnl.getFileTA().getText());
    }

    @Test
    void reset() {
        assertEquals("", pnl.getFileTA().getText());
        pnl.getFileTA().setText("Test");
        pnl.reset();
        assertEquals("", pnl.getFileTA().getText());
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListViewerTest {

    ListViewer viewer;

    @BeforeEach
    void setUp() {
        viewer = new ListViewer();
    }

    @Test
    void start() {
        viewer.start();
        viewer.getFrame().setVisible(false);
        assertNotNull(viewer.getController());
        assertNotNull(viewer.getFrame());
        assertNotNull(viewer.getTitlePnl());
        assertNotNull(viewer.getControlPnl());
        assertNotNull(viewer.getFileDisplayPnl());
        assertNotNull(viewer.getControlPnl().getStartBtn().getActionListeners());
        assertNotNull(viewer.getControlPnl().getResetBtn().getActionListeners());
        assertNotNull(viewer.getControlPnl().getQuitBtn().getActionListeners());
    }

    @Test
    void generateFrame() {
        viewer.generateFrame();
        viewer.getFrame().setVisible(false);
        assertNotNull(viewer.getFrame());
        assertNotNull(viewer.getTitlePnl());
        assertNotNull(viewer.getControlPnl());
        assertNotNull(viewer.getFileDisplayPnl());
        assertEquals(JFrame.EXIT_ON_CLOSE, viewer.getFrame().getDefaultCloseOperation());
        assertEquals("Recursive File Lister", viewer.getFrame().getTitle());
    }

    @Test
    void reset() {
        viewer.start();
        viewer.getFrame().setVisible(false);
        viewer.getControlPnl().getStartBtn().setEnabled(false);
        viewer.getControlPnl().getResetBtn().setEnabled(true);
        viewer.getFileDisplayPnl().getFileTA().setText("Test");
        viewer.reset();
        assertTrue(viewer.getControlPnl().getStartBtn().isEnabled());
        assertFalse(viewer.getControlPnl().getResetBtn().isEnabled());
        assertEquals("", viewer.getFileDisplayPnl().getFileTA().getText());
    }

    @Test
    void formatSearchResult() {
        ArrayList<SearchResult> results = new ArrayList<>();
        results.add(new SearchResult(true, "Test"));
        results.add(new SearchResult(false, "Test 2"));
        String result = viewer.formatSearchResult(results);
        assertEquals("Directory contains:\nFound a file: Test\n\nFound a directory: Test 2\n\n", result);

        results = null;
        result = viewer.formatSearchResult(results);
        assertEquals("", result);
    }

    @Test
    void displaySearchResult() {
        viewer.start();
        viewer.getFrame().setVisible(false);
        ArrayList<SearchResult> results = new ArrayList<>();
        results.add(new SearchResult(true, "Test"));
        results.add(new SearchResult(false, "Test 2"));

        boolean result = viewer.displaySearchResult(results);
        assertEquals("Directory contains:\nFound a file: Test\n\nFound a directory: Test 2\n\n", viewer.getFileDisplayPnl().getFileTA().getText());
        assertTrue(result);

        results = null;
        result = viewer.displaySearchResult(results);
        assertFalse(result);
    }

    @Test
    void setUpStartListener() {
        viewer.start();
        viewer.getFrame().setVisible(false);
        viewer.setUpStartListener();
        assertNotNull(viewer.getControlPnl().getStartBtn().getActionListeners());
    }

    @Test
    void setUpResetListener() {
        viewer.start();
        viewer.getFrame().setVisible(false);
        viewer.setUpResetListener();
        assertNotNull(viewer.getControlPnl().getResetBtn().getActionListeners());
    }

    @Test
    void setUpQuitListener() {
        viewer.start();
        viewer.getFrame().setVisible(false);
        viewer.setUpQuitListener();
        assertNotNull(viewer.getControlPnl().getQuitBtn().getActionListeners());
    }
}
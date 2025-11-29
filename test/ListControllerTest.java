import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the ListController class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class ListControllerTest {

    //A ListController object for testing the methods
    ListController controller;

    @BeforeEach
    void setUp() {
        controller = new ListController();
    }

    @Test
    void testConstructor() {
        assertNotNull(controller.getLauncher());
        assertNotNull(controller.getLister());
    }
}
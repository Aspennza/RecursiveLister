import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ListControllerTest {

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
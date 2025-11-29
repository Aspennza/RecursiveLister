import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the SearchResult class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class SearchResultTest {

    //A SearchResult object for testing the methods
    SearchResult result1;

    //A SearchResult object for testing the methods
    SearchResult result2;

    //A SearchResult object for testing the methods
    SearchResult result3;

    //A SearchResult object for testing the methods
    SearchResult result4;

    @BeforeEach
    void setUp() {
        result1 = new SearchResult(true, "Test");
        result2 = new SearchResult(false, "Test2");
        result3 = new SearchResult(true, "Test3");
        result4 = new SearchResult(true, "Test");
    }

    @Test
    void testConstructor() {
        assertEquals(true, result1.isFile());
        assertEquals("Test", result1.getAbsolutePath());
    }

    @Test
    void display() {
        String output = result1.display();
        assertEquals("Found a file: Test", output);
        output = result2.display();
        assertEquals("Found a directory: Test2", output);
    }

    @Test
    void testToString() {
        String output = result1.toString();
        assertEquals("SearchResult{isFile=true, absolutePath='Test'}", output);
    }

    @Test
    void testEquals() {
        assertFalse(result1.equals(result2));
        assertFalse(result1.equals(result3));
        assertTrue(result1.equals(result4));
    }

    @Test
    void testHashCode() {
        assertEquals(2642308, result1.hashCode());
    }
}
import java.util.Objects;

/**
 * This class allows the creation of SearchResult objects containing
 * an item's status as a file or a directory and the absolute path to it.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class SearchResult
{
    //This boolean stores the object's status as a file or directory
    private final boolean IS_FILE;

    //This String stores the absolute path to the file/directory
    private final String ABSOLUTE_PATH;

    public SearchResult(boolean IS_FILE, String ABSOLUTE_PATH) {
        this.IS_FILE = IS_FILE;
        this.ABSOLUTE_PATH = ABSOLUTE_PATH;
    }

    /**
     * This method determines whether the SearchResult contains
     * a file or a directory and determines how to display it as String text.
     * @return a String containing pre-formatted text based on whether the SearchResult is a file or directory
     */
    public String display()
    {
        //This algorithm determines whether the SearchResult is a file or a directory
        if (IS_FILE) {
            return "Found a file: " + ABSOLUTE_PATH;
        } else {
            return "Found a directory: " + ABSOLUTE_PATH;
        }
    }

    public String getABSOLUTE_PATH() {
        return ABSOLUTE_PATH;
    }

    public boolean isFile() {
        return IS_FILE;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "IS_FILE=" + IS_FILE +
                ", ABSOLUTE_PATH='" + ABSOLUTE_PATH + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return IS_FILE == that.IS_FILE && Objects.equals(ABSOLUTE_PATH, that.ABSOLUTE_PATH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IS_FILE, ABSOLUTE_PATH);
    }


}

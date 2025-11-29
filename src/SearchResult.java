import java.util.Objects;

/**
 * This class allows the creation of SearchResult objects containing
 * an item's status as a file or a directory and the absolute path to it.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class SearchResult
{
    //This boolean stores the object's status as a file or directory
    private final boolean isFile;

    //This String stores the absolute path to the file/directory
    private final String absolutePath;

    public SearchResult(boolean isFile, String absolutePath) {
        this.isFile = isFile;
        this.absolutePath = absolutePath;
    }

    /**
     * This method determines whether the SearchResult contains
     * a file or a directory and determines how to display it as String text.
     * @return a String containing pre-formatted text based on whether the SearchResult is a file or directory
     */
    public String display()
    {
        //This algorithm determines whether the SearchResult is a file or a directory
        if (isFile) {
            return "Found a file: " + absolutePath;
        } else {
            return "Found a directory: " + absolutePath;
        }
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public boolean isFile() {
        return isFile;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "isFile=" + isFile +
                ", absolutePath='" + absolutePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return isFile == that.isFile && Objects.equals(absolutePath, that.absolutePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFile, absolutePath);
    }


}

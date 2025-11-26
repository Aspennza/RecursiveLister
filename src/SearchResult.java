import java.util.Objects;

public class SearchResult
{
    private final boolean isFile;
    private final String directory;

    public SearchResult(boolean isFile, String directory) {
        this.isFile = isFile;
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public boolean isFile() {
        return isFile;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "isFile=" + isFile +
                ", directory='" + directory + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return isFile == that.isFile && Objects.equals(directory, that.directory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFile, directory);
    }
}

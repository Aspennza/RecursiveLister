import java.util.Objects;

public class SearchResult
{
    private final boolean isFile;
    private final String absolutePath;

    public SearchResult(boolean isFile, String absolutePath) {
        this.isFile = isFile;
        this.absolutePath = absolutePath;
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

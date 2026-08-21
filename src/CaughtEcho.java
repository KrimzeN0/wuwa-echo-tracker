import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class CaughtEcho implements Comparable<CaughtEcho>, Serializable {
    private String name;
    private LocalDateTime catchTime;

    public CaughtEcho(String name, LocalDateTime catchTime) {
        if (name == null || catchTime == null) {
            throw new IllegalArgumentException("Name and catch time cannot be null");
        }
        this.name = name;
        this.catchTime = catchTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCatchTime() {
        return catchTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CaughtEcho that = (CaughtEcho) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(CaughtEcho o) {
        return this.name.compareTo(o.getName());
    }
}

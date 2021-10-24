import java.util.Objects;

public class HashTest {
    private String field1;
    private short field2;

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2);
    }
}

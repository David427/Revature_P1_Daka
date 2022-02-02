import com.revature.annotations.Column;
import com.revature.annotations.Entity;
import com.revature.annotations.Table;
import com.revature.models.Unit;
import org.junit.jupiter.api.Test;

@Entity
@Table(name = "test_1")
public class DriverTest extends Unit {
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "available")
    private boolean available;

    @Test
    public static void main(String[] args) {
        Class<DriverTest> rt = DriverTest.class;
        Table table = rt.getAnnotation(Table.class);

        System.out.println(table.name());

    }
}

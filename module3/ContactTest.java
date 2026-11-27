import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact ada;
    private Contact grace;
    private Contact alan;

    @BeforeEach
    void setUp() {
        ada = new Contact("Ada Lovelace", "+1 617 555 0101");
        grace = new Contact("Grace Hopper", "555-0000");
        alan = new Contact("Alan Turing", "555-0001");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", ada.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", ada.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        assertEquals("Grace Hopper", grace.getName());
    }

    @Test
    void toString_containsName() {
        assertTrue(alan.toString().contains("Alan Turing"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(alan.toString().contains("555-0001"));
    }
}

package nullcheck;

import model.Address;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicNullCheckerTest {

    public static final String EMPTY = "";
    private User user;

    @BeforeEach
    void setup() {
        user = new User();
    }

    @Test
    void testNullCheckReturnDefaultValue() {
        String label = EMPTY;
        if (user != null && user.getAddress() != null) {
            label = user.getAddress().getLabel();
        }
        assertThat(label).isEmpty();
    }

    @Test
    void testNullCheck() {
        String label = EMPTY;
        user.setAddress(new Address());
        user.getAddress().setLabel("Default address");
        if (user != null && user.getAddress() != null) {
            label = user.getAddress().getLabel();
        }
        assertThat(label).isEqualTo("Default address");
    }

}

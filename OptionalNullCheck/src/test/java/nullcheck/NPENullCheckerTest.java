package nullcheck;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.NullChecker;

import static org.assertj.core.api.Assertions.assertThat;

public class NPENullCheckerTest {

    public static final String EMPTY = "";
    private User user;

    @BeforeEach
    void setup() {
        user = new User();
    }

    @Test
    void testNullCheck() {

        String actual = NullChecker.get(() -> user.getAddress().getLabel(), EMPTY);
        assertThat(actual).isEmpty();
    }

}

package nullcheck;

import model.Address;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalNullCheckerTest {

    public static final String EMPTY = "";
    private User user;

    @BeforeEach
    void setup() {
        user = new User();
    }

    @Test
    void testNullCheckWithEmptyUser() {
        // GIVEN

        // WHEN
        String actual = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getLabel)
                .orElse(EMPTY);

        // THEN
        assertThat(actual).isEmpty();
    }

    @Test
    void testNullCheckWithEmptyAddress() {
        // GIVEN
        user.setAddress(new Address());

        // WHEN
        String actual = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getLabel)
                .orElse(EMPTY);

        // THEN
        assertThat(actual).isEmpty();
    }

    @Test
    void testNullCheckWithFullyUser() {
        // GIVEN
        user.setAddress(new Address());
        user.getAddress().setLabel("Optional are awesome");

        // WHEN
        String actual = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getLabel)
                .orElse(EMPTY);

        // THEN
        assertThat(actual).isEqualTo("Optional are awesome");
    }
}

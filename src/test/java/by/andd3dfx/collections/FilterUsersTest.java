package by.andd3dfx.collections;

import by.andd3dfx.collections.FilterUsers.User;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterUsersTest {

    @Test
    public void apply() {
        List<User> users = List.of(
            new User("Anton", LocalDate.now().minusDays(5)),    // not max chars amount, too old
            new User("Gena", LocalDate.now().minusDays(3)),     // not max chars amount
            new User("John", LocalDate.now().minusDays(2)),     // not max chars amount
            new User("Anatoliy", LocalDate.now().minusDays(1)), // expected (max chars amount)
            new User("Vladimir", LocalDate.now().minusDays(1)), // expected (max chars amount)
            new User("Kirillus", LocalDate.now().minusDays(4)), // too old
            new User("Anatoliy", LocalDate.now().minusDays(3))  // duplicate
        );

        var result = FilterUsers.apply(users);

        assertThat(result).containsOnly("Vladimir", "Anatoliy");
    }

    @Test
    public void applyForEmpty() {
        List<User> users = List.of();

        var result = FilterUsers.apply(users);

        assertThat(result).isEmpty();
    }
}

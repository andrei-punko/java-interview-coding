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
            new User("Anton", LocalDate.now().minusDays(5)),
            new User("Gena", LocalDate.now().minusDays(3)),
            new User("John", LocalDate.now().minusDays(2)),
            new User("Vladimir", LocalDate.now().minusDays(1)),
            new User("Anatoliy", LocalDate.now().minusDays(3))
        );

        var result = FilterUsers.apply(users);

        assertThat(result).isEqualTo(List.of("Vladimir", "Anatoliy"));
    }

    @Test
    public void applyForEmpty() {
        List<User> users = List.of();

        var result = FilterUsers.apply(users);

        assertThat(result).isEmpty();
    }
}

package by.andd3dfx.numeric;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.numeric.AddTwoNumbers.ListNode;
import org.junit.Test;

public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbers() {
        assertThat(AddTwoNumbers.addTwoNumbers(
            new ListNode(2,
                new ListNode(4,
                    new ListNode(3))),
            new ListNode(5,
                new ListNode(6,
                    new ListNode(4)))
        )).isEqualTo(
            new ListNode(7,
                new ListNode(0,
                    new ListNode(8))));

        assertThat(AddTwoNumbers.addTwoNumbers(
            new ListNode(0),
            new ListNode(0)
        )).isEqualTo(
            new ListNode(0));

        assertThat(AddTwoNumbers.addTwoNumbers(
            new ListNode(9,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9,
                            new ListNode(9,
                                new ListNode(9,
                                    new ListNode(9))))))),
            new ListNode(9,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9))))
        )).isEqualTo(
            new ListNode(8,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9,
                            new ListNode(0,
                                new ListNode(0,
                                    new ListNode(0,
                                        new ListNode(1)))))))));
    }
}

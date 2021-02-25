package by.andd3dfx.interview.goldmansachs;

import java.util.List;

public class Person {

    private String name;
    private Card card;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

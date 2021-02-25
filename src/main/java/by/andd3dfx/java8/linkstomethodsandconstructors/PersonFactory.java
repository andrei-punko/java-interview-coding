package by.andd3dfx.java8.linkstomethodsandconstructors;

public interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);
}

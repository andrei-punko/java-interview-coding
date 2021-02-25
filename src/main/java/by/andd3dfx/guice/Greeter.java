package by.andd3dfx.guice;

import by.andd3dfx.guice.util.Communicator;
import by.andd3dfx.guice.util.Spawner;
import javax.inject.Inject;

public class Greeter {

    private final String message;
    private final int count;
    private Communicator communicator;

    // Field injection example
    @Inject
    private Spawner spawner;

    // Constructor injection example
    // Greeter declares that it needs a string message and an integer representing the number of time the message to be printed.
    // The @Inject annotation marks this constructor as eligible to be used by Guice
    @Inject
    public Greeter(@Message String message, @Count int count) {
        this.message = message;
        this.count = count;
    }

    // Method injection example
    @Inject
    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    public void sayHello() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    public void communicate() {
        communicator.communicate();
    }

    public void spawn() {
        spawner.spawn();
    }
}

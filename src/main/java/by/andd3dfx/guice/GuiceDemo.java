package by.andd3dfx.guice;

import by.andd3dfx.guice.util.Communicator;
import by.andd3dfx.guice.util.Spawner;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * According to Guice "Getting Started" page: https://github.com/google/guice/wiki/GettingStarted
 * <p>
 * and Baeldung Guice manual: https://www.baeldung.com/guice
 */
public class GuiceDemo {

    public static void main(String[] args) {
        /*
         * Guice.createInjector() takes one or more modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        Injector injector = Guice.createInjector(new DemoModule());

        /*
         * Now that we've got the injector, we can build objects.
         */
        Greeter greeter = injector.getInstance(Greeter.class);

        // Prints "hello world" 3 times to the console.
        greeter.sayHello();
        greeter.communicate();
        greeter.spawn();

        // Make communication
        Communicator communicator = injector.getInstance(Communicator.class);
        communicator.communicate();

        // Make some spawning
        Spawner spawner = injector.getInstance(Spawner.class);
        spawner.spawn();
    }
}

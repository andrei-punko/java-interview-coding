package by.andd3dfx.guice;

import by.andd3dfx.guice.util.Communicator;
import by.andd3dfx.guice.util.DefaultCommunicatorImpl;
import by.andd3dfx.guice.util.Spawner;
import by.andd3dfx.guice.util.SpawnerImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * Guice module that provides bindings for message and count used in {@link Greeter}.
 */
public class DemoModule extends AbstractModule {

    @Provides
    @Count
    static Integer provideCount() {
        return 3;
    }

    @Provides
    @Message
    static String provideMessage() {
        return "hello world";
    }

    @Override
    protected void configure() {
        bind(Communicator.class).to(DefaultCommunicatorImpl.class);
        bind(Spawner.class).to(SpawnerImpl.class);
    }
}

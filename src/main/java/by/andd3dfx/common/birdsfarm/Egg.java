package by.andd3dfx.common.birdsfarm;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class Egg {

    private final Callable<IBird> createBird;
    private boolean isHatched = false;

    public synchronized IBird hatch() throws Exception {
        if (isHatched) {
            throw new IllegalStateException("This egg already hatched!");
        }
        isHatched = true;
        return createBird.call();
    }
}

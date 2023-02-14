package by.andd3dfx.common.birdsfarm;

public class Goose implements IBird {

    @Override
    public Egg lay() {
        return new Egg(() -> new Goose());
    }
}

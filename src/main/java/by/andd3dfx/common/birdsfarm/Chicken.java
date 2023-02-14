package by.andd3dfx.common.birdsfarm;

public class Chicken implements IBird {

    @Override
    public Egg lay() {
        return new Egg(() -> new Chicken());
    }
}

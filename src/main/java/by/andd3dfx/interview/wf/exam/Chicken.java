package by.andd3dfx.interview.wf.exam;

import java.util.concurrent.Callable;

interface IBird {

  Egg lay();
}

public class Chicken implements IBird {

  @Override
  public Egg lay() {
    return new Egg(() -> new Chicken());
  }

  public static void main(String[] args) throws Exception {
    Chicken chicken = new Chicken();
    Egg egg = chicken.lay();
    IBird hatchedBird = egg.hatch();

    System.out.println(chicken instanceof IBird);
    System.out.println(hatchedBird instanceof Chicken);
  }
}

class Goose implements IBird {

  @Override
  public Egg lay() {
    return new Egg(() -> new Goose());
  }
}

class Egg {

  private final Callable<IBird> createBird;
  private boolean isHatched = false;

  public Egg(Callable<IBird> createBird) {
    this.createBird = createBird;
  }

  public IBird hatch() throws Exception {
    if (isHatched) {
      throw new IllegalStateException("This egg already hatched!");
    }
    isHatched = true;
    return createBird.call();
  }
}

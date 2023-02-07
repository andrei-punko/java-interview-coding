package by.andd3dfx.common;

import java.util.concurrent.Callable;

/**
 * <pre>
 * Add the missing code to Chicken and Egg so the following actions are completed:
 * - Chicken implements the IBird base class.
 * - A Chicken lays an egg that will hatch into a new Chicken.
 * - Eggs from other types of birds should hatch into a new bird of their parent type.
 * - Hatching an egg for the second time throws an IllegalStateException.
 *
 * interface IBird {
 *   Egg lay();
 * }
 *
 * class Chicken {
 *   public Chicken() {
 *   }
 *
 *   public static void main(String[] args) throws Exception {
 *     Chicken chicken = new Chicken();
 *     System.out.println(chicken instanceof IBird);
 *   }
 * }
 *
 * class Egg {
 *   public Egg(Callable<IBird> createBird) {
 *     throw new UnsupportedOperationException("Waiting to be implemented.);
 *   }
 *   public IBird hatch() throws Exception {
 *     throw new UnsupportedOperationException("Waiting to be implemented.);
 *   }
 * }
 *
 * Tests:
 * - Chicken is an IBird
 * - Chickens make other chickens
 * - Other birds don't make chickens
 * - Eggs can't hatch twice
 *</pre>
 */
interface IBird {

  Egg lay();
}

public class Chicken implements IBird {

  @Override
  public Egg lay() {
    return new Egg(() -> new Chicken());
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


We have initial code (see below). Implement required TODOs

Use next tests to check validity:
- [FurnitureOrderFirstTest](../../../../../test/java/by/andd3dfx/furniture/FurnitureOrderFirstTest.java)
- [FurnitureOrderSecondTest](../../../../../test/java/by/andd3dfx/furniture/FurnitureOrderSecondTest.java)

```java
public enum Furniture {
    CHAIR("Chair", 100.0f),
    TABLE("Table", 250.0f),
    COUCH("Couch", 500.0f);

    private final String label;
    private final float cost;

    Furniture(String label, float cost) {
        this.label = label;
        this.cost = cost;
    }

    public String label() {
        return null;
    }

    public float cost() {
        return -1.0f;
    }
}

public interface FurnitureOrderInterface {
    void addToOrder(final Furniture type, final int count);

    HashMap<Furniture, Integer> getOrderedFurniture();

    int getTypeCount(Furniture type);

    float getTypeCost(Furniture type);

    float getTotalOrderCost();

    int getTotalOrderQuantity();
}

public class FurnitureOrder implements FurnitureOrderInterface {

    // TODO: Create a map of Furniture items to order quantities

    public FurnitureOrder() {
        // TODO: Complete the constructor
    }

    @Override
    public void addToOrder(Furniture type, int count) {
        // TODO: Complete the method
    }

    @Override
    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return null;
    }

    @Override
    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        return -1;
    }

    @Override
    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        return -1.0f;
    }

    @Override
    public float getTotalOrderCost() {
        // TODO: Complete the method
        return -1.0f;
    }

    @Override
    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        return -1;
    }
}
```

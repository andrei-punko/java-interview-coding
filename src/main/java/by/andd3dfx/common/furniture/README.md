We have initial code (see below). Implement required TODOs

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

Use next tests to check validity:

- [FurnitureOrderFirstTest](../../../../../../test/java/by/andd3dfx/common/furniture/FurnitureOrderFirstTest.java)
- [FurnitureOrderSecondTest](../../../../../../test/java/by/andd3dfx/common/furniture/FurnitureOrderSecondTest.java)

```java

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FurnitureOrderFirstTest {

    private static FurnitureOrder furnitureFactory;

    @BeforeClass
    public static void initiate() {
        furnitureFactory = new FurnitureOrder();
    }

    @Test
    public void _01_getChairCount() {
        assertEquals(0, furnitureFactory.getTypeCount(Furniture.CHAIR));
    }

    @Test
    public void _02_getFourChairs() {
        furnitureFactory.addToOrder(Furniture.CHAIR, 4);
        assertEquals(4, furnitureFactory.getTypeCount(Furniture.CHAIR));
    }

    @Test
    public void _03_getThreeCouches() {
        furnitureFactory.addToOrder(Furniture.COUCH, 3);
        assertEquals(3, furnitureFactory.getTypeCount(Furniture.COUCH));
    }

    @Test
    public void _04_orderedChairsCost() {
        assertEquals(400.0f, furnitureFactory.getTypeCost(Furniture.CHAIR));
    }

    @Test
    public void _05_orderedTablesCost() {
        assertEquals(0.0f, furnitureFactory.getTypeCost(Furniture.TABLE));
    }

    @Test
    public void _06_orderedCouchesCost() {
        assertEquals(1500.0f, furnitureFactory.getTypeCost(Furniture.COUCH));
    }

    @Test
    public void _07_totalOrderCost() {
        furnitureFactory.addToOrder(Furniture.TABLE, 6);
        assertEquals(3400.0f, furnitureFactory.getTotalOrderCost());
    }
}

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FurnitureOrderSecondTest {

    private static FurnitureOrder furnitureFactory;

    @BeforeClass
    public static void initiate() {
        furnitureFactory = new FurnitureOrder();
    }

    @Test
    public void _08_orderNothing() {
        furnitureFactory.addToOrder(Furniture.TABLE, 0);
        furnitureFactory.addToOrder(Furniture.CHAIR, 0);
        furnitureFactory.addToOrder(Furniture.COUCH, 0);

        assertEquals(0.0f, furnitureFactory.getTotalOrderCost());
    }

    @Test
    public void _09_placeOrders() {
        furnitureFactory.addToOrder(Furniture.TABLE, 6);
        furnitureFactory.addToOrder(Furniture.CHAIR, 10);
        furnitureFactory.addToOrder(Furniture.COUCH, 5);

        assertEquals(5000.0f, furnitureFactory.getTotalOrderCost());
    }

    @Test
    public void _10_validateFurnitureCostAndQuantity() {
        HashMap<Furniture, Integer> orderedFurniture = furnitureFactory.getOrderedFurniture();

        assertEquals(21, orderedFurniture.values().stream().mapToInt(Integer::intValue).sum());

        orderedFurniture.keySet().forEach(furniture -> {
            if ("Chair".equals(furniture.label())) {
                assertEquals(100.0f, furniture.cost());
            }

            if ("Table".equals(furniture.label())) {
                assertEquals(250.0f, furniture.cost());
            }

            if ("Couch".equals(furniture.label())) {
                assertEquals(500.0f, furniture.cost());
            }
        });

        assertEquals(10, furnitureFactory.getTypeCount(Furniture.CHAIR));
        assertEquals(1000.0f, furnitureFactory.getTypeCost(Furniture.CHAIR));

        assertEquals(6, furnitureFactory.getTypeCount(Furniture.TABLE));
        assertEquals(1500.0f, furnitureFactory.getTypeCost(Furniture.TABLE));

        assertEquals(5, furnitureFactory.getTypeCount(Furniture.COUCH));
        assertEquals(2500.0f, furnitureFactory.getTypeCost(Furniture.COUCH));

        // Validates order size
        assertEquals(21, furnitureFactory.getTotalOrderQuantity());
    }

    @Test
    public void _11_validateFurniture() {
        for (Furniture f : Furniture.values()) {
            switch (f.label()) {
                case ("Chair"):
                    assertEquals(100.0f, f.cost());
                    break;

                case ("Table"):
                    assertEquals(250.0f, f.cost());
                    break;

                case ("Coach"):
                    assertEquals(500.0f, f.cost());
                    break;
            }
        }
    }
}
```

Check [video solution](https://youtu.be/TNgR6JaxwFg) on YouTube

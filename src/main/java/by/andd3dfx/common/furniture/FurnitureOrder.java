package by.andd3dfx.common.furniture;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {

    private final Map<Furniture, Integer> map;

    public FurnitureOrder() {
        map = new HashMap<>();
        for (var value : Furniture.values()) {
            map.put(value, 0);
        }
    }

    @Override
    public void addToOrder(Furniture type, int count) {
        map.put(type, map.get(type) + count);
    }

    @Override
    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return new HashMap<>(map);
    }

    @Override
    public int getTypeCount(Furniture type) {
        return map.get(type);
    }

    @Override
    public float getTypeCost(Furniture type) {
        return map.get(type) * type.cost();
    }

    @Override
    public float getTotalOrderCost() {
        return map.keySet().stream()
                .map(this::getTypeCost)
                .reduce((a, b) -> a + b)
                .get();
    }

    @Override
    public int getTotalOrderQuantity() {
        return map.values().stream()
                .reduce((a, b) -> a + b)
                .get();
    }
}

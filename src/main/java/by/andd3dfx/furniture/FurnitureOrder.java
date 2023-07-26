package by.andd3dfx.furniture;

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
        var result = 0.0f;
        for (var value : map.keySet()) {
            result += getTypeCost(value);
        }
        return result;
    }

    @Override
    public int getTotalOrderQuantity() {
        var result = 0;
        for (var value : map.keySet()) {
            result += map.get(value);
        }
        return result;
    }
}

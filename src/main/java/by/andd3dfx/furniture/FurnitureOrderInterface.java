package by.andd3dfx.furniture;

import java.util.HashMap;

public interface FurnitureOrderInterface {

    void addToOrder(final Furniture type, final int count);

    HashMap<Furniture, Integer> getOrderedFurniture();

    int getTypeCount(Furniture type);

    float getTypeCost(Furniture type);

    float getTotalOrderCost();

    int getTotalOrderQuantity();
}

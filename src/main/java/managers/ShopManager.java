package managers;

import interfaces.ISellable;

import java.util.LinkedList;
import java.util.List;

public class ShopManager {

    private List<ISellable> items = new LinkedList<ISellable>();
    private List<ISellable> cart = new LinkedList<ISellable>();

    public void addItem(ISellable item) {
        items.add(item);
    }

    public List<ISellable> getItems() {
        return items;
    }

    public List<ISellable> getCart() {
        return cart;
    }

    public void addItemToCart(ISellable item) {
        cart.add(item);
    }

    public void removeItemFromCart(ISellable item) {
        cart.remove(item);
    }

}

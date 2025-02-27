package hu.dizs;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Item {
    private String name;
    private double price;
    private String category;

    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(price, item.price) == 0 && Objects.equals(name, item.name) && Objects.equals(category, item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("price", price)
                .add("category", category)
                .toString();
    }
}

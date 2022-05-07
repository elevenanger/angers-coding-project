package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.Suppliers;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/6 12:22
 */
public class Store extends ArrayList<Aisle>{
    private ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();
    private Office office = new Office();
    public Store(int nAisles ,int nShelves,int nProducts){
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Aisle a: this)
            for (Shelf s : a)
                for(Product p:s) {
                    builder.append(p);
                    builder.append("\n");
                }
        return "Store{ " + builder.toString() + "} ";
    }

    public static void main(String[] args) {
        System.out.println(new Store(5,6,7));
    }
}
class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
    public void priceChange(double change){
        price += change;
    }
    public static Supplier<Product> generator = new Supplier<Product>() {
        private Random random = new Random(93);
        @Override
        public Product get() {
            return new Product(random.nextInt(1000),
                    "Shouting",
                    Math.round(random.nextDouble()*1000+0.99));
        }
    };
}

class Shelf extends ArrayList<Product>{
    Shelf(int nProducts){
        Suppliers.fill(this,Product.generator,nProducts);
    }
}

class Aisle extends ArrayList<Shelf>{
    Aisle(int nShelves,int nProducts){
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand {}
class Office {}
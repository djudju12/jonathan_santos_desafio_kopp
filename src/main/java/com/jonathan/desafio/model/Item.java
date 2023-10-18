package com.jonathan.desafio.model;

import java.util.Objects;

public class Item {
    private final Long id;
    private Double price;

    public Item(final Long id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Item(Double price) {
        this.id = 0L;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
}

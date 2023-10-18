package com.jonathan.desafio.model;

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
        return id + " cujo valor é R$ " + price;
    }
}

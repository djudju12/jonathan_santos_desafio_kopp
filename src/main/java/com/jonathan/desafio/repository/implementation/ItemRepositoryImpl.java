package com.jonathan.desafio.repository.implementation;

import com.jonathan.desafio.model.Item;
import com.jonathan.desafio.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {

    private final List<Item> itemsDatabase;
    private Long nextId = 1L;

    public ItemRepositoryImpl() {
        this.itemsDatabase = new ArrayList<>();
    }

    @Override
    public Item save(Item item) {
        if (item.getPrice() == null) {
            item.setPrice(0.0);
        }

        Item newItem = new Item(nextId, item.getPrice());
        itemsDatabase.add(newItem);
        nextId++;

        return newItem;
    }

    @Override
    public List<Item> findAll() {
        return itemsDatabase;
    }
}

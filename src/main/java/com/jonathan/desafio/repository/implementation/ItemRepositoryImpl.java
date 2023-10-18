package com.jonathan.desafio.repository.implementation;

import com.jonathan.desafio.model.Item;
import com.jonathan.desafio.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemRepositoryImpl implements ItemRepository {

    private final List<Item> itemsDatabase;
    private Long nextId = 1L;

    public ItemRepositoryImpl(List<Item> itemsDatabase) {
        this.itemsDatabase = itemsDatabase;
    }

    public ItemRepositoryImpl() {
        this.itemsDatabase = new ArrayList<>();
    }

    @Override
    public Item save(Item item) {
        Item newItem = new Item(nextId, item.getPrice());
        itemsDatabase.add(newItem);
        nextId++;

        return newItem;
    }

    @Override
    public void removeById(Long id) {
        for (Item item : itemsDatabase) {
            if (Objects.equals(item.getId(), id)) {
                itemsDatabase.remove(item);
                return;
            }
        }
    }

    @Override
    public Boolean existsById(Long id) {
        for (Item item : itemsDatabase) {
            if (Objects.equals(item.getId(), id)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Item> findAll() {
        return itemsDatabase;
    }
}

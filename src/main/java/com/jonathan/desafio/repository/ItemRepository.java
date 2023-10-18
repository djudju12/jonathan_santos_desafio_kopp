package com.jonathan.desafio.repository;

import com.jonathan.desafio.model.Item;

import java.util.List;

public interface ItemRepository {
    Item save(Item item);
    void removeById(Long id);
    Boolean existsById(Long id);
    List<Item> findAll();
}

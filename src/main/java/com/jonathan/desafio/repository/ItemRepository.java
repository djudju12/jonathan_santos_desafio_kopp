package com.jonathan.desafio.repository;

import com.jonathan.desafio.model.Item;

import java.util.List;

public interface ItemRepository {
    Item save(Item item);
    List<Item> findAll();
}

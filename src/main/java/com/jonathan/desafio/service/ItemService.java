package com.jonathan.desafio.service;

import com.jonathan.desafio.model.Item;

import java.util.List;

public interface ItemService {
    Item save(Item item);
    List<Item> saveAll(List<Item> items);
    String makeReport();
}

package com.jonathan.desafio.service;

import com.jonathan.desafio.model.Item;

public interface ItemService {
    Item save(Item item);
    void removeById(Long id);
    String makeReport();
}

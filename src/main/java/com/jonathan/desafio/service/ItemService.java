package com.jonathan.desafio.service;

import com.jonathan.desafio.model.Item;

import java.util.List;

public interface ItemService {
    Item save(Item item);
    void dumpItems(List<Double> prices);
    String makeReport();
}

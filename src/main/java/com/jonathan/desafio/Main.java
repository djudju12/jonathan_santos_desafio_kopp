package com.jonathan.desafio;

import com.jonathan.desafio.model.Item;
import com.jonathan.desafio.repository.ItemRepository;
import com.jonathan.desafio.repository.implementation.ItemRepositoryImpl;
import com.jonathan.desafio.service.ItemService;
import com.jonathan.desafio.service.implementation.ItemServiceImpl;

public class Main {
    public static void main(String[] args) {
        ItemRepository itemRepository = new ItemRepositoryImpl();
        ItemService itemService = new ItemServiceImpl(itemRepository);

        itemService.save(new Item( 88.0));
        itemService.save(new Item( 130.0));
        itemService.save(new Item( 54.9));
        itemService.save(new Item( 293.3));
        itemService.save(new Item( 44.8));

        System.out.println(itemService.makeReport());
    }
}
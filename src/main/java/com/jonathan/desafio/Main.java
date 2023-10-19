package com.jonathan.desafio;

import com.jonathan.desafio.model.Item;
import com.jonathan.desafio.repository.ItemRepository;
import com.jonathan.desafio.repository.implementation.ItemRepositoryImpl;
import com.jonathan.desafio.service.ItemService;
import com.jonathan.desafio.service.implementation.ItemServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Dependency injection
        ItemRepository itemRepository = new ItemRepositoryImpl();
        ItemService itemService = new ItemServiceImpl(itemRepository);

        // Testing with a list
        List<Double> prices = List.of(10.0, 88.0, 130.0, 54.9, 293.3, 44.8);
        List<Item> items = itemsFromList(prices);
        itemService.saveAll(items);
        System.out.println(itemService.makeReport());

        // Clearing the database
        itemService.clear();

        // Testing one by one
        itemService.save(new Item(10.0));
        itemService.save(new Item(88.0));
        itemService.save(new Item(130.0));
        itemService.save(new Item(54.9));
        itemService.save(new Item(293.3));
        itemService.save(new Item(44.8));
        System.out.println(itemService.makeReport());
    }

    private static List<Item> itemsFromList(List<Double> prices) {
        List<Item> items = new ArrayList<>();
        prices.forEach(price -> items.add(new Item(price)));
        return items;
    }
 }
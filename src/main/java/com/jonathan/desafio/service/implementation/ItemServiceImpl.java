package com.jonathan.desafio.service.implementation;

import com.jonathan.desafio.model.Item;
import com.jonathan.desafio.repository.ItemRepository;
import com.jonathan.desafio.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public String makeReport() {
        List<Item> items = itemRepository.findAll();
        if (items.isEmpty()) {
            return "Nenhum item cadastrado";
        }

        Double total = 0.0;
        StringBuilder report = new StringBuilder();
        report.append("Remessa gerada: ");

        for (Item item : items) {
            report.append(item).append(", ");
            total += item.getPrice();
        }

        // Remove the last "," from the report
        report.delete(report.length()-2, report.length());
        report.append(". Total = ").append(total).append(".");

        return report.toString();
    }

}

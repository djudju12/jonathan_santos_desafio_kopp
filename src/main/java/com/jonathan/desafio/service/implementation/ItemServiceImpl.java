package com.jonathan.desafio.service.implementation;

import com.jonathan.desafio.model.Item;
import com.jonathan.desafio.repository.ItemRepository;
import com.jonathan.desafio.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> saveAll(List<Item> items) {
        return items.stream()
                    .map(itemRepository::save)
                    .toList();
    }

    @Override
    public String makeReport() {
        List<Item> items = itemRepository.findAll();
        if (items.isEmpty()) {
            return "Nenhum item cadastrado";
        }

        StringBuilder report = new StringBuilder();
        report.append("Remessa gerada: ");

        Double total = 0.0;
        for (Item item : items) {
            report.append(item.getId())
                    .append(" cujo valor é R$ ")
                    .append(String.format("%.2f", item.getPrice()))
                    .append(", ");

            total += item.getPrice();
        }

        // Remove the last "," from the report
        report.delete(report.length() - 2, report.length());

        report.append(". Total = R$ ")
                .append(String.format("%.2f.", total));

        return report.toString();
    }
}

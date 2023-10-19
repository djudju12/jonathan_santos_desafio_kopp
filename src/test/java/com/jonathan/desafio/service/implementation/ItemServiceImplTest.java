package com.jonathan.desafio.service.implementation;

import com.jonathan.desafio.model.Item;
import com.jonathan.desafio.repository.implementation.ItemRepositoryImpl;
import com.jonathan.desafio.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceImplTest {

    private ItemService itemService;

    @BeforeEach
    void setUp() {
        itemService = new ItemServiceImpl(new ItemRepositoryImpl());
    }

    @Test
    void save() {
        // given
        Item item = new Item(10.0);

        // when
        Item savedItem = itemService.save(item);

        // then
        System.out.println(savedItem);
        assertNotNull(savedItem);
    }

    @Test
    void makeReport_WithItems() {
        // given
        Item item1 = new Item(88.00);
        Item item2 = new Item(130.00);

        // when
        itemService.save(item1);
        itemService.save(item2);

        // then
        String report = itemService.makeReport();
        assertNotNull(report);
        assertTrue(report.contains("Remessa gerada: "));
        assertTrue(report.contains("1 cujo valor é R$ 88,00"));
        assertTrue(report.contains("2 cujo valor é R$ 130,00"));
        assertTrue(report.contains("Total = R$ 218,00."));
    }

    @Test
    void makeReport_WithoutItems() {
        // given
        /* No items */

        // when
        String report = itemService.makeReport();

        // then
        assertNotNull(report);
        assertEquals("Nenhum item cadastrado", report);
    }

    @Test
    void saveAll_Success() {
        // given
        Item actualItem;
        Item expectedItem;
        List<Item> expectedItems = List.of(
                new Item(88.00),
                new Item(130.00),
                new Item(54.90)
        );

        // when
        List<Item> items = itemService.saveAll(expectedItems);

        // then
        assertNotNull(items);
        assertEquals(expectedItems.size(), items.size());
        for (int i = 0; i < items.size(); i++) {
            actualItem = items.get(i);
            expectedItem = expectedItems.get(i);
            assertNotEquals(0L, actualItem.getId());
            assertEquals(expectedItem.getPrice(), actualItem.getPrice());
        }
    }
}
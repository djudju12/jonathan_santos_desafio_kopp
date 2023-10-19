package com.jonathan.desafio.repository.implementation;

import com.jonathan.desafio.model.Item;
import com.jonathan.desafio.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryImplTest {

    private ItemRepository itemRepository;

    final Double ITEM_PRICE = 10.0;
    final Long FIRST_ITEM_ID = 1L;

    @BeforeEach
    void setUp() {
        itemRepository = new ItemRepositoryImpl();
    }

    @Test
    void save_Success() {
        // given
        Item item = new Item(ITEM_PRICE);

        // when
        Item newItem = itemRepository.save(item);

        // then
        assertNotNull(newItem);
        assertNotNull(newItem.getPrice());
        assertNotEquals(0L, newItem.getId());
        assertEquals(ITEM_PRICE, newItem.getPrice());
    }

    @Test
    void save_ItemWithPriceNull_ReturnPriceZero() {
        // given
        Item item = new Item(null);

        // when
        Item newItem = itemRepository.save(item);

        // then
        assertNotNull(newItem);
        assertEquals(0.0, newItem.getPrice());
    }

    @Test
    void save_ItemWithId_ReturnWithNewId() {
        // given
        Long itemId = 10L;
        Item item = new Item(itemId, ITEM_PRICE);

        // when
        Item newItem = itemRepository.save(item);

        // then
        assertNotNull(newItem);
        assertEquals(FIRST_ITEM_ID, newItem.getId());
        assertNotEquals(item, newItem);
    }

    @Test
    void findAll_Sucess() {
        // given
        final int n = 3;
        for (int i = 0; i < n; i++) {
            itemRepository.save(new Item(ITEM_PRICE));
        }

        // when
        var items = itemRepository.findAll();

        // then
        assertNotNull(items);
        assertEquals(n, items.size());
        items.forEach(
                item -> {
                    assertNotNull(item.getId());
                    assertNotEquals(0L, item.getId());
                    assertEquals(ITEM_PRICE, item.getPrice());
                }
        );
    }

    @Test
    void findAll_EmptyRepository() {
        // given
        /* empty repository */

        // when
        var items = itemRepository.findAll();

        // then
        assertNotNull(items);
        assertTrue(items.isEmpty());
    }

    @Test
    void clear() {
        // given
        final int n = 3;
        for (int i = 0; i < n; i++) {
            itemRepository.save(new Item(ITEM_PRICE));
        }

        // when
        itemRepository.clearDatabase();
        var items = itemRepository.findAll();

        // then
        assertNotNull(items);
        assertTrue(items.isEmpty());
    }
}
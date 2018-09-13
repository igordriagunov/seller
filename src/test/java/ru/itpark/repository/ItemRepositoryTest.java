package ru.itpark.repository;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.Item;
import ru.itpark.repository.details.ItemRepoDetails;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest extends ItemRepoDetails {

    private ItemRepository itemRepository = new ItemRepository();

    @Test
    @DisplayName("item should added in db, find item by article")
    void add() {

        itemRepository.add(
                new Item(
                        "Q5",
                        "xiaomi",
                        9999,
                        5
                )
        );
        assertEquals(expectedItem(), itemRepository.findItemByArticle("Q5"));
        itemRepository.removeByArticle("Q5");
    }

    @org.junit.jupiter.api.Test
    void findAllItems() {

        assertEquals(expectedAllItems(), itemRepository.findAllItems());
    }

    @org.junit.jupiter.api.Test
    void findByName() {

        itemRepository.add(
                new Item(
                        "SSS2",
                        "samsung S9",
                        89999,
                        5
                )
        );

        assertEquals(expectedItemSamsung(), itemRepository.findByName("samsung S9"));

        itemRepository.removeByArticle("SSS2");
    }

    @org.junit.jupiter.api.Test
    void sortAllByNameASC() {
    }

    @org.junit.jupiter.api.Test
    void sortAllByNameDESC() {
    }

    @org.junit.jupiter.api.Test
    void sortAllByQuantityASC() {
    }

    @org.junit.jupiter.api.Test
    void sortAllByQuantityDESC() {
    }

    @org.junit.jupiter.api.Test
    void sortAllByPriceASC() {
    }

    @org.junit.jupiter.api.Test
    void sortAllByPriceDESC() {
    }
}
package ru.itpark.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itpark.repository.details.ItemRepoDetails;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest extends ItemRepoDetails {

    private ItemRepository itemRepository;

    @Test
    @DisplayName("item should exists in db, find item by article")
    void add() {

        assertEquals(expectedItem(), itemRepository.findItemByArticle("ZXCV5555"));
    }

    @org.junit.jupiter.api.Test
    void findAllItems() {
    }

    @org.junit.jupiter.api.Test
    void findByName() {
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
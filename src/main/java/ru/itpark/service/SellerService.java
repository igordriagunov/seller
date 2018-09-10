package ru.itpark.service;

import ru.itpark.domain.Item;
import ru.itpark.domain.Sale;
import ru.itpark.repository.ItemRepository;
import ru.itpark.repository.SaleRepository;

import java.util.List;

public class SellerService {

    private final ItemRepository itemRepository;
    private final SaleRepository saleRepository;

    public SellerService(ItemRepository itemRepository, SaleRepository saleRepository) {
        this.itemRepository = itemRepository;
        this.saleRepository = saleRepository;
    }

    public void addItem(Item item) {
        itemRepository.add(item);
    }

    public void updateItemByArticle(Item item) {
        itemRepository.update(item);
    }

    public void removeItemByArticle(String article) {
        itemRepository.removeByArticle(article);
    }

    public List<Item> findAllItems() {
        return itemRepository.findAllItems();
    }

    public List<Item> findItemByName(String name) {
        return itemRepository.findByName(name);
    }

    public List<Item> findItemByArticle(String article) {
        return itemRepository.findItemByArticle(article);
    }

    public List<Item> sortAllItemsByNameASC() {
        return itemRepository.sortAllByNameASC();
    }

    public List<Item> sortAllItemsByNameDESC() {
        return itemRepository.sortAllByNameDESC();
    }

    public List<Item> sortAllItemsByQuantityASC() {
        return itemRepository.sortAllByQuantityASC();
    }

    public List<Item> sortAllItemsByQuantityDESC() {
        return itemRepository.sortAllByQuantityDESC();
    }

    public List<Item> sortAllItemsByPriceASC() {
        return itemRepository.sortAllByPriceASC();
    }

    public List<Item> sortAllItemsByPriceDESC() {
        return itemRepository.sortAllByPriceDESC();
    }

    public void addSale(Sale sale) {
        saleRepository.addSale(sale);
        saleRepository.deductQtyFromItems(sale);
    }

    public List<Sale> findAllSalesGroupByItemArticle() {
        return saleRepository.allSalesGroupByItemArticle();
    }

    public List<Sale> findAllSalesByItemArticle(String itemArticle) {
        return saleRepository.findAllSalesByItemArticle(itemArticle);
    }

//    public void deductQtyFromItems(Sale sale) {
//        saleRepository.deductQtyFromItems(sale);
//    }
}

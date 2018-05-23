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

    public void add(Item item) {
        itemRepository.add(item);
    }

    public void update(Item item) {
        itemRepository.add(item);
    }

    public void removeByArticle(String article) {
        itemRepository.removeByArticle(article);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public List<Item> findByName(String name){
        return itemRepository.findByName(name);
    }

    public List<Item> sortAllByNameASC() {
        return itemRepository.sortAllByNameASC();
    }

    public List<Item> sortAllByNameDESC() {
        return itemRepository.sortAllByNameDESC();
    }

    public List<Item> sortAllByQuantityASC() {
       return itemRepository.sortAllByQuantityASC();
    }

    public List<Item> sortAllByQuantityDESC() {
        return itemRepository.sortAllByQuantityDESC();
    }

    public List<Item> sortAllByPriceASC() {
        return itemRepository.sortAllByPriceASC();
    }

    public List<Item> sortAllByPriceDESC() {
        return itemRepository.sortAllByPriceDESC();
    }

    public void addSale(Sale sale) {
        saleRepository.addSale(sale);
    }


    public List<Sale> saleGroupByItemArticle() {
        return saleRepository.saleGroupByItemArticle();
    }

    public void deductQtyFromItems(Sale sale) {
        saleRepository.deductQtyFromItems(sale);
    }
}

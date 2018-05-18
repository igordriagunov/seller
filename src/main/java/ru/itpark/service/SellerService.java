package ru.itpark.service;

import ru.itpark.domain.Item;
import ru.itpark.repository.SellerRepository;

import java.util.List;

public class SellerService {

private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public void add(Item item) {
        sellerRepository.add(item);
    }

    public void update(Item item) {
        sellerRepository.add(item);
    }

    public void removeByArticle(String article) {
        sellerRepository.removeByArticle(article);
    }

    public List<Item> findAll(){
        return sellerRepository.findAll();
    }

    public List<Item> findByName(String name){
        return sellerRepository.findByName(name);
    }

    public List<Item> sortAllByNameASC() {
        return sellerRepository.sortAllByNameASC();
    }

    public List<Item> sortAllByNameDESC() {
        return sellerRepository.sortAllByNameDESC();
    }

    public List<Item> sortAllByQuantityASC() {
       return sellerRepository.sortAllByQuantityASC();
    }

    public List<Item> sortAllByQuantityDESC() {
        return sellerRepository.sortAllByQuantityDESC();
    }

    public List<Item> sortAllByPriceASC() {
        return sellerRepository.sortAllByPriceASC();
    }

    public List<Item> sortAllByPriceDESC() {
        return sellerRepository.sortAllByPriceDESC();
    }



}

package ru.itpark;

import ru.itpark.domain.Item;
import ru.itpark.domain.Sale;
import ru.itpark.repository.ItemRepository;
import ru.itpark.repository.SaleRepository;
import ru.itpark.service.SellerService;

public class Main {
    public static void main(String[] args) {

        ItemRepository itemRepository = new ItemRepository("jdbc:sqlite:db.sqlite3");
        SaleRepository saleRepository = new SaleRepository("jdbc:sqlite:db.sqlite3");

        SellerService service = new SellerService(itemRepository, saleRepository);


    }
}

package ru.itpark;

import ru.itpark.domain.Item;
import ru.itpark.domain.Sale;
import ru.itpark.repository.ItemRepository;
import ru.itpark.repository.SaleRepository;
import ru.itpark.service.SellerService;

public class Main {
    public static void main(String[] args) {

        ItemRepository itemRepository;
        SaleRepository saleRepository;

        SellerService service = new SellerService();


        //        service.addItem(
//                new Item(
//                        "q2",
//                        "pepsi",
//                        59,
//                        3
//                )
//        );

//        service.addSale(
//                new Sale(
//                        0,
//                        "q2",
//                        6
//                )
//        );

        System.out.println(service.findItemByArticle("ZXCV5555"));

    }
}

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

//        service.addSale(
//                new Sale(
//                        "POIU1111",
//                        1
//                )
//        );


//        repository.add(
//                new Item(
//                        "QWER1234",
//                        "Notebook",
//                        100,
//                        25
//                )
//        );

//        System.out.println(repository.findAllItems());


//        repository.update(
//                new Item(
//                        "QWER1234",
//                        "Notebook A6",
//                        55,
//                        5
//                )
//        );
//
//
//        repository.add(
//                new Item(
//                        "ZXCV5555",
//                        "Кроссовки спорт",
//                        999,
//                        3
//                )
//        );

//        System.out.println(repository.findAllItems());

//        repository.removeByArticle("ZXCV5555");

//        repository.add(
//                new Item(
//                        "POIU1111",
//                        "Ручка гелевая черная",
//                        15,
//                        120
//                )
//        );
//
//        repository.add(
//                new Item(
//                        "MNBV2345",
//                        "Мышь компьютерная SVEN",
//                        499,
//                        6
//                )
//        );
//
//        repository.add(
//                new Item(
//                        "ERTY9876",
//                        "Арбуз",
//                        150,
//                        64
//                )
//        );
//
//        repository.add(
//                new Item(
//                        "LKJH4567",
//                        "Яблоко",
//                        250,
//                        555
//                )
//        );

//        System.out.println(repository.sortAllByNameASC());
//        System.out.println(repository.sortAllByNameDESC());
//        System.out.println(repository.sortAllByQuantityASC());
//        System.out.println(repository.sortAllByQuantityDESC());
//        System.out.println(repository.sortAllByPriceASC());
//        System.out.println(repository.sortAllByPriceDESC());
//        System.out.println(repository.findByName("sven"));
//        System.out.println(repository.Sale("LKJH4567"));


//        saleRepository.addSale(
//                new Sale(
//                        "QWER1234",
//                        10
//                )
//        );

//        saleRepository.addSale(
//                new Sale(
//                        "POIU1111",
//                        2
//                )
//        );
//
//        saleRepository.addSale(
//                new Sale(
//                        "POIU1111",
//                        3
//                )
//        );

//        System.out.println(saleRepository.saleGroupByItemArticle());
//        System.out.println(saleRepository.saleGroupByItemArticle());


//        );
//
//        saleRepository.deductQtyFromItems(
//                new Sale(
//                        "POIU1111",
//                        1
//                )
//        );
//
//        saleRepository.addSale(new Sale(
//                        "POIU1111",
//                        1
//                )
//        );
//
        System.out.println(service.findAllSalesByItemArticle());

    }
}

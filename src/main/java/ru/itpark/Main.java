package ru.itpark;

import ru.itpark.repository.SellerRepository;

public class Main {
    public static void main(String[] args) {

        SellerRepository repository = new SellerRepository("jdbc:sqlite:db.sqlite3");

//        repository.add(
//                new Item(
//                        "QWER1234",
//                        "Notebook",
//                        100,
//                        25
//                )
//        );

//        System.out.println(repository.findAll());


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

//        System.out.println(repository.findAll());

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

        System.out.println(repository.sortAllByNameASC());
        System.out.println(repository.sortAllByNameDESC());
        System.out.println(repository.sortAllByQuantityASC());
        System.out.println(repository.sortAllByQuantityDESC());
        System.out.println(repository.sortAllByPriceASC());
        System.out.println(repository.sortAllByPriceDESC());
        System.out.println(repository.findByName("sven"));
//        System.out.println(repository.Sale("LKJH4567"));




    }
}

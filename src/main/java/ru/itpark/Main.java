package ru.itpark;

import ru.itpark.domain.Item;
import ru.itpark.repository.SellerRepository;

public class Main {
    public static void main(String[] args) {

        SellerRepository repository = new SellerRepository("jdbc:sqlite:db.sqlite3");

        repository.add(
                new Item(
                        "QWER1234",
                        "Notebook",
                        100,
                        25
                )
        );

        System.out.println(repository.findAll());


        repository.update(
                new Item(
                        "QWER1234",
                        "Notebook A6",
                        55,
                        5
                )
        );


    }
}

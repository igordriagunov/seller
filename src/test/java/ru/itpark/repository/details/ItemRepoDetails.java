package ru.itpark.repository.details;

import ru.itpark.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepoDetails {


    protected List<Item> expectedItem() {
        List<Item> list = new ArrayList<>();

        list.add(
                new Item(
                        "Q5",
                        "xiaomi",
                        9999,
                        5
                )
        );

        return list;
    }

    protected List<Item> expectedAllItems() {
        List<Item> list = new ArrayList<>();

        list.add(
                new
                        Item(
                        "q1",
                        "coca cola",
                        69,
                        2
                )
        );

        list.add(
                new
                        Item(
                        "q2",
                        "pepsi",
                        59,
                        3
                )
        );

//        list.add(
//                new Item(
//                        "SSS2",
//                        "samsung S9",
//                        89999,
//                        5
//                )
//        );

        list.add(
                new
                        Item(
                        "ZXCV5555",
                        "Nike AIR",
                        2999,
                        3
                )
        );

        return list;
    }

    protected List<Item> expectedItemSamsung() {
        List<Item> list = new ArrayList<>();

        list.add(
                new Item(
                        "SSS2",
                        "samsung S9",
                        89999,
                        5
                )
        );

        return list;
    }
}

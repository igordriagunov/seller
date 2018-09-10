package ru.itpark.repository.details;

import ru.itpark.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepoDetails {

    public List<Item> expectedItem() {
        List<Item> list = new ArrayList<>();

        list.add(
                new Item(
                        "ZXCV5555",
                        "Nike AIR",
                        2999,
                        3

                )
        );

        return list;
    }
}

package ru.itpark.repository;

import ru.itpark.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SellerRepository {

    private String url;

    public SellerRepository(String url) {
        this.url = url;
        init();
    }

    public void add(Item item) {

        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO items (article, name, price, quantity) VALUES (?,?,?,?); ")) {

                statement.setString(1, item.getArticle());
                statement.setString(2, item.getName());
                statement.setInt(3, item.getPrice());
                statement.setInt(4, item.getQuantity());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Item item) {

        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE items SET name=?, price=?, quantity=? WHERE article=?;")) {

                statement.setString(1, item.getName());
                statement.setInt(2, item.getPrice());
                statement.setInt(3, item.getQuantity());
                statement.setString(4, item.getArticle());

                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT article, name, price, quantity FROM items");

                while (resultSet.next()) {
                    items.add(
                            new Item(
                                    resultSet.getString("article"),
                                    resultSet.getString("name"),
                                    resultSet.getInt("price"),
                                    resultSet.getInt("quantity")
                            )
                    );

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    private void init() {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE table if not exists items (\n" +
                        "article TEXT NOT NULL PRIMARY KEY UNIQUE ,\n" +
                        "name TEXT NOT NULL ,\n" +
                        "price INTEGER NOT NULL ,\n" +
                        "quantity INTEGER CHECK (quantity >= 0)" +
                        ");\n"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


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

    public void removeByArticle(String article) {
        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE article=?;")) {

                statement.setString(1, article);

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

    public List<Item> sortAllByNameASC() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT article, name, price, quantity FROM items ORDER BY name ASC ");

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

    public List<Item> sortAllByNameDESC() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT article, name, price, quantity FROM items ORDER BY name DESC ");

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

    public List<Item> sortAllByQuantityASC() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT article, name, price, quantity FROM items ORDER BY quantity ASC ");

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

    public List<Item> sortAllByQuantityDESC() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT article, name, price, quantity FROM items ORDER BY quantity DESC ");

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

    public List<Item> sortAllByPriceASC() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT article, name, price, quantity FROM items ORDER BY price ASC ");

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

    public List<Item> sortAllByPriceDESC() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(
                        "SELECT article, name, price, quantity FROM items ORDER BY price DESC ");

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


package ru.itpark.repository;

import ru.itpark.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ItemRepository {

    private final String url = "jdbc:mysql://localhost:3306/sellerdb?verifyServerCertificate=false&useSSL=false&password=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "password";

    public ItemRepository() {
        initTableItems();
//        initTrigger();
    }


    public void add(Item item) {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO items (article, name, price, quantity) VALUES (?,?,?,?); ")) {

                statement.setString(1, item.getArticle());
                statement.setString(2, item.getName());
                statement.setInt(3, item.getPrice());
                statement.setInt(4, item.getQuantity());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Товар с таким артикулом уже существует");
            e.printStackTrace();
        }

    }

    public void update(Item item) {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE article=?;")) {

                statement.setString(1, article);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Item> findAllItems() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

    public List<Item> findByName(String name) {
        List<Item> list = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT article, name, price, quantity FROM items WHERE LOWER(name) LIKE ?;")) {

                statement.setString(1, "%" + name.toLowerCase() + "%");
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    list.add(
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
        return list;
    }

    public List<Item> findItemByArticle(String article) {
        List<Item> list = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT article, name, price, quantity FROM items WHERE article LIKE ?;")) {

                statement.setString(1,  article );
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    list.add(
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
        return list;
    }


    public List<Item> sortAllByNameASC() {
        List<Item> items = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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


    private void initTableItems() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(
                        "create table if not exists items(\n" +
                                "article varchar(99) not null primary key unique,\n" +
                                "name varchar(99) not null,\n" +
                                "price int not null,\n" +
                                "quantity int not null\n" +
                                ");"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void initTrigger() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(
                        "\n" +
                                "DELIMITER //\n" +
                                "create trigger qty_check \n" +
                                "before insert on items\n" +
                                "for each row \n" +
                                "begin\n" +
                                "if quantity<=0 then\n" +
                                "set new.quantity = 0;\n" +
                                "end if;\n" +
                                "end//"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


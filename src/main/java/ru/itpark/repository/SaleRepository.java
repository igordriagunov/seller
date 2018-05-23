package ru.itpark.repository;

import ru.itpark.domain.Item;
import ru.itpark.domain.Sale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository {

    private String url;

    public SaleRepository(String url) {
        this.url = url;
        initSales();
    }


    private void initSales() {

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE table if not exists sales (\n" +
                        "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "itemArticle TEXT NOT NULL,\n" +
                        "saleQuantity INTEGER CHECK (saleQuantity >= 0),\n" +
                        "FOREIGN KEY (saleQuantity) REFERENCES items(quantity)\n" +
                        ");");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addSale(Sale sale) {

        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement =
                         connection.prepareStatement(
                                 "INSERT INTO sales (itemArticle, saleQuantity) VALUES (?,?)")) {

                statement.setString(1, sale.getItemArticle());
                statement.setInt(2, sale.getSaleQuantity());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sale> saleGroupByItemArticle() {
        List<Sale> list = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            try (Statement statement = connection.createStatement()) {


                ResultSet resultSet = statement.executeQuery("SELECT itemArticle, SUM(saleQuantity ) AS saleQuantity FROM sales GROUP BY itemArticle ;");

                while (resultSet.next()) {

                    list.add(
                            new Sale(
                                    resultSet.getString("itemArticle"),
                                    resultSet.getInt("saleQuantity")

                            )
                    );

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    public void deductQtyFromItems (Item item) {

        try (Connection connection = DriverManager.getConnection(url)) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE items SET quantity= quantity - ? WHERE article=?;")){

                statement.setInt(1,item.getQuantity());
//                statement.setString(2,item.getName());
//                statement.setInt(3,item.getPrice());
                statement.setString(2,item.getArticle());

                statement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Проверьте количество товара");
            e.printStackTrace();
        }
    }
}



package ru.itpark.domain;

import java.util.Objects;

public class Sale {

    private int id;
    private String itemArticle;
    private int saleQuantity;

    public Sale(int id, String itemArticle, int saleQuantity) {
        this.id = id;
        this.itemArticle = itemArticle;
        this.saleQuantity = saleQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemArticle() {
        return itemArticle;
    }

    public void setItemArticle(String itemArticle) {
        this.itemArticle = itemArticle;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id == sale.id &&
                saleQuantity == sale.saleQuantity &&
                Objects.equals(itemArticle, sale.itemArticle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, itemArticle, saleQuantity);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", itemArticle='" + itemArticle + '\'' +
                ", saleQuantity=" + saleQuantity +
                '}';
    }
}

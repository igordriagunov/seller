package ru.itpark.domain;

import java.util.Objects;

public class Sale {

    private String itemArticle;
    private int saleQuantity;

    public Sale(String itemArticle, int saleQuantity) {
        this.itemArticle = itemArticle;
        this.saleQuantity = saleQuantity;
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
        return saleQuantity == sale.saleQuantity &&
                Objects.equals(itemArticle, sale.itemArticle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemArticle, saleQuantity);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "itemArticle='" + itemArticle + '\'' +
                ", saleQuantity=" + saleQuantity +
                '}';
    }
}

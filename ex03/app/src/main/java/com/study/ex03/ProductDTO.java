package com.study.ex03;

import java.io.Serializable;

// 주의:  intent.putExtra()에서 클래스 단위로 인자를 사용할 경우 반드시 객체직렬화(Serializable)를 해야함.
public class ProductDTO implements Serializable {
    private int id;
    private String product_name;
    private int price;
    private int amount;

    // Alt+Insert(생성자, Getter, Setter, toString() )

    // 생성자 작성(인자있는경우, 없는경우 모두)
    public ProductDTO() {
    }

    public ProductDTO(String product_name, int price, int amount) {
        this.product_name = product_name;
        this.price = price;
        this.amount = amount;
    }

    public ProductDTO(int id, String product_name, int price, int amount) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProlductDTO{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}

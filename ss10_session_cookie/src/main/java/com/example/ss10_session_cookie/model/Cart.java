package com.example.ss10_session_cookie.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    //    để kiểm tra xem sản phẩm đó đã có trong giỏ hàng hay chưa
    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getIdProduct().equals(product.getIdProduct())) {
                return true;
            }
        }
        return false;
    }

    //được sử dụng để chọn mặt hàng trong giỏ hàng
    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getIdProduct().equals(product.getIdProduct())) {
                return entry;
            }
        }
        return null;
    }

    //được sử dụng để thêm sản phẩm vào trong giỏ hàng.
    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //dùng để đếm số lượng sản phẩm đó hiện có trong giỏ hàng.
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    //để đếm số lượng sản phẩm có trong giỏ hàng.
    public Integer countItemQuantity() {
        return products.size();
    }

    //dùng để tính tổng số tiền cần phải thanh toán.
    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPriceProduct() * (float) entry.getValue();
        }
        return payment;
    }
}

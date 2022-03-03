package edu.wctc.shopping.service;

import edu.wctc.shopping.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(int productId);
    List<Product> getProducts();
    void updateProduct(Product product);
}

package edu.wctc.shopping.service;

import edu.wctc.shopping.entity.Product;
import edu.wctc.shopping.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicProductService implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public BasicProductService(ProductRepository pr) {this.productRepository = pr;}

    @Override
    public Product getProduct(int productId) {
        Product pr;
        Optional<Product> p = productRepository.findById(productId);
        if (p.isPresent()) {
            return p.get();
        }
        else {
            pr = new Product();
            pr.setId(productId);
        }
        return pr;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }
}

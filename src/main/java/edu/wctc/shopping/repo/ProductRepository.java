package edu.wctc.shopping.repo;

import edu.wctc.shopping.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}

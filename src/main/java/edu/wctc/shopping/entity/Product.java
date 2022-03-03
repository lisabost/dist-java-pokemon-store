package edu.wctc.shopping.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="Product")
public class Product {
    @Id
    @Column(name="product_id")
    private int id;
    @Column(name="product_name")
    private String name;
    private double price;
    @Column(name="image_file_name")
    private String imageFileName;
    private int quantity;
}

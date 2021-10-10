package tn.formalab.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.formalab.eco.models.Product;
import tn.formalab.eco.repositories.ProductRepository;

@RestController
@RequestMapping("products")
//http://localhost:8081/products   /....(URLApi)
public class ProductController {

    public ProductRepository productRepository;
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    add product
    @PostMapping("")
    public ResponseEntity<Product> APIAddProduct(@RequestBody Product product)
    {
        System.out.println(product);
       Product NewProduct = productRepository.save(product);
       return ResponseEntity.status(HttpStatus.CREATED).body(NewProduct);
    }

}

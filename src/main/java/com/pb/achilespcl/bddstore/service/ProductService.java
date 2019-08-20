package com.pb.achilespcl.bddstore.service;

import com.pb.achilespcl.bddstore.model.Product;
import com.pb.achilespcl.bddstore.repository.ProductRepository;
import com.pb.achilespcl.bddstore.web.rest.request.ProductRequest;
import com.pb.achilespcl.bddstore.web.rest.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(ProductRequest product){
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        return productRepository.save(newProduct);
    }
}

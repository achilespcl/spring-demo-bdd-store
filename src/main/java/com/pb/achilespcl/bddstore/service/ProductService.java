package com.pb.achilespcl.bddstore.service;

import com.pb.achilespcl.bddstore.model.Product;
import com.pb.achilespcl.bddstore.repository.ProductRepository;
import com.pb.achilespcl.bddstore.web.rest.request.ProductRequest;
import com.pb.achilespcl.bddstore.web.rest.response.ProductResponse;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    public Product getProductById(Long id) throws EntityNotFoundException {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteProductById(Long productId) {
        productRepository.delete(getProductById(productId));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

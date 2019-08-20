package com.pb.achilespcl.bddstore.web.rest.resource;

import com.pb.achilespcl.bddstore.model.Product;
import com.pb.achilespcl.bddstore.service.ProductService;
import com.pb.achilespcl.bddstore.web.rest.request.ProductRequest;
import com.pb.achilespcl.bddstore.web.rest.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    ResponseEntity<Product> addProduct(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok().body(productService.createProduct(productRequest));
    }

}

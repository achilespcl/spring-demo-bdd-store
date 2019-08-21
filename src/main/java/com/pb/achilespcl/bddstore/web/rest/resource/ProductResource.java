package com.pb.achilespcl.bddstore.web.rest.resource;

import com.pb.achilespcl.bddstore.model.Product;
import com.pb.achilespcl.bddstore.service.ProductService;
import com.pb.achilespcl.bddstore.web.rest.request.ProductRequest;
import com.pb.achilespcl.bddstore.web.rest.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    ResponseEntity<Product> addProduct(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok().body(productService.createProduct(productRequest));
    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProduct(@PathVariable(value = "id") Long productId){
        return ResponseEntity.ok().body(productService.getProductById(productId));
    }

    @GetMapping("/products")
    ResponseEntity<List<Product>> getProduct(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Long productId){
        try {
            productService.deleteProductById(productId);
            return ResponseEntity.ok().body(("Product was removed successfully!"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Product not found!");
        }

    }

}

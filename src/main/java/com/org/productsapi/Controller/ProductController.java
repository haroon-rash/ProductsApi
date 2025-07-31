package com.org.productsapi.Controller;


import com.org.productsapi.Entities.Product;
import com.org.productsapi.Exceptions.ProductNotFoundException;
import com.org.productsapi.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {


    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<String>> createProduct(@Valid @RequestBody Product product) {

        return productService.create(product)
            .thenReturn(ResponseEntity.status(HttpStatus.CREATED)
            .body("Product Created Successfully"))
            .onErrorResume(e ->
             Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error creating product: " + e.getMessage()))
                );
    }
    @GetMapping("getproduct")
    public Mono<ResponseEntity<?>> getProduct() {

        return productService.getAll()
                .collectList()
                .flatMap(products -> {
                    if (products.isEmpty()) {
                        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("No products found"));
                    } else {
                        return Mono.just(ResponseEntity.ok(products));
                    }
                });

    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<?>> updateProduct(@Valid @RequestBody Product product, @PathVariable UUID id) {
        return productService.update(product, id)
                .map(ResponseEntity::ok);

    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteProduct(@PathVariable UUID id) {
        return productService.delete(id)
                .map(msg -> ResponseEntity.ok(msg))
                .onErrorResume(ProductNotFoundException.class, ex ->
                        Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()))
                );
    }


}

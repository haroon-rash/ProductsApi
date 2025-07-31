package com.org.productsapi.Service;

import com.org.productsapi.Entities.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductService {

    public Mono<Product> create(Product product);
    public Mono<Product> update (Product product ,UUID id);
public Mono<Void> delete (UUID id);
public Flux<Product> getAll();
public Flux<Product> search(String query);

}

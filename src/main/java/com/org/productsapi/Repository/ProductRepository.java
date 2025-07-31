package com.org.productsapi.Repository;


import com.org.productsapi.Entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, UUID> {


}

package com.org.productsapi.Service;

import com.org.productsapi.Entities.Product;
import com.org.productsapi.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
@Service
public class ProductserviceImp implements ProductService {
    ProductRepository productRepository;

    ProductserviceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Mono<Product> create(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product, UUID id) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found with id: " + id)))
                .flatMap(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setQuantity(product.getQuantity());
                    existingProduct.setDescription(product.getDescription());
                    return productRepository.save(existingProduct);
                });
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Product not found with id: " + id)))
                .flatMap(existingProduct -> productRepository.deleteById(id));
    }

    @Override
    public Flux<Product> getAll() {
      return productRepository.findAll();
    }

    @Override
    public Flux<Product> search(String query) {
        return  null;
    }
}

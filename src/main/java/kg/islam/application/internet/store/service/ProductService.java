package kg.islam.application.internet.store.service;

import kg.islam.application.internet.store.dto.ProductRequest;

public interface ProductService {
    void addProduct(ProductRequest request);

    void updateById(Long productId, ProductRequest productRequest);
}

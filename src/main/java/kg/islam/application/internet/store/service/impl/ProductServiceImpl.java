package kg.islam.application.internet.store.service.impl;

import kg.islam.application.internet.store.dto.ProductRequest;
import kg.islam.application.internet.store.entity.Product;
import kg.islam.application.internet.store.repo.ProductRepository;
import kg.islam.application.internet.store.service.ProductService;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setPrize(request.getPrize());
        product.setCount(request.getCount());
        productRepository.save(product);
    }

    @Override
    public void updateById(Long productId, ProductRequest productRequest) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()){
            System.out.println("not find product with id: " + productId);
            return;
        }
        product.get().setType(productRequest.getType());
        product.get().setName(productRequest.getName());
        product.get().setCount(productRequest.getCount());
        product.get().setPrize(productRequest.getPrize());
        productRepository.save(product.get());
    }
}

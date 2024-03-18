package kg.islam.application.internet.store.restControllers;

import kg.islam.application.internet.store.dto.ProductRequest;
import kg.islam.application.internet.store.entity.Product;
import kg.islam.application.internet.store.repo.ProductRepository;
import kg.islam.application.internet.store.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/add")
    public void addProduct(ProductRequest request) {
        productService.addProduct(request);
    }

    @GetMapping("/getById/{productId}")
    public Optional<Product> product(@PathVariable Long productId) {
        if (productRepository.findById(productId).isEmpty())
            return Optional.empty();
        return productRepository.findById(productId);
    }

    @DeleteMapping("/deleteById/{productId}")
    public void delete(@PathVariable Long productId){
        productRepository.deleteById(productId);
    }

    @PutMapping("/updateById/{productId}")
    public void updateById(@PathVariable Long productId, @RequestBody ProductRequest productRequest){
        productService.updateById(productId, productRequest);
    }

}











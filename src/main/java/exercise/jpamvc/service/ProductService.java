package exercise.jpamvc.service;

import exercise.jpamvc.domain.Product;
import exercise.jpamvc.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product retrieve(Long id) {
        return productRepository.getById(id);
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
}

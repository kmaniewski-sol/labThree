package exercise.jpamvc.controller;

import exercise.jpamvc.domain.Product;
import exercise.jpamvc.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(path="/product/retrieve/{id}")
    public Product retrieve(@PathVariable("id") Long id){
        return productService.retrieve(id);
    }

    @DeleteMapping(path="/product/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}

package exercise.jpamvc.controller;

import exercise.jpamvc.domain.Product;
import exercise.jpamvc.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(path="/product/create")
    @ResponseBody
    public Product save(@RequestBody Product product){
        return productService.save(product);
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

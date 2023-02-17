package tutojava.com.tuto.product.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tutojava.com.tuto.product.dao.repositories.ProductRepository;
import tutojava.com.tuto.product.dto.ProductDto;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto product) {
        return productRepository.save(product);
    }
    
}

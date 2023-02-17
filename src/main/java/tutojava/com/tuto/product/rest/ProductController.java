package tutojava.com.tuto.product.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tutojava.com.tuto.product.dto.ProductDto;
import tutojava.com.tuto.product.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productServiceImpl.findById(id);
    }

    @PostMapping
    public void add(@RequestBody ProductDto product) {
        productServiceImpl.add(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody ProductDto product) {
        product.setId(id);
        productServiceImpl.update(product);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productServiceImpl.delete(id);
    }
}

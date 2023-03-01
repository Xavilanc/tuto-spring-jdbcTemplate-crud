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

    /**
     * 
     * @return Une liste {@link ProductDto} correspondant à l'ensemble des produits
     */
    @GetMapping
    public List<ProductDto> getProducts() {
        return productServiceImpl.findAll();
    }

    /**
     * 
     * @param id L'identifiant du produit à lire
     * @return Un {@link ProductDto} représentant le produit demandé
     */
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productServiceImpl.findById(id);
    }

    /**
     * 
     * @param product un {@link ProductDto}
     */
    @PostMapping
    public void add(@RequestBody ProductDto product) {
        productServiceImpl.add(product);
    }

    /**
     * 
     * @param id L'identifiant du produit que l'on veux modifier
     * @param product un {@link ProductDto}
     */
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody ProductDto product) {
        product.setId(id);
        productServiceImpl.update(product);
    }
    
    /**
     * 
     * @param id L'identifiant du produit que l'on veux supprimer
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productServiceImpl.delete(id);
    }
}

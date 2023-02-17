package tutojava.com.tuto.product.service;

import java.util.*;

import tutojava.com.tuto.product.dto.ProductDto;

public interface ProductService {
    
    //Find all products
    List<ProductDto> findAll();

    //Find product by id
    ProductDto findById(int id);

    //Find by name
    ProductDto findByName(String name);

    //Add product
    int add(ProductDto product);

    //Update product
    int update(ProductDto product);

    //Delete product
    int delete(int id);
}

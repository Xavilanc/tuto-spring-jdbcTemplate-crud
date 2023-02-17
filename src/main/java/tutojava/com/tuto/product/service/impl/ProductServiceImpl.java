package tutojava.com.tuto.product.service.impl;

import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import tutojava.com.tuto.product.dao.repositories.ProductRepository;
import tutojava.com.tuto.product.dto.ProductDto;
import tutojava.com.tuto.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
    // Product repository
    private final ProductRepository productRepository;

    //Injection by contructor
    public ProductServiceImpl(ProductRepository productRepository, JdbcTemplate jdbcTemplate) {
        this.productRepository  = productRepository;
    }

    //Inherit methods from ProductService
    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductDto findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductDto findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public int add(ProductDto product) {
        return productRepository.add(product);
    }

    @Override
    public int update(ProductDto product) {
        return productRepository.update(product);
    }

    @Override
    public int delete(int id) {
        return productRepository.delete(id);
    }
}

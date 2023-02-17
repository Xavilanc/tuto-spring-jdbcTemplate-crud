package tutojava.com.tuto.product.dao.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tutojava.com.tuto.product.dto.ProductDto;

@Repository
public class ProductRepository {
    
    //JdbcTemplate
    private final JdbcTemplate jdbcTemplate;

    //Injection by contructor
    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductDto> findAll() {
        String sql = "SELECT * FROM product";
        RowMapper<ProductDto> rowMapper = new BeanPropertyRowMapper<>(ProductDto.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public ProductDto findById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        RowMapper<ProductDto> rowMapper = new BeanPropertyRowMapper<>(ProductDto.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public ProductDto findByName(String name) {
        String sql = "SELECT * FROM product WHERE name = ?";
        RowMapper<ProductDto> rowMapper = new BeanPropertyRowMapper<>(ProductDto.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, name);
    }

    public int add(ProductDto product) {
        String sql = "INSERT INTO product (name) VALUES (?)";
        return jdbcTemplate.update(sql, product.getName());
    }

    public int update(ProductDto product) {
        String sql = "UPDATE product SET name = ? WHERE id = ?";
        return jdbcTemplate.update(
            sql,
            product.getName(),
            product.getId()
        );
    }

    public int delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

}

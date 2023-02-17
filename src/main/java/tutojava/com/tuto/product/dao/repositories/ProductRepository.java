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
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductDto> findAll() {
        String sql = "SELECT * FROM product";
        RowMapper<ProductDto> rowMapper = new BeanPropertyRowMapper<>(ProductDto.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    // public List<ProductDto> findAll() {
    //     String sql = "SELECT * FROM product";
    //     List<ProductDto> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductDto.class));
    //     return products;
    // }

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

//     public int count() {
//         return jdbcTemplate
//             .queryForObject("select count(*) from product", Integer.class);
//     }

//     public ProductDto save(ProductDto product) {
//         String sql = "INSERT INTO product(name) VALUES (?)";
//         jdbcTemplate.update(sql, product.getName());
//         return product;
//     }

//     public int update(ProductDto product) {
//         return jdbcTemplate
//             .update("update product set name = ? where id = ?",
//             product.getName(), product.getId());
//     }

//     public int deleteById(Long id) {
//         return jdbcTemplate.update(
//                 "delete product where id = ?",
//                 id);
//     }


//     public List<ProductDto> findAll() {
//     String sql = "SELECT * FROM product";
//     List<ProductDto> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductDto.class));
//     return products;
// }


//     public String getNameById(Long id) {
//         return jdbcTemplate.queryForObject(
//                 "select name from product where id = ?",
//                 String.class, id
//         );
//     }

}

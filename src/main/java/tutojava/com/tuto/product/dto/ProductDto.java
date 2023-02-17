package tutojava.com.tuto.product.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDto {
    public ProductDto(long long1, String string) {
    }

    public ProductDto() {
    }

    private Long id;

    private String name;

}

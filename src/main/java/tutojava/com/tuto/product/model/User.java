package tutojava.com.tuto.product.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    
    private int id;

    private String  username;

    private String email;

    private String password;

    private int  enabled;
}
package tutojava.com.tuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TutoApplication {


	public static void main(String[] args) {
		SpringApplication.run(TutoApplication.class, args);
	}

  @Autowired
  JdbcTemplate jdbcTemplate;

}

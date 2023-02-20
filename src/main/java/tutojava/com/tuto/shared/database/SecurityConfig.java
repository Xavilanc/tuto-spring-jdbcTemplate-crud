package tutojava.com.tuto.shared.database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private DataSource dataSource;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT u.username, a.authority FROM users u JOIN authorities a ON u.authorities_id = a.id WHERE u.username = ?");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/products/**").hasRole("USER")
                .and().formLogin()
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().csrf().disable();
    }
    
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}

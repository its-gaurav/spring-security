package demo.security.config;


import demo.security.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*").permitAll()
                .antMatchers("/api/**").hasRole(UserRole.STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails gauravUser = User.builder()
                .username("gaurav")
                .password(passwordEncoder.encode("password")) // Remember password must be encoded here
                .roles(UserRole.ADMIN.name())
                .build();

        UserDetails ankitUser = User.builder()
                .username("ankit")
                .password(passwordEncoder.encode("pass123")) // Remember password must be encoded here
                .roles(UserRole.STUDENT.name())
                .build();

        return new InMemoryUserDetailsManager(gauravUser, ankitUser);
    }
}

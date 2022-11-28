package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/#", "/register").permitAll()
                .antMatchers("/donationform/**").hasRole("USER")
                .antMatchers("/donationform/**").authenticated()
                .antMatchers("/changedataofdonation/**").hasRole("USER")
                .antMatchers("/changedataofdonation/**").authenticated()
                .antMatchers("/mydonations/**").hasRole("USER")
                .antMatchers("/mydonations/**").authenticated()
                .antMatchers("/institutionform/**").hasRole("ADMIN")
                .antMatchers("/institutionform/**").authenticated()
                .antMatchers("/editinstitutions/**").hasRole("ADMIN")
                .antMatchers("/editinstitutions/**").authenticated()
                .antMatchers("/deleteinstitutions/**").hasRole("ADMIN")
                .antMatchers("/deleteinstitutions/**").authenticated()
                .antMatchers("/register/2").hasRole("ADMIN")
                .antMatchers("/register/2").authenticated()
                .antMatchers("/deleteusers/**").hasRole("ADMIN")
                .antMatchers("/deleteusers/**").authenticated()
                .antMatchers("/edituser/**").hasRole("ADMIN")
                .antMatchers("/edituser/**").authenticated()
                .antMatchers("/deleteinstitutions/**").hasRole("ADMIN")
                .antMatchers("/deleteinstitutions/**").authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .permitAll().and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .logout().permitAll();
    }

}

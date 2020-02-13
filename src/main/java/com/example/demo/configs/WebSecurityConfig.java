package com.example.demo.configs;

import com.example.demo.Service.YanCaoUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Bean
    UserDetailsService yanCaoUserService(){
        return new YanCaoUserService();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .authorizeRequests()
                //对/和/login路径不进行拦截
                .antMatchers("/login","/register","/addadmin").permitAll()
                .anyRequest().authenticated()
                //.anyRequest().permitAll()
                .and()
                .formLogin()
                //设置登录页面访问的路径/login
                .loginPage("/login")
                //登录后转向/路径
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe()
                .tokenValiditySeconds(43200)
                .key("mykey")
                .and()
                .headers()
                .frameOptions().disable()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(yanCaoUserService()).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return ENCODER.encode(rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {

                return ENCODER.matches(rawPassword,encodedPassword);
            }
        });
    }
    @Override
    //对/resources/static/目录下的静态资源，Spring Security不拦截
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/bootstrap/**");

    }
}

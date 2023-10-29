package com.example.demo.controladoresconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSeguridad2 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/css/**", "/Imagenes/**", "/js/**", "/", "/principal", "/home", "/inicio", "/logeo", "/login","/moduloDelivery/**","/index")
                .permitAll()
                .antMatchers("/rest/platos/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","ELIMINAR")
                .antMatchers("/rest/platos/nuevo").hasAnyRole("ADMIN","NUEVO")
                .antMatchers("/rest/platos/guardar").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/rest/platos/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/rest/platos/eliminar/**").hasAnyRole("ADMIN","ELIMINAR")
//sede
                .antMatchers("/rest/sedew/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","ELIMINAR")
                .antMatchers("/rest/sedew/nuevo").hasAnyRole("ADMIN","NUEVO")
                .antMatchers("/rest/sedew/guardar").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/rest/sedew/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/rest/sedew/eliminar/**").hasAnyRole("ADMIN","ELIMINAR")
//delivery
                .antMatchers("/rest/delivery/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","ELIMINAR")
                .antMatchers("/rest/delivery/nuevo").hasAnyRole("ADMIN","NUEVO")
                .antMatchers("/rest/delivery/guardar").hasAnyRole("ADMIN","CREADOR")
                .antMatchers("/rest/delivery/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/rest/delivery/eliminar/**").hasAnyRole("ADMIN","ELIMINAR")

                //.antMatchers("/peliculas/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                //.antMatchers("/peliculas/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                //.antMatchers("/peliculas/eliminar/**").hasAnyRole("ADMIN","ELIMINAR")


                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
                .and().logout()
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
                //trabajador listar y guardar
                .withUser("alex").password(encoder.encode("alex")).roles("CREADOR","NUEVO").and()
                //gerente eliminar y actualizar y listar
                .withUser("adso").password(encoder.encode("adso")).roles("CREADOR","ELIMINAR","EDITOR").and()
                //inventario  actualizar
                .withUser("mayte").password(encoder.encode("mayte")).roles("CREADOR","EDITOR").and();

    }


}

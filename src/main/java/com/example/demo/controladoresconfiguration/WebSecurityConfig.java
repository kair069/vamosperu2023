package com.example.demo.controladoresconfiguration;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
*/

/*
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)*/
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter */{
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.authorizeRequests()
                .antMatchers("/css/**", "/Imagenes/**", "/js/**", "/","/index", "/login","/bienvenida","/rest/**",
                        //"/moduloPlatos/**","/principal",
                        //"/moduloPlatos/listarTodo","/moduloPlatos/editarPlato","/moduloPlatos/NuevoPlato","/rest/platos/nuevo",

                        "/moduloSede/**",
                        "/moduloSede/listarTodo","/moduloSede/editarSede","/moduloSede/nuevoSede",

                        "/moduloDelivery/**",
                         "/moduloDelivery/listarTodo","/moduloDelivery/editarDelivery","/moduloDelivery/nuevoDelivery")

                .permitAll()
                .antMatchers("/rest/platos/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
                .antMatchers("/rest/platos/nuevo").hasRole("CREADOR")
               .antMatchers("/rest/platos/eliminar/**").hasAnyRole("ADMIN","CREADOR")
               .antMatchers("/rest/platos/actualizar/**").hasAnyRole("ADMIN","EDITOR")
               .antMatchers("/rest/platos/nuevo").hasRole("ADMIN")

               .antMatchers("/rest/platos/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
               //sedes
               .antMatchers("/rest/sedew/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
               .antMatchers("/rest/sedew/nuevo").hasAnyRole("ADMIN","CREADOR")
               .antMatchers("/rest/sedew/eliminar/**").hasAnyRole("ADMIN","CREADOR")
               .antMatchers("/rest/sedew/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
               .antMatchers("/rest/sedew/actualizar/**").hasAnyRole("ADMIN","EDITOR")
               //delivery
               .antMatchers("/rest/delivery/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
               .antMatchers("/rest/delivery/nuevo").hasAnyRole("ADMIN","CREADOR")
               .antMatchers("/rest/delivery/eliminar/**").hasAnyRole("ADMIN","CREADOR")
               .antMatchers("/rest/delivery/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
               .antMatchers("/rest/delivery/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida",true).permitAll()
                .and().logout()
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
                .withUser("jorge").password(encoder.encode("jorge")).roles("LECTOR").and()
                .withUser("maria").password(encoder.encode("maria")).roles("CREADOR", "LECTOR").and()
                .withUser("elena").password(encoder.encode("elena")).roles("LECTOR","DEPURADOR").and()
                .withUser("ernesto").password(encoder.encode("ernesto")).roles("EDITOR","LECTOR").and();

    }
    */

}

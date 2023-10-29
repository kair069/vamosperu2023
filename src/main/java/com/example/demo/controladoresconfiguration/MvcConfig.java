package com.example.demo.controladoresconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/bienvenida").setViewName("bienvenida");

        //registry.addViewController("/bienvenida/listarTodo").setViewName("moduloPlatos/listarTodo");
        //registry.addViewController("/bienvenida/NuevoPlato").setViewName("moduloPlatos/NuevoPlato");
        //registry.addViewController("/editar").setViewName("moduloPlatos/editarPlato");
        //Sede
        //registry.addViewController("/rest/sedew/listarTodo").setViewName("moduloSede/listarTodo");
        //registry.addViewController("/nuevoSede2").setViewName("moduloSede/nuevoSede");
        //registry.addViewController("/editarSede").setViewName("moduloSede/editarSede");
        //delivery
        //registry.addViewController("/rest/delivery/listarTodo").setViewName("moduloDelivery/listarTodo");
        //registry.addViewController("/rest/delivery/nuevo").setViewName("moduloDelivery/nuevoDelivery");

        //registry.addViewController("/rest/delivery/actualizar").setViewName("moduloDelivery/editarDelivery");
        //registry.addViewController("/error").setViewName("error");
        //registry.addViewController("/principal").setViewName("principal");
    }
}

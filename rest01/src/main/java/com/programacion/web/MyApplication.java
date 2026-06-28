package com.programacion.web;

import java.util.Set;

import com.programacion.web.rest.ChaoRest;
import com.programacion.web.rest.CustomerRest;
import com.programacion.web.rest.HolaRest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
//Configura los recursos de la aplicacion
@ApplicationPath("/api")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        //Las clases que seran consideradas al Path
        return  Set.of(HolaRest.class,
                ChaoRest.class,
                CustomerRest.class);
    }
}

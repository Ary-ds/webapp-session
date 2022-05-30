package ary.ds.anotacion;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import ary.ds.interceptors.Logging;
import ary.ds.interceptors.TransacionalJDBC;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

@TransacionalJDBC
@Logging
@Named
@Stereotype
@ApplicationScoped
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface Service {

}

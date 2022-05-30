package ary.ds.anotacion;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

@Retention(RUNTIME)
@Target(TYPE)
@Named
@SessionScoped
@Stereotype
public @interface CarroCompra {

}

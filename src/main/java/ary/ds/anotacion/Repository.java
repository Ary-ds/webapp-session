package ary.ds.anotacion;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

@Retention(RUNTIME)
@Target(TYPE)
@Named
@RequestScoped
@Stereotype
public @interface Repository {

}

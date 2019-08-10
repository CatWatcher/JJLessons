package com.ifmo.dicontainer.pakety;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
// чтобы можно было воспользоваться аннотацией во время исполнения программы
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
}

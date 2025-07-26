package com.example.vc.model.annotation;


import java.lang.annotation.*;

/**
 * @author: Nodir
 * @date: 27.07.2025
 * @group: Meloman
 **/

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiVersion {

    String value() default "1";

}

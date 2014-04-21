package org.zerosign.requesto.annotations;

import org.zerosign.requesto.impl.renderer.DefaultPathRenderer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for IRequestParam derivative.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RequestParam {
    String name() default "";

    Class renderer() default DefaultPathRenderer.class;

    boolean multipart() default false;
}

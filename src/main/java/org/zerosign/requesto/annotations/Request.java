

package org.zerosign.requesto.annotations;

import org.zerosign.requesto.enums.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation for Request class.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Request {
    RequestMethod method() default RequestMethod.GET;

    String endpoint() default "";
}

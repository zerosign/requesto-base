package org.zerosign.requesto.exception;

import java.util.Objects;

/**
 * Base class of exception in Requesto.
 *
 * This type of exception are RuntimeException because
 * I just hate to have word throw exception everywhere.
 * It makes the code too verbose.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 */
public class BaseRequestoException extends RuntimeException {

    public BaseRequestoException(final String message, final Class type) {

        super(String.format(message, Objects.toString(type)));
    }

    public BaseRequestoException(final String message, final Class type,
                                 final Throwable throwable) {

        super(String.format(message, Objects.toString(type)), throwable);
    }

}

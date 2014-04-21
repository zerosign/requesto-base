package org.zerosign.requesto.exception;

/**
 * @author zerosign
 */
public class ReflectionException extends BaseRequestoException {

    private static final String DEFAULT_MESSAGE = "Not a Request type : %s";

    public ReflectionException(Class type) {
        super(DEFAULT_MESSAGE, type);
    }

}

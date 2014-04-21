package org.zerosign.requesto.exception;

/**
 * @author zerosign
 */
public class TypeNotRegisteredException extends BaseRequestoException {

    private static final String DEFAULT_MESSAGE = "Request not registered : %s";

    public TypeNotRegisteredException(Class type) {

        super(DEFAULT_MESSAGE, type);
    }

}

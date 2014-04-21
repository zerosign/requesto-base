package org.zerosign.requesto.impl.responses;

import org.zerosign.requesto.annotations.Response;
import org.zerosign.requesto.ifaces.IResponse;
import org.zerosign.requesto.impl.formatter.StringConverter;

/**
 * The actual Response class that map the raw response.
 *
 * This just an example that showing what you should
 * do in creating a model for response class. It may not
 * need any constructor, since it depends on how you create
 * your implementation of
 * {@link org.zerosign.requesto.ifaces.IConverter} interface.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 */
@Response(formatter = StringConverter.class)
public class StringResponse implements IResponse {

    private final String response;

    public StringResponse(final String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "StringResponse{" + "response=" + response + '}';
    }

}

package org.zerosign.requesto.ifaces;

import java.io.IOException;
import java.net.URLConnection;

/**
 * An interface for RequestBuilder.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 *
 */
public interface IRequestBuilder {

    /**
     * Method to build the connection
     * @return
     */
    URLConnection build(final String baseUrl, IRequestParam param) throws IOException, InstantiationException, IllegalAccessException;
}

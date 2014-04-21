package org.zerosign.requesto.enums;

/**
 * Enumeration of all available of HTTP 1.1 request method.
 *
 * HTTP 1.1 request method
 * http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 */
public enum RequestMethod {
    OPTIONS, // list all methods
    GET, // usually being used for getting a resource from api
    POST, // same with get but can have multipart form data
    PUT, // usually being used for putting a resource into a server
    DELETE, // usually being used for deleting a resource from server
    HEAD, // test an endpoint
    TRACE, // tracing our request
    CONNECT // test connection to a server
}

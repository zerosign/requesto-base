package org.zerosign.requesto;

import org.zerosign.requesto.annotations.Request;
import org.zerosign.requesto.annotations.Response;
import org.zerosign.requesto.exception.ReflectionException;
import org.zerosign.requesto.exception.TypeNotRegisteredException;
import org.zerosign.requesto.ifaces.IConverter;
import org.zerosign.requesto.ifaces.IRequestBuilder;
import org.zerosign.requesto.ifaces.IRequestParam;
import org.zerosign.requesto.ifaces.IResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * Request adapter class for anything, it manages any
 * individual class of Response, Converter and RequestBuilder.
 *
 * Ones should never subclass this class. Rather than
 * subclassing this class, anybody should take interest
 * to its managed individual class and extend it for
 * more wisdom.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 *
 */
public class RequestAdapter {

    private final ExecutorService pool = Executors.newCachedThreadPool();

    private final HashMap<Class<IResponse>, IConverter> formatters;

    private final IRequestBuilder builder;

    private final HashMap<Class<IRequestParam>, Class<IResponse>> handlers;

    /**
     * The base url for the api
     */
    private final String baseUrl;

    /**
     * @param base
     */
    public RequestAdapter(final String base) {
        handlers = new HashMap<>();
        formatters = new HashMap<>();
        baseUrl = base;
        builder = null;
    }


    /**
     * @param request
     * @return
     */
    public Future<IResponse> execute(IRequestParam request) throws
            IllegalAccessException, IOException, InstantiationException {

        Class type = request.getClass();

        if (!handlers.containsKey(type)) {
            throw new TypeNotRegisteredException(type);
        }

        Class responseType = handlers.get(type);

        if (!formatters.containsKey(responseType)) {
            throw new TypeNotRegisteredException(type);
        }

        final IConverter<IResponse> formatter = formatters.get(responseType);

        final URLConnection connection = builder.build(baseUrl, request);

        final CompletableFuture<IResponse> future = CompletableFuture.
                supplyAsync(new Supplier<IResponse>() {

                    @Override
                    public IResponse get() {
                        Reader responseReader = null;

                        try {
                            connection.connect();
                        } catch(Exception _) {

                        }
                        try(BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream()))){
                            //
                        } catch(Exception _) {

                        }

                        return formatter.format(responseReader);

                    }
                }, pool);

        return future;
    }


    /**
     * @param requestType
     * @param responseType
     */
    public void registerRequestResultType(
            Class<IRequestParam> requestType,
            Class<IResponse> responseType) {

        // check format
        if (!(requestType.isAnnotationPresent(Request.class)
                && requestType.isAnnotationPresent(Response.class))) {
            throw new ReflectionException(requestType);
        }


    }
}

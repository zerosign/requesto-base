package org.zerosign.requesto.impl.builder;

import org.zerosign.requesto.annotations.Request;
import org.zerosign.requesto.annotations.RequestParam;
import org.zerosign.requesto.ifaces.IPathRenderer;
import org.zerosign.requesto.ifaces.IRequestBuilder;
import org.zerosign.requesto.ifaces.IRequestParam;
import org.zerosign.requesto.struct.Pair;

import javax.xml.ws.Holder;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to represents Request builder for REST request.
 * Any request that looks like REST can extends from this
 * class and override several methods rather than creating
 * on its own.
 *
 * @author zerosign
 * @version 1.0
 * @since 20 April 2014
 */
public class RESTRequestBuilder implements IRequestBuilder {


    /**
     * Bucket for caching the renderers
     */
    private HashMap<Class<IPathRenderer>, IPathRenderer> renderers;

    /**
     * Build current connection into REST connection by using
     * base url and request parameter provided in arguments.
     *
     * @param baseUrl
     * @param param
     * @return
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Override
    public URLConnection build(final String baseUrl, IRequestParam param)
            throws IOException, InstantiationException, IllegalAccessException {

        Class clazz = param.getClass();
        Request annotation = (Request) clazz.getAnnotation(
                Request.class);

        List<String> queries = processFieldParameters(param, clazz);

        final String endpoint = String.format("%s/%s%s", baseUrl,
                annotation.endpoint(), queries.stream().toString());

        URLConnection connection = new URL(endpoint).openConnection();

        return connection;
    }

    /**
     * Method to processing annotation field in class fields.
     *
     * @param clazz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    protected List<String> processFieldParameters(IRequestParam param, Class clazz)
            throws InstantiationException, IllegalAccessException {

        Field[] fields = clazz.getDeclaredFields();

        LinkedList<String> queries = new LinkedList<>();

        // get all annotation and process it
        for (Field field : fields) {

            RequestParam paramAnnotation = field.getAnnotation(RequestParam.class);

            String name = null;

            // default key of the query path
            // are gonna be the field name of the classes
            if (paramAnnotation.name().equals("")) {
                name = field.getName();
            } else {
                name = paramAnnotation.name();
            }

            field.setAccessible(true);
            Object o = field.get(param);

            field.setAccessible(false);
            IPathRenderer renderer = getRenderer(paramAnnotation.renderer());
            queries.add(renderer.render(new Pair<>(name, o)));
        }
        return queries;
    }

    /**
     * Get the actual renderer class from bucket.
     *
     * @param type
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private IPathRenderer getRenderer(Class<IPathRenderer> type)
            throws IllegalAccessException, InstantiationException {

        IPathRenderer renderer = null;
        if(!renderers.containsKey(type)) {
            renderer = type.newInstance();
            renderers.put(type, renderer);
        }
        return renderer;
    }

}

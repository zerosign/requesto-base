package org.zerosign.requesto.impl.renderer;

import org.zerosign.requesto.ifaces.IPathRenderer;
import org.zerosign.requesto.struct.Pair;

import java.lang.reflect.Field;

/**
 * The default path renderer for Request parameter.
 *
 * This renderer only render all GET query into this
 * kind of format "?key=value&". It uses recursive
 * evaluation of class field, so that if the class field
 * are non primitive field it can recursively do the
 * field parameter rendering.
 *
 * @author zerosign
 * @version 1.0
 * @since 20 April 2014
 */
public class DefaultPathRenderer implements IPathRenderer {

    private static final char QUERY_SEPARATOR = '&';
    private static final char QUERY_ASSIGNMENT = '=';
    private static final char FIELD_SEPARATOR = ' ';
    private static final String EMPTY_STRING = "";

    /**
     *
     * @param object
     * @return
     * @throws IllegalAccessException
     */
    private String render(Object object) throws IllegalAccessException {

        // returns empty if the object are null
        if(object == null)
            return EMPTY_STRING;

        Field[] fields = object.getClass().getDeclaredFields();

        // returns empty if no fields available
        if(fields.length == 0) {
            return EMPTY_STRING;
        }

        StringBuilder builder = new StringBuilder();

        // better than to string
        for(int ii = 0; ii < fields.length; ii++) {
            Field field = fields[ii];
            field.setAccessible(true);
            builder.append(render(field.get(object)));
            field.setAccessible(false);
            if(ii < fields.length - 1) {
                builder.append(FIELD_SEPARATOR);
            }
        }

        return builder.toString();
    }


    @Override
    public String render(Pair<String, Object>... path) throws IllegalAccessException {

        final String value = render(path[0].getSecond());

        return String.format("%c%s%c%%s",
                QUERY_SEPARATOR,
                path[0].getFirst(),
                QUERY_ASSIGNMENT,
                value);


    }
}

package org.zerosign.requesto.ifaces;

import org.zerosign.requesto.struct.Pair;

/**
 * An interface for PathRenderer.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 */
public interface IPathRenderer {

    /**
     * Render interface of the path
     *
     * @param path
     * @return
     */
    public String render(Pair<String, Object>... path) throws IllegalAccessException;
}

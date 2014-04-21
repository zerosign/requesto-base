package org.zerosign.requesto.ifaces;

import java.io.Reader;

/**
 * An interface of converter class.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 */
public interface IConverter<ResultType> {
    ResultType format(Reader reader);
}

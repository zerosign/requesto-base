package org.zerosign.requesto.impl.formatter;

import org.zerosign.requesto.ifaces.IConverter;
import org.zerosign.requesto.impl.responses.StringResponse;

import java.io.IOException;
import java.io.Reader;

/**
 * Very simple converter for StringResponse class.
 *
 * It demonstrated what you should/could do for converting
 * a Raw response string into an actual classes. This class
 * should not being used in an actual cases (only use this
 * class for debugging purpose).
 *
 * @author zerosign
 * @since  20 April 2014
 * @version 1.0
 */
public class StringConverter implements IConverter<StringResponse> {

    private static final int LENGTH = 1024;

    @Override
    public StringResponse format(Reader reader) {

        StringBuilder builder = new StringBuilder();

        char[] buffer = new char[LENGTH];

        try {
            while (reader.read(buffer, 0, LENGTH) > 0) {
                builder.append(buffer);
            }

        } catch (IOException ex) {
        }

        return new StringResponse(builder.toString());
    }

}

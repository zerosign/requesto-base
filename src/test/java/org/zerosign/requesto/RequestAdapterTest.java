package org.zerosign.requesto;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.zerosign.requesto.impl.responses.StringResponse;

/**
 * Created by zerosign on 19/04/14.
 */
@RunWith(Theories.class)
public class RequestAdapterTest {

    /**
     * The actual output given parameter
     *
     * @return
     */
    @DataPoint
    public static StringResponse[] data() {
        return null;
    }

    /**
     * Parameter of test cases
     *
     * @return
     */
    @DataPoint
    public static String[] param() {
        return null;
    }

    /**
     * @param param
     */
    @Theory
    public void theoryRequestNeedToReturnActualOutput(String param) {

    }

    /**
     * @param param
     */
    @Theory
    public void theoryIfRequestNetworkFailureThrowException(String param) {
    }


    @Theory
    public void theoryIfRequestConverterNotMatchThrowException(String param) {
    }


    @Theory
    public void theoryIfRequestFormatExpectedThrowException(String param) {
    }


}

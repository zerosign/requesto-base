package org.zerosign.requesto.enums;

/**
 * An enumeration of HTTP 1.1 response status.
 *
 * @author zerosign
 * @since 20 April 2014
 * @version 1.0
 */
public enum ResponseStatus {

    NONE(-1),
    // 1xx Informational
    CONTINUE(100),
    SWITCHING_PROTOCOLS(101),
    PROCESSING(102),

    // 2xx success
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NON_AUTHORITATIVE_INFO(203),
    NO_CONTENT(204),
    RESET_CONTENT(205),
    PARTIAL_CONTENT(206),
    MULTI_STATUS(207),
    ALREADY_REPORTED(208),
    IM_USED(226),

    // 3xx Redirection
    MULTIPLE_CHOICES(300),
    MOVED_PERMANENTLY(301),
    FOUND(302),
    SEE_OTHER(303),
    NOT_MODIFIED(304),
    USE_PROXY(305),
    SWITCH_PROXY(306),
    TEMPORARY_REDIRECT(307),
    PERMANENT_REDIRECT(308),

    // 4xx Client error
    BAD_REQUEST(400),
    UNATHORIZED(401),
    PAYMENT_REQUIRED(402),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    NOT_ACCEPTABLE(406),
    PROXY_AUTH_REQUIRED(407),
    REQUEST_TIMEOUT(408),
    CONFLICT(409),
    GONE(410),
    LENGTH_REQUIRED(411),
    PRECONDITION_FAILED(412)

    // 5xx Server error
    ;


    private int status;

    ResponseStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }


    /**
     *
     * @param status
     * @return
     */
    public static ResponseStatus from(int status) {
        ResponseStatus code = NONE;
        for(ResponseStatus r : values()) {
            if(r.getStatus() == status)
                code = r;
                break;
        }
        return code;
    }
}

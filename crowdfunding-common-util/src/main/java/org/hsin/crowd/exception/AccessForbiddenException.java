package org.hsin.crowd.exception;

import java.io.Serial;

/**
 * ClassName: AccessForbiddenException
 * Package: org.hsin.crowd.exception
 * Description: 用戶未登入就訪問時要拋出的異常
 *
 * @Author YuHsin Liu
 * @Create 2023/8/15 12:39 PM
 * @Version 1.0
 */
public class AccessForbiddenException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public AccessForbiddenException() {
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    public AccessForbiddenException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

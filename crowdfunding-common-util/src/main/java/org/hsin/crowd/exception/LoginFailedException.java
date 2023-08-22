package org.hsin.crowd.exception;

import java.io.Serial;

/**
 * ClassName: LoginFailedException
 * Package: org.hsin.crowd.exception
 * Description: 登入失敗後拋出的異常
 *
 * @Author YuHsin Liu
 * @Create 2023/8/1 12:24 PM
 * @Version 1.0
 */
public class LoginFailedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public LoginFailedException() {
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package io.github.mikeiansky.sb.web.exception;

/**
 * @author mike ian
 * @date 2025/6/14
 * @desc
 **/
public class BizException extends RuntimeException{

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

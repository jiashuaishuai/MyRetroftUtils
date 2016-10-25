package com.example.administrator.myretroftutils.NetworkRequest;

/**
 * Created by 贾帅帅 on 2016/7/1.
 *
 */
public class RetrofitErrorException extends RuntimeException {
    private String message;
    private String code;

    public RetrofitErrorException(String message, String code) {
        this(message);
        this.code = code;
        this.message = message;

    }

    public RetrofitErrorException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}

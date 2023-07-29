package org.hsin.crowd.util;

/**
 * ClassName: ResultEntity
 * Package: org.hsin.crowd.util
 * Description:
 * 統一整個專案中Ajax請求返回的結果(也可用於分佈式架構中各個模組間調用時返回統一類型)
 * @Author YuHsin Liu
 * @Create 2023/7/26 11:52 AM
 * @Version 1.0
 */
public class ResultEntity<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    //用來封裝當前請求處理的結果是成功還是失敗
    private String result;

    //請求處理失敗時，返回錯誤的訊息
    private String message;

    //要返回的資料
    private T data;

    /**
     * 請求處理成功且不需返回資料
     *
     * @param <E>
     * @return
     */
    public static <E> ResultEntity<E> successWithoutData() {
        return new ResultEntity<>(SUCCESS, null, null);
    }

    /**
     * 請求處理成功且須要返回資料
     *
     * @param data 要返回的資料
     * @param <E>
     * @return
     */
    public static <E> ResultEntity<E> successWithData(E data) {
        return new ResultEntity<>(SUCCESS, null, data);
    }

    /**
     * 請求處理失敗後使用的方法
     *
     * @param message 失敗的錯誤訊息
     * @param <E>
     * @return
     */
    public static <E> ResultEntity<E> failed(String message) {
        return new ResultEntity<>(FAILED, message, null);
    }

    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

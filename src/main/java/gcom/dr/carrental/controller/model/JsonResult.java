package gcom.dr.carrental.controller.model;

public class JsonResult<T> {
    private T data;
    private String message;

    public JsonResult(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}

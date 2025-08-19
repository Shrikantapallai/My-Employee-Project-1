package com.shri.demo.apiResponse;

public class ApiResponse<T> {
 private String message;
 private boolean success;
 private T data;
 
 public ApiResponse() {
	 
 }
public ApiResponse(String message, boolean success, T data) {
	super();
	this.message = message;
	this.success = success;
	this.data = data;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
@Override
public String toString() {
	return "ApiResponse [message=" + message + ", success=" + success + ", data=" + data + "]";
}

 
}

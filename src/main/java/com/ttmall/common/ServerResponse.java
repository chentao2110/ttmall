package com.ttmall.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

//去除json中为空的字段
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {
    private int state;
    private String msg;
    private T data;

    private ServerResponse(int state, String msg, T data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int state, String msg) {

        this.state = state;
        this.msg = msg;
    }

    private ServerResponse(int state, T data) {

        this.state = state;
        this.data = data;
    }

    private ServerResponse(int state) {

        this.state = state;
    }
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(EmResponseCode.SUCCESS.getState());
    }
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(EmResponseCode.SUCCESS.getState(),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(EmResponseCode.SUCCESS.getState(),data);
    }
    public static <T> ServerResponse<T> createBySuccess(T data,String msg){
        return new ServerResponse<T>(EmResponseCode.SUCCESS.getState(),msg,data);

    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<>(EmResponseCode.ERROR.getState(),EmResponseCode.ERROR.getMsg());
    }
    public static <T> ServerResponse<T> createByErrorMessage(String errmsg){
        return  new ServerResponse<>(EmResponseCode.ERROR.getState(),errmsg);
    }
    public static <T> ServerResponse<T> createByErrorMessage(T data,String errmsg){
        return  new ServerResponse<>(EmResponseCode.ERROR.getState(),errmsg,data);
    }
    public static <T> ServerResponse<T> createByErrorMessage(String errmsg,int state) {
        return new ServerResponse<>(state, errmsg);
    }
    //这个注解的意思是不在返回的json中
    @JsonIgnore
    public boolean isSuccess(){
        return this.state == EmResponseCode.SUCCESS.getState();
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}

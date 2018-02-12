package com.asdsoft.app;

/**
 * Created by LENOVO on 12-02-2018.
 */

public class Notify {
    private String event;
    private String info;
    private int code;

    public int getCode() {
        return code;
    }

    public Notify(String event, String info, int code) {
        this.event = event;
        this.info = info;
        this.code = code;

    }

    public String getEvent() {
        return event;
    }

    public String getInfo() {
        return info;
    }
}

package com.asdsoft.app;

/**
 * Created by LENOVO on 12-02-2018.
 */

public class Notify {
    private String event;
    private String info;

    public Notify(String event, String info) {
        this.event = event;
        this.info = info;
    }

    public String getEvent() {
        return event;
    }

    public String getInfo() {
        return info;
    }
}

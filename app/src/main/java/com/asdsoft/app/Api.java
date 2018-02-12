package com.asdsoft.app;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LENOVO on 12-02-2018.
 */

public interface Api {
    String BASE_URL = "https://amey.pythonanywhere.com/";
    //String BASE_URL = "http://192.168.0.115/dashboard/Android/";
    @GET("app")
    Call<List<Notify>> getevent();
}

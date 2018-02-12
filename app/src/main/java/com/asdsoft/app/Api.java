package com.asdsoft.app;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LENOVO on 12-02-2018.
 */

public interface Api {
    String BASE_URL = "https://amey.pythonanywhere.com/";

    @GET("app")
    Call<List<Notify>> getevent();
}

package com.xbrainz.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("posts")
    Call<List<ApiModel>> getData();

}

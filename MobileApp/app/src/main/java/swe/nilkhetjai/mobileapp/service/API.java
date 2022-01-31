package swe.nilkhetjai.mobileapp.service;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API {

    @POST("register")
    Call<ResponseBody> createUser (
            @Body User user
    );

    @POST("login")
    Call<ResponseBody> checkUser (
            @Body User user
    );

    @POST("posts")
    Call<ResponseBody> sendPost (
            @Body Post post
    );

    @GET("posts")
    Call<GetAllPostResponse> getPosts();

}

package swe.nilkhetjai.mobileapp.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import swe.nilkhetjai.mobileapp.model.GetAllPostResponse;
import swe.nilkhetjai.mobileapp.model.Post;
import swe.nilkhetjai.mobileapp.model.User;

public interface API {

    /**
     * Post request for registration
     * @param user
     * @return
     */

    @POST("register")
    Call<ResponseBody> createUser (
            @Body User user
    );

    /**
     * Post request for login
     * @param user
     * @return
     */

    @POST("login")
    Call<ResponseBody> checkUser (
            @Body User user
    );

    /**
     *  Post request for send a post
     * @param post
     * @return
     */

    @POST("posts")
    Call<ResponseBody> sendPost (
            @Body Post post
    );

    /**
     * Post request for get all post
     * @return
     */

    @GET("posts")
    Call<GetAllPostResponse> getPosts();

}

package org.isa.bengreenmobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MonApi {

    @GET("rubrique/read_parents")
    Call<List<Rubrique>> getParents();

    @GET("product/read")
    Call<List<Product>> listAllProducts();

    @GET("rubrique/read_kids_of")
    Call<List<Rubrique>> getKidsOf(@Query("parent_id") int parent_id);


// For POST request
//
//    @FormUrlEncoded    // annotation that used with POST type request
//    @POST("/demo/login.php") // specify the sub url for our base url
//    public void login(
//            @Field("user_email") String user_email,
//            @Field("user_pass") String user_pass, Callback<SignUpResponse> callback);
//
//user_email and user_pass are the post parameters and SignUpResponse is a POJO class which recieves the response of this API


}

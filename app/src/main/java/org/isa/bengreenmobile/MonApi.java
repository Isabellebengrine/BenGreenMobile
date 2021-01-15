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
}

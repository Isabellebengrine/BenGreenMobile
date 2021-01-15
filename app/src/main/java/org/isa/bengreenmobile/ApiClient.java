package org.isa.bengreenmobile;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/apiVillageGreen/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

    public static MonApi getInterface(){
        MonApi monApiInterface = getRetrofit().create(MonApi.class);
        return monApiInterface;
    }

}

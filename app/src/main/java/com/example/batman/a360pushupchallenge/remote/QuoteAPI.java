package com.example.batman.a360pushupchallenge.remote;

import com.example.batman.a360pushupchallenge.model.PushupQuote;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface QuoteAPI {

    String BASE_URL = "https://quarkbackend.com/getfile/";

    @GET("vimalchaunkaria/fitness")
    Call<List<PushupQuote>> getPushup();

    class Factory {
        static QuoteAPI service;

        public static QuoteAPI getInstance() {

            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                service = retrofit.create(QuoteAPI.class);
                return service;
            } else {

                return service;
            }
        }
    }
}
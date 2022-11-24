package com.if5b.tulisaja.services;

import com.if5b.tulisaja.models.ValueNoData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("loginUser")
    @FormUrlEncoded
    Call<ValueNoData> login(@Field("key") String key,
                            @Field("username") String username,
                            @Field("password") String password);

    @POST("registerUser")
    @FormUrlEncoded
    Call<ValueNoData> register(@Field("key") String key,
                               @Field("username") String username,
                               @Field("password") String password);

    @POST("getAlPost")
    @FormUrlEncoded
    Call<ValueNoData> getPost(@Field("key") String key);

    @POST("insertPost")
    @FormUrlEncoded
    Call<ValueNoData> insertPost(@Field("key") String key,
                               @Field("username") String username,
                               @Field("content") String content);


    @POST("updatePost")
    @FormUrlEncoded
    Call<ValueNoData> updatePost(@Field("key") String key,
                                 @Field("id") int id,
                                 @Field("content") String content);

    @POST("deletePost")
    @FormUrlEncoded
    Call<ValueNoData> deletePost(@Field("key") String key,
                                 @Field("id") int id);
}


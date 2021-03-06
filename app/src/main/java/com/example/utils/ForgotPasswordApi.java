package com.example.utils;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by noiz354 on 3/16/16.
 */
public interface ForgotPasswordApi {
    @FormUrlEncoded
    @POST("/v4/action/general-usage/reset_password.pl")
    Observable<ForgotPasswordData> createForgotPassword(@Field("user_id") String userId,
                                                        @Field("device_id") String deviceId,
                                                        @Field("hash") String hash,
                                                        @Field("device_time") String deviceTime,
                                                        @Field("email") String email);
}

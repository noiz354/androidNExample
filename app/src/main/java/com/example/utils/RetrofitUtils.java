package com.example.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by noiz354 on 3/16/16.
 */
public class RetrofitUtils {
    public static final String NETWORK_FORBIDDEN_ERROR = "silahkan login kembali";
    public static final String NETWORK_TIMEOUT_ERROR = "Network Timeout Error!";

    public static Retrofit createRetrofit(String url){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Add the interceptor to OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();
//        client.interceptors().add(logging);

        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    public static boolean isTimeout(String errorMessage){
        return errorMessage.equals(NETWORK_TIMEOUT_ERROR);
    }

    public static boolean isSessionInvalid(String errorMessage){
        return errorMessage.contains(NETWORK_FORBIDDEN_ERROR);
    }

    public static boolean isConnected(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}

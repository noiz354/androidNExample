package com.example.noiz354.androidnapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utils.ForgotPasswordApi;
import com.example.utils.ForgotPasswordData;
import com.example.utils.RetrofitUtils;

import java.util.Random;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button)).setOnClickListener(
                (View view) -> {
                    Toast.makeText(MainActivity.this, "mencoba login", Toast.LENGTH_LONG).show();
                    Observable.just(true).map(b -> b+"").subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .unsubscribeOn(Schedulers.io()).subscribe((i ->
                        Log.d("MNORMANSYAH", "hallo sini "+i)));

                    Observable.just(true)
                            .flatMap(c -> {
                                return resetEmail();
                            })
                    .flatMap((b) -> {
                        if((new Random().nextInt(1000)%2==1)){
                            return Observable.just(b);
                        }
                        return null;
                    } ).subscribe(i -> {
                        ((TextView)MainActivity.this.findViewById(R.id.textView)).setText(
                                i.getForgotPasswordModel().toString()
                        );
                    });
                }
        );
    }

    private Observable<ForgotPasswordData>  resetEmail(){
        return RetrofitUtils.createRetrofit("https://ws.tokopedia.com")
                .create(ForgotPasswordApi.class).createForgotPassword(
                "",
                "",
                "",
                "",
                ""
        );
    }
}

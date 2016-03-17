package com.example.noiz354.androidnapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interfaces.HaloLambda;
import com.example.utils.ForgotPasswordApi;
import com.example.utils.ForgotPasswordData;
import com.example.utils.RetrofitUtils;

import java.util.Random;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * lambda expression :
 * interface dengan banyak default + static dengan single abstract method.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.button)).setOnClickListener(
                (View view) -> {
                    Toast.makeText(MainActivity.this, "mencoba login", Toast.LENGTH_LONG).show();
//                    Observable.just(true).map(b -> b+"").subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .unsubscribeOn(Schedulers.io()).subscribe((i ->
//                        Log.d("MNORMANSYAH", "hallo sini "+i)));

                    Observable.just(true)
                            .flatMap(c ->
                                resetEmail()
                            )
//                    resetEmail()// uncomment this, retrofit is failed for this rate
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .unsubscribeOn(Schedulers.io())
                            .subscribe(
                                i ->
                                ((TextView)MainActivity.this.findViewById(R.id.textView)).setText(
                                        i.getForgotPasswordModel().toString()
                                ),
                                error -> Log.e("MNORMANSYAH", error.getLocalizedMessage()),
                                () -> Log.d("MNORMANSYAH", "selesai compile !!")
                            );
                }
        );

        HaloLambda<Boolean> test = b -> {
            if(b){
                Log.d("MNORMANSYAH", "Mantap Gan !! "+MainActivity.class.getSimpleName());
            }
            return null;
        };

        justLogWithLambda(
                b -> {
                    if(b){
                        Log.d("MNORMANSYAH", "Mantap Gan !! "+MainActivity.class.getSimpleName());
                    }
                    return null;
                }
        );
    }

    private void justLogWithLambda(HaloLambda<Boolean> haloLambda){
        haloLambda.print(true);
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

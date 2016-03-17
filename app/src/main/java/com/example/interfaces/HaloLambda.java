package com.example.interfaces;

import android.util.Log;

/**
 * Created by noiz354 on 3/17/16.
 */
public interface HaloLambda<T> {
    String print(T data);

    default String getMessageTAGDef(){
        return getMessageTAG()+"_1";
    }

    static String getMessageTAG(){
        return "HaloLambda";
    }

    static void siniBelajarLagi(boolean test){
        if(test){
            Log.d(getMessageTAG(), getMessageTAG());
        }
    }
}

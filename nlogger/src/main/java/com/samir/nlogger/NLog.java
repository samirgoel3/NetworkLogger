package com.samir.nlogger;

import android.util.Log;

public class NLog {


    public static void d(String tag , String message){
        if(NLogger.mBuilder.IS_ENABLE){
            Log.d(tag,message);
        }
        saveToDb(tag, message);
    }

    public static void e(String tag , String message){
        if(NLogger.mBuilder.IS_ENABLE){
            Log.e(tag,message);
        }
    }

    public static void w(String tag , String message){
        if(NLogger.mBuilder.IS_ENABLE){
            Log.w(tag,message);
        }
    }

    public static void i(String tag , String message){
        if(NLogger.mBuilder.IS_ENABLE){
            Log.i(tag,message);
        }
    }

    public static void v(String tag , String message){
        if(NLogger.mBuilder.IS_ENABLE){
            Log.v(tag,message);
        }
    }



    private static void saveToDb(String tag , String message){
        DatabaseManager.insertLog(tag , message);
    }

}

package com.example.lkwan.simpleadabter;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferencesUtils {
    private static SharedPreferences sp;

    public  static void saveBoolean(Context context , String key , Boolean value){


        if(sp==null){
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);



        }
        sp.edit().putBoolean(key, value).commit();


    }
    public static Boolean getBoolean(Context context , String key , Boolean deaVlue){
        if(sp==null){
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);



        }
        return sp.getBoolean(key, deaVlue);

    }
    public  static void saveString(Context context , String key , String value){


        if(sp==null){
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);



        }
        sp.edit().putString(key, value).commit();


    }
    public static String getString(Context context , String key , String deaVlue){
        if(sp==null){
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);



        }
        return sp.getString(key, deaVlue);

    }

    public  static void saveInt(Context context , String key , int value){


        if(sp==null){
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);



        }
        sp.edit().putInt(key, value).commit();


    }
    public static int getInt(Context context , String key , int deaVlue){
        if(sp==null)
            sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);




        return sp.getInt(key, deaVlue);





}
}

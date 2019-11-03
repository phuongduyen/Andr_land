package com.example.test1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

public class SaveData {

    private final String SHARED_PREFERENCES_NAME ="thangcoder";
    private final String MY_NAME ="my_name";
    private final String AGE ="age";
    private final String IS_SINGLE ="is_single";
    private final String WEIGHT = "weight";

    Context context;

    SaveData(Context context) {
        this.context = context;
    }

    public void addData(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MY_NAME,"Truong Dinh Chien");
        editor.putInt(AGE,25);
        editor.putBoolean(IS_SINGLE,false);
        editor.putLong(WEIGHT,60);

        editor.apply();
        Toast.makeText(context, "Save Successfully", Toast.LENGTH_SHORT).show();
        //editor.commit();

    }
    public void readData(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(MY_NAME,"Cheng");
        int age = sharedPreferences.getInt(AGE,20);
        boolean isSingle = sharedPreferences.getBoolean(IS_SINGLE,false);
        long weight = sharedPreferences.getLong(WEIGHT,0);
        String address = sharedPreferences.getString("ADDRESS","Ho Chi Minh");

        Log.d("sss", "Thangcoder: "
                +"Name: "+name +"\n"
                +"Age:" +age +"\n"
                +"Single: "+isSingle +"\n"
                + "Weight: "+weight +"\n"
                +"Address: "+address);
    }
    public void removeByKey(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(key);
        editor.apply();
    }
    public void removeAll(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

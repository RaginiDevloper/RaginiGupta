package com;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePerference {
    private Context context;                        //context means address
    private SharedPreferences.Editor editor;        //when update or edit
    public final String MY_PRESS_NAME="myPrefrene";
    private SharedPreferences prefs;

public SharePerference(Context context) {
        this.context = context;
        this.editor = context.getSharedPreferences(MY_PRESS_NAME,context.MODE_PRIVATE).edit(); // To Put data
        this.prefs = context.getSharedPreferences(MY_PRESS_NAME,context.MODE_PRIVATE);        // TO GET Data
    }
 public String putPreferenceValues(String key, String value){
        editor.putString(key, value);
        editor.commit();
        return key;
    }
    public String putPreferenceValue(String key, int value){
    editor.putInt(key,value);
    editor.commit();
    return key;
    }

    public String getPreferenceValue(String key){
        return prefs.getString(key,"");
    }
     public int getPreferenceValues1(String key){
         int ans = prefs.getInt(key, 0);
         return ans;
    }


    public void clearSharePrefrence(){
        prefs.edit().clear().apply();               // to clear the prefrence
    }


}

package com.redshift.jcmobile;

import android.widget.EditText;

import androidx.annotation.NonNull;

public class Util {
    protected final static String TAG = MainActivity.class.getSimpleName();
    public static float getFloat(@NonNull EditText text, float defaultValue) {
        String input = text.getText().toString();
        if (input.equals("")) return defaultValue;

        //if (!input.contains(".")) input += ".f";
        return Float.parseFloat(input);
    }

    public static String getString(@NonNull EditText text) {
        return text.getText().toString();
    }

    public static int getInt(@NonNull EditText text) {
        String input = text.getText().toString();
        if (input.equals("")) input = "0";
        return Integer.parseInt(input);
    }

//    public static void loadTestValues () {
//        EditText editText = new EditText().setText(MainActivity.);
//    }
}

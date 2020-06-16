package com.redshift.jcmobile;

import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

public class Util {

    public static float getFloat(@NotNull EditText text, float defaultValue) {
        String input = text.getText().toString();
        if (input.equals("")) return defaultValue;

        //if (!input.contains(".")) input += ".f";
        return Float.parseFloat(input);
    }

    public static String getString(@NotNull EditText text) {
        return text.getText().toString();
    }

    public static int getInt(@NotNull EditText text) {
        String input = text.getText().toString();
        if (input.equals("")) input = "0";
        return Integer.parseInt(input);
    }

//    public static void loadTestValues () {
//        EditText editText = new EditText().setText(MainActivity.);
//    }
}

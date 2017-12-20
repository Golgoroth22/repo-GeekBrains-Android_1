package ru.valentin.falinv22.taskone;


import android.app.Activity;
import android.content.res.Resources;

public class ColorSpec {
    String getEffect(String color, Activity activity) {
        Resources resources = activity.getResources();
        String result = "";
        if (color.equals("Red")) {
            result = resources.getString(R.string.red_info);
        }
        if (color.equals("Black")) {
            result = resources.getString(R.string.black_info);
        }
        if (color.equals("Green")) {
            result = resources.getString(R.string.green_info);
        }
        if (color.equals("White")) {
            result = resources.getString(R.string.white_info);
        }
        if (color.equals("Yellow")) {
            result = resources.getString(R.string.yellow_info);
        }
        return result;
    }
}

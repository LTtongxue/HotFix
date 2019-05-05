package org.cocos2dx.cpp;

import android.os.Bundle;
import android.util.Log;

import org.cocos2dx.lib.Cocos2dxActivity;

public class AppActivity extends Cocos2dxActivity {
    private static final String TAG = "AppActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String t_value = "4";
        for (int i = 1; i < 30; i++) {
            if (i < 10)
                t_value += ",1";
            else if (i < 20) {
                t_value += ",1";
            } else if (i == 20) {
                t_value += ",1";
            } else {
                t_value += ",1";
            }
        }
        setGameData(t_value);
        Log.d(TAG, "status == " + t_value);
        setGameId(3);
    }

    public static void onRequest(final String usrid, final String gameid, final String gateid, final int score, String other) {
        Log.d(TAG, "onRequest() called with: usrid = [" + usrid + "], gameid = [" + gameid + "]," +
                " gateid = [" + gateid + "], score = [" + score + "], other = [" + other + "]");
    }

    public static native void setGameData(String response);

    public static native void onResponse(String response);

    public static native void setGameId(int gameid);
}
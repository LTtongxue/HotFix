package com.hengda.tinker.gradle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

public class TinkerActivity extends AppCompatActivity {
    private static final String TAG = "TinkerActivity";
    private static final String FILE_END = ".apk";//文件后缀
    private String mPathDir;//文件路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinker_gradle);
//        /storage/emulated/0/Android/data/com.hengda.tinker.gradle/cache/tpatch/tinker.apk
        mPathDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        Log.d(TAG, "onCreate: mPathDir == " + mPathDir);
        //创建路径对应的文件夹
        File file = new File(mPathDir);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public void loadPatch(View view) {
        TinkerManager.loadPatch(getPatchName());
    }

    public String getPatchName() {
        return mPathDir.concat("tinker").concat(FILE_END);
    }
}

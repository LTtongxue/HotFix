package com.hengda.andfix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

public class AndFixActivity extends AppCompatActivity {
    private static final String TAG = "AndFixActivity";
    private static final String FILE_END = ".apatch";
    private String mPathDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andfix);
//        /storage/emulated/0/Android/data/com.hengda.andfix/cache/apatch/andfix.apatch
        mPathDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        Log.d(TAG, "onCreate: mPathDir == " + mPathDir);
        //创建文件夹
        File file = new File(mPathDir);
        if (!file.exists()) {
            file.mkdir();
        }

    }

    public void createBug(View view) {
//        Utils.show(this, "产生bug啦！");
        Utils.show(this, "bug修复啦！");
    }

    public void fixBug(View view) {
        AndFixPatchManager.getInstance().addPatch(getPatchName());
    }

    //加载修复文件的文件名
    public String getPatchName() {
        return mPathDir.concat("andfix").concat(FILE_END);
    }
}

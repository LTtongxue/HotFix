package com.hengda.andfix;

import android.app.Application;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //完成andFix模块的初始化
        initAndFix();
    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initPatch(this);
    }
}

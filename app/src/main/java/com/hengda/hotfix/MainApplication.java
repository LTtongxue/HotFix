package com.hengda.hotfix;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void testLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}

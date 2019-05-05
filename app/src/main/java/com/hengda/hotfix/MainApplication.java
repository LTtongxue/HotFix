package com.hengda.hotfix;

import android.app.Application;

import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.squareup.leakcanary.LeakCanary;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BlockCanary.install(this, new BlockCanaryContext()).start();
    }

    private void testLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}

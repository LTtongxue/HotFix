package com.hengda.hotfix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.cocos2dx.cpp.AppActivity;
import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void testOkHttp() {
        //异步
        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        okhttp3.Call call = okHttpClient.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {

            }
        });

        try {
            okhttp3.Response response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jumpGame(View view) {
        Intent intent = new Intent(this, AppActivity.class);
        startActivity(intent);
    }

    public interface DataService {
        @GET
        Call<String> baidu(@Url String url);
    }

    private void testRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com/")
                .client(new OkHttpClient())
                .build();
        DataService dataService = retrofit.create(DataService.class);
        retrofit2.Call<String> call = dataService.baidu("");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(retrofit2.Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(retrofit2.Call<String> call, Throwable t) {

            }
        });

        try {
            Response<String> response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testGlide() {
        String url = "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg";
        Glide.with(this).load(url).into(new ImageView(this));
    }

    private void testEventBus() {
        EventBus.getDefault().register(this);
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().post("");
    }
}

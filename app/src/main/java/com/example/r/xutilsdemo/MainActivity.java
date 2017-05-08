package com.example.r.xutilsdemo;

import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.btn_get)
    Button btn;
    @ViewInject(R.id.image)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        x.view().inject(this);
    }
    @Event(value = {R.id.btn_get,R.id.btn_post,R.id.btn_image,R.id.btn_up,R.id.btn_download})
    private void btnOnclick(View view){
        switch (view.getId()){
            case R.id.btn_get:
                get();
                break;
            case R.id.btn_post:
                post();
                break;
            case R.id.btn_image:
                showImage();
                break;
            case R.id.btn_up:
                upLoad();
                break;
            case R.id.btn_download:
                downLoad();
                break;
        }
    }

    private void downLoad() {
        String path = "http://gdown.baidu.com/data/wisegame/25b7c41e8863fd92/QQ_676.apk";
        RequestParams requestParams = new RequestParams(path);
        x.http().get(requestParams, new Callback.CommonCallback<File>() {
            @Override
            public void onSuccess(File result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void upLoad() {
    }

    private void showImage() {
        x.image().bind(imageView,"http://www.qqpk.cn/Article/UploadFiles/200901/20090119002708851.jpg");
    }

    private void post() {
        RequestParams requestParams = new RequestParams("http://qhb.2dyt.com/Bwei/login");
        requestParams.addBodyParameter("postkey","bwei");
        requestParams.addBodyParameter("username","18511098888");
        requestParams.addBodyParameter("password","11111");
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void get() {
        RequestParams requestParams = new RequestParams("http://qhb.2dyt.com/Bwei/login");
        requestParams.addBodyParameter("postkey","bwei");
        requestParams.addBodyParameter("username","18511098888");
        requestParams.addBodyParameter("password","11111");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}

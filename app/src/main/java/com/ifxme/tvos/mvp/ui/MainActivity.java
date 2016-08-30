package com.ifxme.tvos.mvp.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.presenter.MainPresenter;
import com.ifxme.tvos.mvp.presenter.impl.MainPresenterImpl;
import com.ifxme.tvos.mvp.ui.view.MainView;
import com.orhanobut.logger.Logger;


public class MainActivity extends AppCompatActivity implements MainView {


    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter = new MainPresenterImpl(this);
        mMainPresenter.getIpInfo();

        Uri uri = Uri.parse("https://www.baidu.com/img/2016_8_22bimushi_cddc674c4d103d98d2450f174b543628.gif");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
//        draweeView.setImageURI(uri);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                // 其他设置（如果有的话）
                .build();
        draweeView.setController(controller);

    }

    @Override
    public void showProgress() {
        Logger.d("MainActivity", "showProgress");
    }

    @Override
    public void hideProgress() {
        Logger.d("MainActivity", "hideProgress");
    }

    @Override
    public String getUserId() {
        return "1";
    }

    @Override
    public void showData(String data) {
        Logger.d("MainActivity", "data:" + data);
    }


}

package com.ifxme.tvos.mvp.ui.activity;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.presenter.UserPresenter;
import com.ifxme.tvos.mvp.presenter.impl.UserPresenterImpl;
import com.ifxme.tvos.mvp.ui.view.UserView;
import com.orhanobut.logger.Logger;


public class MainActivity extends BaseActivity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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




}

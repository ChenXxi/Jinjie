package com.example.day2zy;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView image_view;
    private Button round;
    private Button circle;
    private Button ratio;
    private Button loadgif;
    private Uri staticuri;
    private Uri gifuri;
    private GenericDraweeHierarchyBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_view = findViewById(R.id.my_image_view);
        image_view.setAspectRatio(1f);

        round = findViewById(R.id.round);
        circle = findViewById(R.id.circle);
        ratio = findViewById(R.id.ratio);
        loadgif = findViewById(R.id.loadgif);

        round.setOnClickListener(this);
        circle.setOnClickListener(this);
        ratio.setOnClickListener(this);
        loadgif.setOnClickListener(this);

        staticuri = Uri.parse("http://www.zhaoapi.cn/images/quarter/ad1.png");
        gifuri = Uri.parse("http://www.zhaoapi.cn/images/girl.gif");


        //创建对象
        builder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.round:
                    round();
                    break;
                case R.id.circle:
                    circle();
                    break;
                case R.id.ratio:
                    ratio();
                    break;
                case R.id.loadgif:
                    loadgif();
                    break;
            }
    }

    //加载动图
    private void loadgif() {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(gifuri)//设置地址
                .setAutoPlayAnimations(true)//是否播放
                .build();
        image_view.setController(controller);
    }

    //比例
    private void ratio() {
        image_view.setAspectRatio(2.71f);
    }

    //圆角
    private void circle() {
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(20);
        GenericDraweeHierarchy hierarchy = builder.setRoundingParams(roundingParams).build();
        image_view.setHierarchy(hierarchy);
        image_view.setImageURI(staticuri);
    }

    //圆形
    private void round() {
        //设置为圆形
        RoundingParams roundingParams = RoundingParams.asCircle();
        //设置参数
        GenericDraweeHierarchy hierarchy = builder.setRoundingParams(roundingParams).build();
        //将参数设置给图片
        image_view.setHierarchy(hierarchy);
        //控件加载图片
        image_view.setImageURI(staticuri);
    }
}

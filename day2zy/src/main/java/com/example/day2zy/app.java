package com.example.day2zy;

import android.app.Application;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DiskCacheConfig diskCacheConfig=DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("Day2zyCache")
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(this,config);
    }
}

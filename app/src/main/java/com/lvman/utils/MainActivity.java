package com.lvman.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lvman.uamautil.devicetype.StorageUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ailee", "Package:"+ StorageUtils.createFilePackage(StorageUtils.getSDCardRootPath()+File.separator+"gujiajia"));

    }
}

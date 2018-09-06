package com.lvman.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lvman.uamautil.devicetype.DeviceUtils;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ailee", DeviceUtils.getDeviceId(this));
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ailee","isNetWork:"+ DeviceUtils.isNetworkAvailable(MainActivity.this));
            }
        });
    }
}

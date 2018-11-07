package com.lvman.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lvman.uamautil.devicetype.DeviceUtils;
import com.lvman.uamautil.listener.SuccessListener;
import com.lvman.uamautil.permission.PermissionUtils;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_id);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionUtils.checkPhoneStatePermission(MainActivity.this, "", new SuccessListener() {
                    @Override
                    public void success() {
                        textView.setText("UniqueId: ".concat(DeviceUtils.getDeviceUniqueId(MainActivity.this)));
                    }
                });
            }
        });
    }
}

package com.example.test1;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    OrientationEventListener myOrientationEventListener;
    TextView tvHuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvHuong = findViewById(R.id.tv_huong);

        myOrientationEventListener =
                new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL) {
                    @Override
                    public void onOrientationChanged(int i) {


                        Display display =
                                ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
                                        .getDefaultDisplay();

                        switch (display.getRotation()) {
                            case Surface.ROTATION_0:
                                tvHuong.setText("Màn hình LAYOUT đứng: 0°");
                                break;

                            case Surface.ROTATION_90:
                                tvHuong.setText("Màn hình LAYOUT ngang: 90°");
                                break;

                            case Surface.ROTATION_180:
                                tvHuong.setText("Màn hình LAYOUT ngang: 180°");
                                break;

                            case Surface.ROTATION_270:
                                tvHuong.setText("Màn hình LAYOUT đứng: 270°");
                                break;
                        }
                    }

                };
        myOrientationEventListener.enable();
    }
}

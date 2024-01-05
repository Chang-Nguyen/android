package com.trangduc.fatbooks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.trangduc.fatbooks.R;

public class RunActivity extends AppCompatActivity {

    private static final long DELAY_TIME = 1500;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        // Tạo một Runnable để chuyển đổi sang màn hình khác sau khi 5 giây
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Chuyển đổi sang màn hình khác ở đây (ví dụ: MainActivity)
                startActivity(new Intent(RunActivity.this, MainActivity.class));
                finish(); // Kết thúc hoạt động hiện tại sau khi chuyển đổi
            }
        };

        // Sử dụng Handler để đặt thời gian trễ và chạy Runnable
        handler.postDelayed(runnable, DELAY_TIME);
    }
}


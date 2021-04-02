package com.study.appex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.Exchanger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 설정된 내용을 로딩
        setContentView(R.layout.activity_main);
    }

    // 버튼 클릭 시 수행하는 메소드
    public void mOnclick(View v){
        // Intent 객체를 통해 Activity 이동 및 정보를 보관하여 전달하는 역할
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn1:
                intent = new Intent(this, ImageViewDemo.class);
                break;
            case R.id.btn2:
                intent = new Intent(this, exchange.class);
        }
        startActivity(intent);
    }
}
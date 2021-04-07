package com.study.appex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 레이아웃 정의 : R-> 앱 Resource(안드로이드에서 사용되는 자원)
        setContentView(R.layout.activity_main);
    }

    // 실제 클릭 이벤트가 발생한 요소(view) 를 인자로 전달 받음
    public void mOnClick(View v){
        Log.d("id", "이벤트 발생시 뷰 구분 : "+String.valueOf(v.getId()));

        // 다른 액티비티 전환 : Intent객체를 사용
        Intent intent = null;

        switch (v.getId()){
            case R.id.btn1:
                break;
            case R.id.btn2:
                intent = new Intent(this, exchange.class);
                break;
            case R.id.btn3:
                intent = new Intent(this, BmiActivity.class);
                break;
            case R.id.btn4:
                intent = new Intent(this, CheckBoxDemo.class);
                break;
        }

        startActivity(intent);


    }

}
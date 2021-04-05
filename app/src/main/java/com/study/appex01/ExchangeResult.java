package com.study.appex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ExchangeResult extends AppCompatActivity {

    TextView txtResult;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_result);
        
        // 위젯과 전역변수 연결
        txtResult = (TextView)findViewById(R.id.viewResult);
        
        // 넘어온 인자 값을 처리
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        txtResult.setText(result);

    }
}
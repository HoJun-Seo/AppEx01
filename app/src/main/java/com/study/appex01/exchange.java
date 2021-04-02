package com.study.appex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class exchange extends AppCompatActivity {

    // 화면에서 생성된 위젯의 값을 받기위한 위젯 지역변수
    EditText doller;
    Button btnCalc;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        doller = (EditText)findViewById(R.id.doller);
        btnCalc = (Button)findViewById(R.id.calc);
        txtResult = (TextView)findViewById(R.id.txtResult);
        
        // 이벤트 처리
        btnCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (doller.getText().toString().equals("")) {
                    Toast.makeText(exchange.this, "숫자를 입력하세요", Toast.LENGTH_LONG).show();
                    return;
                }

                int intDoller = Integer.parseInt(doller.getText().toString());
                int money = intDoller*1200;
                txtResult.setText(intDoller+"달러="+money+"원 입니다.");

            }
        });
    }
}
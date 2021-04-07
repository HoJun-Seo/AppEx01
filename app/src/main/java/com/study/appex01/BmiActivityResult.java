package com.study.appex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BmiActivityResult extends AppCompatActivity {

    TextView txtBmiResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        txtBmiResult = (TextView) findViewById(R.id.txtResult);

        // 1. 넘어온 인값을 개별 처리: getIntent()
        Intent intent = getIntent();
//        String result = intent.getStringExtra("result");
//        String name = intent.getStringExtra("name");
//        int age = intent.getIntExtra("age",0);
//        double height = intent.getDoubleExtra("height",0);
//        double weight = intent.getDoubleExtra("weight",0);
//        String bmi = intent.getStringExtra("bmi");

        // 2. 객체 단위로 처리(Serializable)
        BmiDTO dto = (BmiDTO) getIntent().getSerializableExtra("dto");
        String result = dto.getResult();
        String name = dto.getName();
        int age = dto.getAge();
        double height = dto.getHeight();
        double weight = dto.getWeight();
        String bmi = dto.getBmi();

        // 표시할 결과 값
        result = "이름 : "+name+"\n"+
                "나이 : "+age+"\n"+
                "신장 : "+height+"\n"+
                "체중 : "+weight+"\n"+
                "BMI 수치 : "+bmi+"\n"+
                "결과 : "+result+"\n";
        txtBmiResult.setText(result);
    }
}
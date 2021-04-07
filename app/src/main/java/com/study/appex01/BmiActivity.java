package com.study.appex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {

    // 위젯 전역변수
    EditText editName, editAge, editHeight, editWeight;
    TextView txtResult;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_activity);

        //  뷰요소와 변수와 연결하기
        editName = (EditText) findViewById(R.id.editName);
        editAge = (EditText) findViewById(R.id.editAge);
        editHeight = (EditText) findViewById(R.id.editHeight);
        editWeight = (EditText) findViewById(R.id.editWeight);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnCalc  = (Button) findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double kg = Double.parseDouble(editWeight.getText().toString());
                double height = Double.parseDouble(editHeight.getText().toString())/100;
                double bmi = kg / (height*height);

                String result = "";
                if (bmi < 18.5) {
                    result = "저체중";
                } else if (bmi >=18.5 && bmi < 23){
                    result = "정상";
                } else if (bmi >= 23 && bmi<25){
                    result = "과체중";
                } else if (bmi >= 25 && bmi < 30){
                    result = "비만";
                } else if (bmi >=30) {
                    result = "고도비만";
                }

                DecimalFormat df = new DecimalFormat("##0.000");
                String bmiResult = "BMI 측정 결과 : "+df.format(bmi)+"\n";
                String sendResult = result;

                result += editName.getText().toString()+"님의 체중은 "+result+" 입니다.\n";
                txtResult.setText(result);



                // 결과값을 다른 액티비티에 전송하여 출력 할 경우 : 전달될 값이 많을 경우 DTO(VO)을 활용
                // 1. 전달하고자 하는 값을 intent객체 저장
                Intent intent = new Intent(BmiActivity.this, BmiActivityResult.class);
//                intent.putExtra("name", editName.getText().toString());
//                intent.putExtra("age",Integer.parseInt(editAge.getText().toString()));
//                intent.putExtra("height",Double.parseDouble(editAge.getText().toString()));
//                intent.putExtra("weight",Double.parseDouble(editWeight.getText().toString()));
//                intent.putExtra("bmi",df.format(bmi));
//                intent.putExtra("result",result);



                BmiDTO dto = new BmiDTO();

                dto.setName(editName.getText().toString());
                dto.setAge(Integer.parseInt(editAge.getText().toString()));
                dto.setHeight(Double.parseDouble(editAge.getText().toString()));
                dto.setWeight(Double.parseDouble(editWeight.getText().toString()));
                dto.setBmi(bmiResult);
                dto.setResult(sendResult);

                intent.putExtra("dto", dto);

                startActivity(intent);
            }
        });

    }
}
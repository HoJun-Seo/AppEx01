package com.study.appex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class YutActivity extends AppCompatActivity {

    // 위젯 전역 변수: 평평한면 : 0(yut_0), 두근면:1(yut_1) => 4개모두 0면 윷, 1이면 모
    int[] imgYut = {R.drawable.yut_0, R.drawable.yut_1};
    String [] strYut = {"윷","개","걸","도","모"};
    Button btn1;
    ImageView img1, img2, img3, img4;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yut);

        btn1 = (Button) findViewById(R.id.btn1);
        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        img4 = (ImageView)findViewById(R.id.img4);
        txtResult = (TextView) findViewById(R.id.txtResult);

        // 이벤트 처리
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //랜덤으로 윷의 앞뒤면 설정
                Random rand = new Random();
                // 난수 발생 0~1
                int n1 = rand.nextInt(2);
                int n2 = rand.nextInt(2);
                int n3 = rand.nextInt(2);
                int n4 = rand.nextInt(2);
                int sum = n1 + n2 + n3 + n4;

                // 결과출력
                img1.setImageResource(imgYut[n1]);
                img2.setImageResource(imgYut[n2]);
                img3.setImageResource(imgYut[n3]);
                img4.setImageResource(imgYut[n4]);

                txtResult.setText(strYut[sum]);
            }
        });


    }
}
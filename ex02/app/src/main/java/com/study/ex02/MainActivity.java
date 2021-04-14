package com.study.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId() ){
            case R.id.btn1:
                intent = new Intent(this, ListDemo1.class);
                break;
//            case R.id.btn2:
//                intent = new Intent(this, ListDemo2.class);
//                break;
//            case R.id.btn3:
//                intent =new Intent(this, ListXml.class);
//                break;
            case R.id.btn4:
                intent = new Intent(this,  GridViewActivity.class);
                break;
            case R.id.btn5:
                intent = new Intent(this, SpinnerActivity.class);
                break;
            case R.id.btn6:
                intent = new Intent(this, ArrayListActivity.class);
                break;
        }
        // 액티비티 연결(실행)
        startActivity(intent);

    }
}
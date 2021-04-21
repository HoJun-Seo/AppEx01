package com.study.ex04_file;

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

    public void onClick(View v){
        Intent intent = null;
        switch (v.getId()){
            case R.id.btnXML:
                intent = new Intent(this,ResourceActivity.class);
                break;
            case R.id.btnInternal:
                intent = new Intent(this, ReadWriteActivity.class);
                break;
            case R.id.btnExternal:
                intent = new Intent();
                break;

        }
    }
}
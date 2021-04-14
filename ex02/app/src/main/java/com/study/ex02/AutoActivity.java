package com.study.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoActivity extends AppCompatActivity {

    TextView txtResult;
    AutoCompleteTextView auto1;

    String[] items ={
            "java","java1","java2", "javascript", "c", "c++", "c/c++", "android", "apple", "IOS"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_view);
    }
}
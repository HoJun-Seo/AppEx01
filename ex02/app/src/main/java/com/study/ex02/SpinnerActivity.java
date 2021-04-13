package com.study.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {

    TextView txtResult;
    Spinner spinner1;
    String[] arr = {"스마트폰","TV","스피커","태블릿","모니터", "본체"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        // 뷰 바인딩
        txtResult = (TextView) findViewById(R.id.txtResult);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

        // 데이터 바인딩
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        spinner1.setAdapter(adapter);

        // 이벤트 처리
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sel = txtResult.getText().toString();
                txtResult.setText(sel+arr[i]+"\n");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
package com.study.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.nio.file.Files;

public class GridViewActivity extends AppCompatActivity {

    // 윗젯 전역변수
    TextView txtResult;
    GridView grid1;

    String[] items = {
            "사과","포도","바나나","자두","귤","자몽",
            "사과","포도","바나나","자두","귤","자몽",
            "사과","포도","바나나","자두","귤","자몽",
            "사과","포도","바나나","자두","귤","자몽"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        // 뷰와 위젯변수 연결(바인딩)
        txtResult = (TextView)findViewById(R.id.txtResult);
        grid1 = (GridView) findViewById(R.id.grid1);

        // 데이터 바인딩 하는 과정 : 1. 아답터를 생성(문자열을 TextView로 연결) 2. 아답터를 GridView 연결(바인딩)
        ArrayAdapter adapter = new ArrayAdapter(this,  android.R.layout.simple_list_item_1,  items);
        grid1.setAdapter(adapter);

        // 이벤트 처리
        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("GridView","GridView Item selected index : "+i);
                Log.i("GridView", "items["+i+"]: "+items[i]);

                txtResult.setText( items[i]);
            }
        });

    }
}
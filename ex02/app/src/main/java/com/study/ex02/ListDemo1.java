package com.study.ex02;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListDemo1 extends ListActivity {

    // 전역변수
    TextView txtResult;
    String[] items = {"사과","포도","레몬","수박","바나나","체리"};

    // Alt+Insert
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        txtResult.setText("좋아하는 과일 : "+items[position]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        txtResult = (TextView) findViewById(R.id.txtResult);

        // 아답터 생성( 배열 자료를 리스트뷰에 출력)
        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,  android.R.layout.simple_list_item_1,    items);
        setListAdapter(adapter);

    }// create

}
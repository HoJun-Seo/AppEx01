package com.study.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ArrayListActivity extends AppCompatActivity {

    // 위젯 전역 변수
    ListView arraylist;
    EditText edit1;
    Button btnOk;

    List<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_list);

        // 뷰바인딩
        arraylist = (ListView) findViewById(R.id.arraylist);
        edit1 = (EditText)findViewById(R.id.edit1);
        btnOk = (Button)findViewById(R.id.btnOk);

        items = new ArrayList<>();
        items.add("사과");
        items.add("포도");
        items.add("파인애플");
        items.add("자두");

        // 데이터 바인딩
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items );
        arraylist.setAdapter(adapter);

        // 이벤트 처리 : 입력한 자료를 리스트뷰에 추가하는 메서드
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditTex에 입력한 값 : getText()=> Editable타입 => String타입전환
                String str = edit1.getText().toString();

                // ArrayList에  입력한 값을 추가
                items.add(str);
                //  ListView에 추가한 항목 갱신하여 뷰처리
                adapter.notifyDataSetChanged();

                edit1.setText("");

            }
        });

        // 리스트 항목을 길게 눌렸을 때 이벤트 처리 : 삭제 기능
        arraylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                // 선택한 항목의 index값을 추출하여 삭제
                items.remove(i);
                // 리스트뷰 갱신
                adapter.notifyDataSetChanged();

                return false;
            }
        });

    }
}
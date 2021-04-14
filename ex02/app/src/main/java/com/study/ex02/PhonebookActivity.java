package com.study.ex02;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhonebookActivity extends AppCompatActivity {

    TextView txtResult;
    ListView list;
    List<PhonebookDTO> items;
    PhonebookDTO dto;
    Uri number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo1);
        
        txtResult = (TextView)findViewById(R.id.txtResult);
        list = (ListView)findViewById(R.id.list);
        
        items = new ArrayList<>();
        items.add(new PhonebookDTO("김철수", "010-0000-0000"));
        items.add(new PhonebookDTO("박철수", "010-0000-0001"));
        items.add(new PhonebookDTO("철철수", "010-0000-0002"));
        items.add(new PhonebookDTO("홍철수", "010-0000-0003"));

        // 커스텀 어댑터(사용자 정의 리스트뷰) 생성
        MyAdapter adapter = new MyAdapter(this, R.layout.phonebook, items);
        list.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<PhonebookDTO>{
        public MyAdapter(@NonNull Context context, int resource, @NonNull List<PhonebookDTO> objects){
            super(context, resource, objects);
        }
        
        // child view(뷰안 뷰 : 자식 뷰)출력 : 항목 별(행 단위)뷰(자식 뷰)
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            // 자식 뷰 : 여기서는 phonebook.xml 을 지칭
            View v = convertView;
            
            // v 가 null 이면 자식 뷰 생성 : 처음에만 자식 뷰를 생성한다는 의미
            if (v == null){
                Log.d("childview", "child view 가 null 입니다.");
                
                // 뷰 생성
                LayoutInflater li = (LayoutInflater)getLayoutInflater();
                // xml 에는 레이아웃 설정
                v = li.inflate(R.layout.phonebook, null);
            }
            
            dto = items.get(position);
            TextView txtName = (TextView)v.findViewById(R.id.txtName);
            TextView txtTel = (TextView)v.findViewById(R.id.txtTel);
            
            txtName.setText(dto.getName());
            txtTel.setText(dto.getTel());
            
            // 자식 뷰를 클릭하면 전화 걸기 실행
            v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // 전화걸기 관련 내용
                }
            });
            
            return v;
        }
    } // 내부 클래스
}
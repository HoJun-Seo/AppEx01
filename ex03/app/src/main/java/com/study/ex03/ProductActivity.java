package com.study.ex03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

    // 위젯 전역변수
    Button btnAdd;
    ListView list;

    ProductDAO dao;
    List<ProductDTO> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // 위젯변수와 뷰 바인딩
        btnAdd = (Button) findViewById(R.id.btnAdd);
        list = (ListView) findViewById(R.id.list);

        // 상품 테이블 생성 및 open
        dao = new ProductDAO(this);
        SQLiteDatabase db = dao.dbconn();
//        db.close();


        // 추가버튼 클릭시
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, ProductAddActivity.class);
                startActivity(intent);
            }
        });
    }


    // 일시정지 되었다가 다시 재생할 경우
    // onCreate() : 최초 화면 생성시 수행, onResume(): 화면이 가려졌다가 다시 출력될 경우 호출(인터럽트발생시 처리후 호출됨)
    @Override
    protected void onResume() {
        super.onResume();

        items = dao.list();

        // 커스텀  아답터 적용하여 ListView에  출력
        MyAdapter adapter = new MyAdapter(this, R.layout.product_row, items);
        list.setAdapter(adapter);
    }
    //내부클래스 정의 : 커스텀 아답터 정의
    class MyAdapter extends ArrayAdapter<ProductDTO> {


        public MyAdapter(@NonNull Context context, int resource, @NonNull List<ProductDTO> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            // 직전에 출력된 뷰
            View v = convertView;
            if (v == null){
                // 뷰를 생성(최초 수행시에는 뷰가 없으므로 뷰를 생성함)
                LayoutInflater li = (LayoutInflater) getLayoutInflater();
                v = li.inflate(R.layout.product_row, null);
            }

            // items항목의 개수 만큼 반해서 뷰를 생성
            // row 단위로 매번 객체(dto) 및 위젯 / 위젯변수 생성되어 처리
            ProductDTO dto = items.get(position);

            TextView txtProductName = (TextView) v.findViewById(R.id.txtProductName);
            TextView txtPrice = (TextView) v.findViewById(R.id.txtPrice);
            TextView txtAmount = (TextView) v.findViewById(R.id.txtAmount);

            txtProductName.setText(dto.getProduct_name());
            txtPrice.setText("가격: "+dto.getPrice());
            txtAmount.setText("수량: "+dto.getAmount());

            // 현재 화면(뷰)에서 클릭시(수정,삭제) 이벤트 처리
            // 여기서 뷰는 행(row레코드)단위 뷰를 의미
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ProductActivity.this, ProductEditActivity.class);
                    // ProductDTO에서 implements Serializable형식을 구현해야 함.
                    intent.putExtra("dto",dto);
                    startActivity(intent);
                }
            });
            return v;
        }
    }

}
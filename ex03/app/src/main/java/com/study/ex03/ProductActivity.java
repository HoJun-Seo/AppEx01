package com.study.ex03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

    Button btnAdd;
    ListView list;

    ProductDAO dao;
    List<ProductDTO> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    @Override
    protected void onResume() {
        super.onResume();

        items = dao.list();

        MyAdapter adapter = new MyAdapter(this, R.layout.product_row, items);
        list.setAdapter(adapter);

        // 내부 클래스 정의 : 커스텀 어뎁터 정의
        class MyAdapter extends ArrayAdapter<ProductDTO>{
            public MyAdapter(@NonNull Context context, int resource, @NonNull List<ProductDTO> objects){
                super(context, resource, objects);
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

                // 직전에 출력된 뷰
                View v = convertView;
                if(v == null){
                    // 뷰를 생성(최초 수행시에는 뷰가 없으므로 뷰를 생성함)
                    LayoutInflater li = (LayoutInflater)getLayoutInflater();
                    v = li.inflate(R.layout.product_row, null);
                }

                // items 항목의 개수 만큼 반복해서 뷰를 생성
                // row 단위로 매번 객체(dto) 및 위젯/ 위젯 변수 생성되어 처리
                ProductDTO dto = items.get(position);
                TextView txtProductName = (TextView)v.findViewById(R.id.txtProductName);
                TextView txtPrice = (TextView)v.findViewById(R.id.txtPrice);
                TextView txtAmount = (TextView)v.findViewById(R.id.txtAmount);

                txtProductName.setText(dto.getProduct_name());
                txtPrice.setText("가격 : " + dto.getPrice());
                txtAmount.setText(dto.getAmount());

                return v;
            }
        }
    }
}
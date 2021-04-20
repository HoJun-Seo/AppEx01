package com.study.ex03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProductEditActivity extends AppCompatActivity implements View.OnClickListener {

    // 위젯 변수
    EditText editProductName , editPrice, editAmount;
    Button btnEdit, btnDel;

    ProductDTO dto;
    ProductDAO dao = new ProductDAO(this);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_edit);

        // 위젯변수와 뷰와 바인딩
        editProductName = (EditText) findViewById(R.id.editProductName);
        editPrice = (EditText) findViewById(R.id.editProductPrice);
        editAmount = (EditText) findViewById(R.id.editProductAmount);

        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDel = (Button) findViewById(R.id.btnDel);

        // intent으로 넘오는 인자값을 추출하여 화면에 연결
        Intent intent = getIntent();
        dto = (ProductDTO) intent.getSerializableExtra("dto");

        editProductName.setText(dto.getProduct_name());
        editPrice.setText( Integer.toString(dto.getPrice()) );
        editAmount.setText( Integer.toString(dto.getAmount()) );

        // 버튼 클릭에 대한 이벤트 처리 : 방법1
//        btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 수정에 관한 내용 처리
//            }
//        });//수정 버튼
//        btnDel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 삭제에 관한 내용 처리0
//            }
//        });// 삭제 버튼


        //버튼 클릭에 대한 이벤트 처리 : 방법2 (class단위로 클릭에 대한 묶어서 처리)
        btnEdit.setOnClickListener(this);
        btnDel.setOnClickListener(this);
    }

    // 클래스(액티비티)에 클릭 구현하는 방식
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEdit:

                String product_name = editProductName.getText().toString();
                int price = Integer.parseInt(editPrice.getText().toString());
                int amount = Integer.parseInt(editAmount.getText().toString());

                // 수정화면에서 수정된 값을 dto저장
                dto.setProduct_name(product_name);
                dto.setPrice(price);
                dto.setAmount(amount);

                // dto값을 db에 저장
                dao.update(dto);
                Toast
                        .makeText(this, "수정이 완료되었습니다.", Toast.LENGTH_SHORT)
                        .show();

                // 수정 액티비티(화면) 종료(제거)
                finish();
                break;
            case R.id.btnDel:
                // 삭제 여부확인 대화상자 생성(this는 현재창에 띄운다는 의미)
                // .setPositiveButton("yes", 처리할 내용) : 긍정 버튼 클릭시 처리하는 리스너
                // .setNegativeButton("no", 처리할 내용) : 부정 버튼 클릭시 처리하는 리스너
                new AlertDialog.Builder(this)
                        .setTitle("확인")
                        .setMessage("삭제할까요?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // db에서 삭제 처리
                                dao.delete(dto.getId());
                                Toast.makeText(ProductEditActivity.this, "삭제가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                finish();// 현재 액티비티(화면)을 종료
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 현재화면 삭제(종료)하고 이전화면으로 복귀
                                finish();
                            }
                        })
                        .show();
                break;
        }
    }
}
package com.study.ex03;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // 현재 실행 중인 화면에 대한 객체
    Context context;

    //  sqlite db 파일 객체
    SQLiteDatabase db;

    // 현재 객체를 여러 화면에서 공유하여 사용하기위해 생성자에서 Context객체를 인자로 받아옴
    public ProductDAO(Context context) {
        this.context = context;
    }

    // db 생성 및 접속
    public SQLiteDatabase dbconn(){
        //  db 생성하거나 오픈 : product.db(db생성 및 열기),  .MODE_PRIVATE(현재 앱에서만  db허용)
        db = context.openOrCreateDatabase("prodect.db", Context.MODE_PRIVATE, null);

        // sql문장으로 table생성을 위한 문자열
        String sql = "create table if not exists product "+
                "(id integer primary key autoincrement, " +
                " product_name varchar(50) not null, " +
                " price int not null, " +
                " amount int not null )";

        // sql문장 실행
        db.execSQL(sql);

//        sql = "insert into product (product_name, price, amount) values ('냉장고',500000,5) ";
//        db.execSQL(sql);

        return db;

    }

    // 상폼목록 조회( db에서 읽어온 데이터 상품목록)
    public List<ProductDTO> list() {
        List<ProductDTO> items = new ArrayList<>();

        // db 객체 생성
        SQLiteDatabase db = null;

        // 레코드를 하나씩 읽어 들이는 객체 (레코드 탐색 객체)
        Cursor cursor = null;
        try {
            db = dbconn();

            String sql = "select id, product_name, price, amount from product order by product_name ";
            cursor = db.rawQuery(sql,null);

            while(cursor.moveToNext()){
                // db필드값을 읽어와서 변수에 저장(필드명은 인덱스명만 가능)
                int id = cursor.getInt(0);
                String product_name = cursor.getString(1);
                int price =cursor.getInt(2);
                int amount = cursor.getInt(3);

                // 리스트에 추가
                items.add(new ProductDTO(id, product_name, price, amount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 반드시 자원 해제 시켜야 함.
            if (cursor!=null) cursor.close();
            if (db!=null) db.close();
        }

        return items;
    }

    // 상품 등록 (추가)
    public void insert(ProductDTO dto){
        SQLiteDatabase db = null;
        try {
            db = dbconn();
            String sql = String.format("insert into product (product_name, price, amount) values ('%s', %d, %d)",dto.getProduct_name(), dto.getPrice(), dto.getAmount());
            db.execSQL(sql);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) db.close();
        }
    }
    // 상품 수정
    public void update(ProductDTO dto){
        SQLiteDatabase db = null;
        try {
            db = dbconn();
            String sql = String.format(
                    "update product set product_name='%s', price=%d, amount=%d where id=%d ",
                    dto.getProduct_name(), dto.getPrice(), dto.getAmount() , dto.getId() );
            db.execSQL(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (db!=null) db.close();
        }
    }
    // 상품 삭제
    public void delete(int id){
        SQLiteDatabase db = null;
        try {
            db = dbconn();
            String sql = String.format( "delete from product  where id=%d ", id  );
            db.execSQL(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (db!=null) db.close();
        }
    }
}


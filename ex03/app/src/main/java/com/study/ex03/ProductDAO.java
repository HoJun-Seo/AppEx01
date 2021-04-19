package com.study.ex03;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
                " proce int not null, " +
                " amount int not null )";

        // sql문장 실행
        db.execSQL(sql);

       /* sql = "insert into product(product_name, price, amount) values('냉장고', 500000,5)";
        db.execSQL(sql);*/

        return db;

    }
}

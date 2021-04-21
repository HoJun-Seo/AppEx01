package com.study.ex04_file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;

public class ResourceActivity extends AppCompatActivity {

    // 위젯 변수
    ListView xmlList;
    List<String> xml_itmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        
        // 뷰와 위젯변수 연결
        xmlList = (ListView)findViewById(R.id.xmlList);
        xml_itmes = new ArrayList<>();
        
        // 파일로 읽을 경우 예외처리 해야 함
        try {
            // getResource() : res(리소스) 폴더를 의미
            // openRawResource(리소스파일) : res/raw/폴더에 있는 리소스 파일
            InputStream is = getResources().openRawResource(R.raw.words);

            // XML Parsing 작업
            DocumentBuilder
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
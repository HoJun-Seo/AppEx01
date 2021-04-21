package com.study.ex04_file;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExternalActivity extends AppCompatActivity {
    // 위젯 변수
    Button btnSave, btnLoad, btnDelete;
    EditText multiEdit;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 내부메모리앱에서 사용한 레이아웃 그대로 사용
        setContentView(R.layout.read_write);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        multiEdit = (EditText) findViewById(R.id.multiEdit);

        // 외부메모리 경로(안드로이드 버전, 조조사마다 조름 다름)
        // 에뮬레이터에서 확인시 : "/sdcard/"폴더에서 확인
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.i("path","외부 메모리 경로 : "+path);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 쓰기 사용 권한을 체크하는 메서드 호출
                check();
            }

        });// btnSave

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });// btnLoad

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 파일 확인 여부 : "/sdcard/"폴더에서 확인
                File file = new File(path+"/test.txt");
                if (file.delete()){
                    multiEdit.setText("");
                    Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });// btnDelete


    }

    // 권한 설정 체크
    void check(){
        int permission_check = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        // 동의 : 0,  비동의 : 1
        if (permission_check != PackageManager.PERMISSION_GRANTED) {
            // 비동의 이면  사용권하나에 대한 대화상자 호출
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            // 사용 권한 동의이면 저장하는 메서드 호출
            save();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // 요청 코드 값에 따른 처리
        switch (requestCode){
            case 1:
                // grantResult.length : 사용자 동의 결과 항목수
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    //동의 한 경우
                    save();
                } else {
                    // 동의하지않은 경우
                    Toast.makeText(this, "외부메모리 사용할 수 없습니다.",Toast.LENGTH_LONG).show();
                }
//                for (i=0; i<grantResults.length; i++){
//                    grantResults[i] == PackageManager.PERMISSION_GRANTED;
//                }
                break;
        }// switch()
    }

    // 불러오기
    void load(){
        // 파일 확인 여부 : "/sdcard/"폴더에서 확인
        try {
            // /환경에 맞는 경로, Stream 바이트 단위 입출력
            FileInputStream is = new FileInputStream(path+"/test.txt");
            if (is!=null){
                // Reader&Writer 바이트 단위 입출력
                InputStreamReader reader = new InputStreamReader(is, "utf-8");
                // Buffer를 사용하여 입출력 속도향상
                BufferedReader br = new BufferedReader(reader);

                String str = "";
                StringBuilder sb = new StringBuilder();

                // 텍스트파일을 줄단위로 읽어서 스트림빌드객체(String으로 전환시킴) 저장
                while ( (str=br.readLine()) != null ){
                    sb.append(str+"\n");
                }
                is.close();
                multiEdit.setText(sb.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 저장하기
    void save(){
        // 파일 확인 여부 : "/sdcard/"폴더에서 확인
        File file = new File(path+"/test.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            // 입력한 내용 변수에 저장
            String str = multiEdit.getText().toString();
            // 스트림을 바이트배열로 전환하여 파일출력
            fos.write(str.getBytes());
            fos.close();

            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
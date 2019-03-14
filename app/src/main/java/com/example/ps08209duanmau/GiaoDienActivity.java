package com.example.ps08209duanmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GiaoDienActivity extends AppCompatActivity {
    ImageView ngdung,theloai,imageHoadon,imageSach,imageBanchay,imageThongke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GIAO DIỆN CHÍNH");
        setContentView(R.layout.activity_giao_dien);
        ngdung=(ImageView)findViewById(R.id.iv_nguoidung);
        theloai=(ImageView)findViewById(R.id.iv_theloai);
        imageHoadon=(ImageView)findViewById(R.id.iv_hoadon);
        imageSach=(ImageView)findViewById(R.id.iv_sach);
        imageBanchay=(ImageView)findViewById(R.id.iv_sachbanchay);
        imageThongke=(ImageView)findViewById(R.id.iv_thongke);

        ngdung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GiaoDienActivity.this,Listnguoidung.class);
                startActivity(i);
            }
        });
        theloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GiaoDienActivity.this,ListTheloai.class);
                startActivity(i);
            }
        });
        imageHoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GiaoDienActivity.this,ListHoadon.class);
                startActivity(i);
            }
        });
        imageSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GiaoDienActivity.this,ListSach.class);
                startActivity(i);
            }
        });
        imageBanchay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GiaoDienActivity.this,Listbanchay.class);
                startActivity(i);
            }
        });
        imageThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GiaoDienActivity.this,Listthongke.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_in,R.anim.back_out);
    }
}

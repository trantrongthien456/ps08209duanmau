package com.example.ps08209duanmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ps08209duanmau.DAO.TheloaiDAO;

public class Theloaideilta extends AppCompatActivity {
    EditText edMatheloai,edTentheloai,edMota,edVitri;
    TheloaiDAO theloaiDAO;
    String ma,ten,vi,mo,user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloaideilta);
        setTitle("CHI TIẾT THỂ LOẠI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edMatheloai = (EditText) findViewById(R.id.edMatheloai);
        edTentheloai = (EditText) findViewById(R.id.edTentheloai);
        edMota = (EditText) findViewById(R.id.edMota);
        edVitri = (EditText) findViewById(R.id.edVitri);
        theloaiDAO = new TheloaiDAO(this);

        Intent in = getIntent();
        Bundle c = in.getExtras();
        user=c.getString("MATHELOAI");
        ten = c.getString("TENTHELOAI");
        mo = c.getString("MOTA");
        vi = c.getString("VITRI");
        edMatheloai.setText(user);
        edTentheloai.setText(ten);
        edMota.setText(mo);
        edVitri.setText(vi);
    }
    public void updateU(View view){

        if (theloaiDAO.updateInfoTheLoai(user,edMatheloai.getText().toString(),edTentheloai.getText().toString(),edMota.getText().toString(),edVitri.getText().toString())>0){
            Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();
        }
    }
    public void Huy(View view){
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



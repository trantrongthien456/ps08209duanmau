package com.example.ps08209duanmau;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ps08209duanmau.DAO.NguoiDungDAO;

public class Nguoidungdeilta extends AppCompatActivity {
    EditText edFullName, edPhone;
    NguoiDungDAO nguoiDungDAO;
    String username,fullname,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoidungdeilta);
        edFullName = (EditText) findViewById(R.id.edFullName);
        edPhone = (EditText) findViewById(R.id.edPhone);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nguoiDungDAO = new NguoiDungDAO(this);
        TextView text = (TextView) findViewById(R.id.text);;
        Intent in = getIntent();
        Bundle b = in.getExtras();
        fullname = b.getString("FULLNAME");
        phone = b.getString("PHONE");
        username = b.getString("USERNAME");
        edFullName.setText("");
        edPhone.setText("");
    }
    public void updateUser(View view){
        if (nguoiDungDAO.updateInfoNguoiDung(username,edPhone.getText().toString(),edFullName.getText().toString())>0){
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

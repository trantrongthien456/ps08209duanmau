package com.example.ps08209duanmau;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ps08209duanmau.DAO.NguoiDungDAO;
import com.example.ps08209duanmau.Model.Nguoidung;

public class Changerpass extends AppCompatActivity {
    EditText edPasss,edRePasss,edTennguoidung;
    NguoiDungDAO nguoiDungDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changerpass);
        setTitle("ĐỔI MẬT KHẨU");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edPasss = (EditText) findViewById(R.id.edPassword);
        edRePasss = (EditText) findViewById(R.id.edRePassword);
        edTennguoidung = (EditText) findViewById(R.id.edTennguoidung);
    }

    public int validateFor(){
        int check = 1;
        if (edPasss.getText().length()==0 || edRePasss.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }else {
            String rePass=edRePasss.getText().toString();
            String pass=edPasss.getText().toString();
            if (!pass.equals(rePass)) {
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp",
                        Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }
    public void changePassword(View view) {
        SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        nguoiDungDAO = new NguoiDungDAO(Changerpass.this);
        Nguoidung user = new Nguoidung(edTennguoidung.getText().toString(), edPasss.getText().toString(), "", "");
        try {
            if (validateFor()>0){
                if (nguoiDungDAO.changePasswordNguoiDung(user) > 0) {
                    Toast.makeText(getApplicationContext(), "Cập nhật mật khẩu thành công",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Sai tên tài khoản",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}


package com.example.ps08209duanmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.ps08209duanmau.Adapter.HoadonchitietAdapter;
import com.example.ps08209duanmau.DAO.HoadonchitietDAO;

import java.util.ArrayList;
import java.util.List;

public class Hoadonchitiet extends AppCompatActivity {
    public List<com.example.ps08209duanmau.Model.Hoadonchitiet> dsHDCT = new ArrayList<>();
    ListView lvCart;
    HoadonchitietAdapter adapter = null;
    HoadonchitietDAO hoaDonChiTietDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadonchitiet);
        setTitle("HOÁ ĐƠN CHI TIẾT");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvCart = (ListView) findViewById(R.id.lvHoaDonChiTiet);
        hoaDonChiTietDAO = new HoadonchitietDAO(Hoadonchitiet.this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) { dsHDCT = hoaDonChiTietDAO.getAllHoaDonChiTietByID(b.getString("MAHOADON"));
        }
        adapter = new HoadonchitietAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}



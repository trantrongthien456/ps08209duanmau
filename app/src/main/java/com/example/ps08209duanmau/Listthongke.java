package com.example.ps08209duanmau;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ps08209duanmau.DAO.HoadonchitietDAO;

public class Listthongke extends AppCompatActivity {
    TextView tvNgay, tvThang, tvNam;
    HoadonchitietDAO hoaDonChiTietDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listhongke);

        tvNgay = (TextView) findViewById(R.id.tvThongKeNgay);
        tvThang = (TextView) findViewById(R.id.tvThongKeThang);
        tvNam = (TextView) findViewById(R.id.tvThongKeNam);
        hoaDonChiTietDAO = new HoadonchitietDAO(this);
        tvNgay.setText("Hôm nay : " + hoaDonChiTietDAO.getDoanhThuTheoNgay()+"vnd");
        tvThang.setText("Tháng này : " + hoaDonChiTietDAO.getDoanhThuTheoThang()+"vnd");
        tvNam.setText("Năm này : "  +hoaDonChiTietDAO.getDoanhThuTheoNam()+"vnd");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView text = (TextView) findViewById(R.id.text);;

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

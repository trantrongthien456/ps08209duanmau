package com.example.ps08209duanmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ps08209duanmau.Adapter.HoadonchitietAdapter;
import com.example.ps08209duanmau.DAO.HoadonchitietDAO;
import com.example.ps08209duanmau.DAO.SachDAO;
import com.example.ps08209duanmau.Model.Hoadon;
import com.example.ps08209duanmau.Model.Hoadonchitiet;
import com.example.ps08209duanmau.Model.Sach;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hoadondeilta extends AppCompatActivity {
    EditText edMaSach, edMaHoaDon, edSoLuong;
    TextView tvThanhTien;
    HoadonchitietDAO hoaDonChiTietDAO;
    SachDAO sachDAO;
    public List<Hoadonchitiet> dsHDCT = new ArrayList<>();
    ListView lvCart;
    HoadonchitietAdapter adapter = null;
    double thanhTien = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadondeilta);
        setTitle("THANH TOÁN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edMaSach = (EditText) findViewById(R.id.edMaSach);
        edMaHoaDon = (EditText) findViewById(R.id.edMaHoaDon);
        edSoLuong = (EditText) findViewById(R.id.edSoLuongMua);
        lvCart = (ListView) findViewById(R.id.lvCart);
        tvThanhTien = (TextView) findViewById(R.id.tvThanhTien);
        adapter = new HoadonchitietAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            edMaHoaDon.setText(b.getString("MAHOADON"));
        }
    }
    public void ADDHoaDonCHITIET(View view) {
        hoaDonChiTietDAO = new HoadonchitietDAO(Hoadondeilta.this);
        sachDAO = new SachDAO(Hoadondeilta.this);
        try {
            if (validation() < 0) {
                Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                Sach sach = sachDAO.getSachByID(edMaSach.getText().toString());
                if (sach!=null){
                    int pos = checkMaSach(dsHDCT,edMaSach.getText().toString());
                    Hoadon hoaDon = new Hoadon(edMaHoaDon.getText().toString(),new
                            Date());
                    Hoadonchitiet hoaDonChiTiet = new
                            Hoadonchitiet(1,hoaDon,sach,Integer.parseInt(edSoLuong.getText().toString()));
                    if (pos>=0){
                        int soluong = dsHDCT.get(pos).getSoLuongMua();
                        hoaDonChiTiet.setSoLuongMua(soluong +
                                Integer.parseInt(edSoLuong.getText().toString()));
                        dsHDCT.set(pos,hoaDonChiTiet);
                    }else {
                        dsHDCT.add(hoaDonChiTiet);
                    }
                    adapter.changeDataset(dsHDCT);
                }else {
                    Toast.makeText(getApplicationContext(),"Mã sách không tồn tại",Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
    public void thanhToanHoaDon(View view) {
        hoaDonChiTietDAO = new HoadonchitietDAO(Hoadondeilta.this);
        //tinh tien
        thanhTien = 0;
        try {
            for (Hoadonchitiet hd: dsHDCT) {
                hoaDonChiTietDAO.inserHoaDonChiTiet(hd);
                thanhTien = thanhTien + hd.getSoLuongMua() *
                        hd.getSach().getGiaBia();
            }
            tvThanhTien.setText("Tổng tiền: " +thanhTien);
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }
    public int checkMaSach(List<Hoadonchitiet> lsHD, String maSach){
        int pos = -1;
        for (int i = 0; i < lsHD.size(); i++){
            Hoadonchitiet hd = lsHD.get(i);
            if (hd.getSach().getMaSach().equalsIgnoreCase(maSach)){
                pos = i;
                break;
            }
        }
        return pos;
    }
    public int validation(){
        if (edMaSach.getText().toString().isEmpty()||edSoLuong.getText().toString().isEmpty()||
                edMaHoaDon.getText().toString().isEmpty()){
            return -1;
        }
        return 1;
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



package com.example.ps08209duanmau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ps08209duanmau.Adapter.TheloaiAdapter;
import com.example.ps08209duanmau.DAO.TheloaiDAO;
import com.example.ps08209duanmau.Model.Theloai;

import java.util.ArrayList;
import java.util.List;

public class ListTheloai extends AppCompatActivity {
    public static List<Theloai> dsTheLoai = new ArrayList<>();
    ListView lvTheLoai;
    TheloaiAdapter adapter = null;
    TheloaiDAO theLoaiDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_theloai2);

        setTitle("THỂ LOẠI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvTheLoai = (ListView) findViewById(R.id.lvTheLoai);
        registerForContextMenu(lvTheLoai);
        theLoaiDAO = new TheloaiDAO(ListTheloai.this);
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter = new TheloaiAdapter(this,dsTheLoai);
        lvTheLoai.setAdapter(adapter);

        lvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListTheloai.this, Theloaideilta.class);
                Bundle b = new Bundle();
                b.putString("MATHELOAI", dsTheLoai.get(position).getMaTheloai());
                b.putString("TENTHELOAI", dsTheLoai.get(position).getTenTheloai());
                b.putString("MOTA", dsTheLoai.get(position).getMoTa());
                b.putString("VITRI", String.valueOf(dsTheLoai.get(position).getViTri()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutheloai, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(ListTheloai.this, com.example.ps08209duanmau.Theloai.class);
                startActivity(intent);
                return (true);
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        dsTheLoai.clear();
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter.changeDataset(dsTheLoai);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontext, menu);
        menu.setHeaderTitle("Chọn thông tin");
    }


    }


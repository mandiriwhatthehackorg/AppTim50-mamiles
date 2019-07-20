package com.hackathon.mamiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.hackathon.mamiles.activity.TabunganActivity;
import com.hackathon.mamiles.activity.UangSakuActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);
        drawerToggle.syncState();

        final ListView drawerList = findViewById(R.id.drawer_list);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("name","Profil Saya");
        arrayList.add(hashMap);
        hashMap=new HashMap<>();
        hashMap.put("name","Pengaturan");
        arrayList.add(hashMap);
        hashMap=new HashMap<>();
        hashMap.put("name","Status Transaksi");
        arrayList.add(hashMap);
        hashMap=new HashMap<>();
        hashMap.put("name","Suku Bunga");
        arrayList.add(hashMap);
        hashMap=new HashMap<>();
        hashMap.put("name","Bantuan");
        arrayList.add(hashMap);
        hashMap=new HashMap<>();
        hashMap.put("name","Tentang Mamiles");
        arrayList.add(hashMap);
        hashMap=new HashMap<>();
        hashMap.put("name","Hubungi Kami");
        arrayList.add(hashMap);
        hashMap=new HashMap<>();
        hashMap.put("name","Logout");
        arrayList.add(hashMap);

        String[] from={"name"};//string array
        int[] to={R.id.textView};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);
        drawerList.setAdapter(simpleAdapter);

        ImageButton b1 = findViewById(R.id.uangsaku);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UangSakuActivity.class);
                startActivityForResult(intent, 123);
            }
        });

        ImageButton b2 = findViewById(R.id.tabungan);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabunganActivity.class);
                startActivityForResult(intent, 123);
            }
        });
    }
}

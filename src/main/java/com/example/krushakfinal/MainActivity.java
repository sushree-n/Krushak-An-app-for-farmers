package com.example.krushakfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.krushakfinal.ui.main.LoginActivity;
import com.example.krushakfinal.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.Logout2)
        {
            FirebaseAuth.getInstance().signOut();
            Intent IntToMain = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(IntToMain);
            finish();
        }
        if(item.getItemId()==R.id.event)
        {
            Intent i = new Intent(MainActivity.this, Cal.class);
            startActivity(i);
        }
        if(item.getItemId()==R.id.profitcalc)
        {
            Intent i = new Intent(MainActivity.this, ProfitCalc.class);
            startActivity(i);
        }
        if(item.getItemId()==R.id.help)
        {
            Intent i = new Intent(MainActivity.this, Help.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
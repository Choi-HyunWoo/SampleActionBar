package com.hw.corcow.sampleactionbar;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;        // actionBar 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);      // ActionBar가 보이도록

        // Custom View 설정
        TextView textView = new TextView(this);
        textView.setText("Custom View");
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(textView);

        // 기존의 Title을 삭제
        actionBar.setDisplayShowTitleEnabled(false);

        Button btn = (Button)findViewById(R.id.btn_child);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChildActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Toast.makeText(this, "HomeAsUp clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

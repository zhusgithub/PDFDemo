package com.zhushen.pdfdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button readFile,create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        readFile = (Button)findViewById(R.id.readFile);
        create = (Button)findViewById(R.id.createPDF);

        readFile.setOnClickListener(this);
        create.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.readFile:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,FileActivity.class);
                startActivity(intent);
                break;
            case R.id.createPDF:
                Intent createIntent = new Intent();
                createIntent.setClass(MainActivity.this,FileActivity.class);
                startActivity(createIntent);
                break;
        }

    }
}

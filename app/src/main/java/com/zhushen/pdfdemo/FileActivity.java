package com.zhushen.pdfdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.zhushen.pdfdemo.adapter.FileAdapter;

public class FileActivity extends AppCompatActivity {
    private ListView fileList;
    private FileAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        init();
    }

    private void init() {
        fileList = (ListView)findViewById(R.id.file_lv);
        adapter = new FileAdapter(this);
    }
}

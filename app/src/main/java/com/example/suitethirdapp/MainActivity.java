package com.example.suitethirdapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent =getIntent();
        Uri uri = intent.getData();
        if  (uri !=null){
            String uri_string = "Uri :"+uri;
            TextView textView = findViewById(R.id.textView);
            textView.setText(uri_string);

        }
    }
}
package com.example.implicitintents;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.open_website_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implicit intent
                Intent i =new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://developer.android.com"));
                if (i.resolveActivity(getPackageManager()) == null) {
                    startActivity(i);


                }else{
                    Log.d("ImplicitsIntents","can't handle this intent!");
                }


            }

        });
        Button OpenLocation=findViewById(R.id.open_location_button);
        OpenLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri adressUri = Uri.parse("geo:0,0?q=ISIMS");
                Intent intent =new Intent(Intent.ACTION_VIEW , adressUri);
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getPackageManager()) == null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitsIntents","can't handle this intent!");


                }

            }


        });
        Button ShareText =findViewById(R.id.share_text_button);
        ShareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent=new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"Mobile Programming Example");
                sendIntent.setType("text/plain");
                Intent shareIntent=Intent.createChooser(sendIntent,null);
                startActivity(shareIntent);

            }
        });


    }
}

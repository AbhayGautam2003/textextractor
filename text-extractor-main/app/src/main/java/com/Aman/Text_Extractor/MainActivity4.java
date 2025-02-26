package com.Aman.Text_Extractor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView t3 = findViewById(R.id.textView9);
        TextView t2 = findViewById(R.id.textView6);
        TextView t1 = findViewById(R.id.tv);
        ImageView logo = findViewById(R.id.logo);
        Animation rotate = AnimationUtils.loadAnimation(MainActivity4.this,R.anim.rotate);
        Animation scale = AnimationUtils.loadAnimation(MainActivity4.this,R.anim.scale);
        Animation alpha = AnimationUtils.loadAnimation(MainActivity4.this,R.anim.fadein);
        t1.startAnimation(alpha);
        t2.startAnimation(alpha);
        t3.startAnimation(alpha);
        logo.startAnimation(rotate);
       // logo.startAnimation(scale);
        new  Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity4.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
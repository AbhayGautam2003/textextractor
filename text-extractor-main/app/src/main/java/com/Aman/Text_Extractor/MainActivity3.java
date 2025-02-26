package com.Aman.Text_Extractor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity3 extends AppCompatActivity {
    FloatingActionButton bt3;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        Intent intent2 = getIntent();
        String str = intent2.getStringExtra(MainActivity2.EXTRA_NAME);
        bt3 = findViewById(R.id.a3b1);
        t1 = findViewById(R.id.a3t1);
        t1.setText(str);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData clipData = ClipData.newPlainText("l1",t1.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(MainActivity3.this, "Text Copied", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
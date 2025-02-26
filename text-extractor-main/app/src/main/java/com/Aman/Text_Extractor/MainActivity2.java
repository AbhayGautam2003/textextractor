package com.Aman.Text_Extractor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_NAME = "package com.example.designs";
    ImageView view1;
    Button bt1;
    String recant;
    TextView t1;
    TextRecognizer textRecognizer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        view1 = findViewById(R.id.a2v1);
        bt1 = findViewById(R.id.a2b1);
        Intent intentr = getIntent();
        Uri uri = intentr.getParcelableExtra("img");
        view1.setImageURI(uri);
        textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uri != null){
                    try {
                        InputImage inputImage = InputImage.fromFilePath(MainActivity2.this,uri);

                        Task<Text> result = textRecognizer.process(inputImage)
                                .addOnSuccessListener(new OnSuccessListener<Text>() {
                                    @Override
                                    public void onSuccess(Text text) {

                                        recant = text.getText();
                                        Intent intent3 = new Intent(MainActivity2.this,MainActivity3.class);
                                        intent3.putExtra(EXTRA_NAME,recant);
                                        startActivity(intent3);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        });








    }


}
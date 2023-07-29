package com.example.adaptit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public class Register extends AppCompatActivity {
    MaterialButton camerabtn, gallerybtn;
    ShapeableImageView imageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        camerabtn = findViewById(R.id.camerabtn);
        gallerybtn = findViewById(R.id.gallerybtn);
        imageIv = findViewById(R.id.imageIv);
        OCR ocr = new OCR(Register.this, camerabtn, gallerybtn, getContentResolver(), imageIv);
    }
}
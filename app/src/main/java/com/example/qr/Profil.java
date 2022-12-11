package com.example.qr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class Profil extends AppCompatActivity {
    private final int GALLERY_REQ_CODE = 1000;
    ImageView imageGallery ;
    CardView camera ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        imageGallery = findViewById(R.id.gallery);
        camera = findViewById(R.id.camera);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Gallery = new Intent(Intent.ACTION_PICK);
                Gallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Gallery,GALLERY_REQ_CODE);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK) {
            if(requestCode==GALLERY_REQ_CODE){
                imageGallery.setImageURI(data.getData());
            }
        }
    }
}
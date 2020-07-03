package com.suek.practice05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MyBlogActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myblog);

        iv=findViewById(R.id.iv);
    }




    public void clickFAB_photo(View view) {
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");

        startActivityForResult(intent, 10);
    }



    public void clickFAB_camera(View view) {
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 20);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK){
                    Toast.makeText(this, "사진을 Uri를 통해 불러옵니다.", Toast.LENGTH_SHORT).show();
                    Uri uri= data.getData();
                    Glide.with(this).load(uri).into(iv);
                }
                break;
            case 20:
                if(resultCode!=RESULT_CANCELED){
                    Toast.makeText(this, "사진찍기", Toast.LENGTH_SHORT).show();
                    Uri uri= data.getData();
                    if(uri!=null){
                        Glide.with(this).load(uri).into(iv);
                }else {
                        Bundle bundle= data.getExtras();
                        Bitmap bm= (Bitmap) bundle.get("data");
                        Glide.with(this).load(bm).into(iv);
                    }
                }
                break;
        }
    }


}//MainActivity

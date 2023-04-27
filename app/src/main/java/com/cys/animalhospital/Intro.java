package com.cys.animalhospital;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class Intro extends MainActivity{
    TextView tv;
    TextView tv_tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        tv=findViewById(R.id.tv);
        tv_tip=findViewById(R.id.tv_tip);
        findViewById(R.id.intro_logo).setOnClickListener(v -> clickLogo());

    }
    void clickLogo(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Going Home Page ", Toast.LENGTH_SHORT).show();

    }
}

package com.example.yo.a6week;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    TextView txtname,etmenu1,etmenu2,etmenu3,tvTel,tvURL,tvRegdate;
    Button btnback;
    ImageView imgno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtname = (TextView)findViewById(R.id.txtname);
        etmenu1 = (TextView)findViewById(R.id.etmenu1);
        etmenu2 = (TextView)findViewById(R.id.etmenu2);
        etmenu3 = (TextView)findViewById(R.id.etmenu3);
        tvTel = (TextView)findViewById(R.id.tvTel);
        tvURL = (TextView)findViewById(R.id.tvURL);
        tvRegdate = (TextView)findViewById(R.id.tvRegdate);
        btnback = (Button)findViewById(R.id.btnback);
        imgno = (ImageView)findViewById(R.id.imgno);

        Intent intent = getIntent();
        Data ddd = intent.getParcelableExtra("retuarant2");
        txtname.setText( ddd.getName());
        etmenu1.setText(ddd.getMenu1());
        etmenu2.setText(ddd.getMenu2());
        etmenu3.setText(ddd.getMenu3());
        tvTel.setText((Integer.toString(ddd.getNumber())));
        tvURL.setText(ddd.getHomepage());
        tvRegdate.setText(ddd.getDate());
        if(ddd.getCata() == 1) {
            imgno.setImageResource(R.drawable.chicken);
        }
        if(ddd.getCata() == 2) {
            imgno.setImageResource(R.drawable.pizza);
        }
        if(ddd.getCata() == 3) {
            imgno.setImageResource(R.drawable.ham);
        }
    }

    public void onClick(View v){
        if(v.getId() == R.id.btnback) {
            finish();
        }
    }
}

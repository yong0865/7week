package com.example.yo.a6week;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    TextView txtname, etmenu1, etmenu2, etmenu3, tvTel, tvURL, tvRegdate;
    Button btnback;
    ImageView imgno, imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtname = (TextView) findViewById(R.id.txtname);
        etmenu1 = (TextView) findViewById(R.id.etmenu1);
        etmenu2 = (TextView) findViewById(R.id.etmenu2);
        etmenu3 = (TextView) findViewById(R.id.etmenu3);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvURL = (TextView) findViewById(R.id.tvURL);
        tvRegdate = (TextView) findViewById(R.id.tvRegdate);
        btnback = (Button) findViewById(R.id.btnback);
        imgno = (ImageView) findViewById(R.id.imgno);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);

        Intent intent = getIntent();
        Data ddd = intent.getParcelableExtra("retuarant2");
        txtname.setText(ddd.getName());
        etmenu1.setText(ddd.getMenu1());
        etmenu2.setText(ddd.getMenu2());
        etmenu3.setText(ddd.getMenu3());
        tvTel.setText(ddd.getNumber());
        tvURL.setText(ddd.getHomepage());
        tvRegdate.setText(ddd.getDate());
        if (ddd.getCata() == 1) {
            imgno.setImageResource(R.drawable.chicken);
        }
        if (ddd.getCata() == 2) {
            imgno.setImageResource(R.drawable.pizza);
        }
        if (ddd.getCata() == 3) {
            imgno.setImageResource(R.drawable.ham);
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnback) {
            finish();
        }
        if (v.getId() == R.id.imageView2) {
            String num = tvTel.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+num));
            startActivity(intent);
        }
        if(v.getId() == R.id.imageView3){
            String home = tvURL.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(home));
            startActivity(intent);
        }
    }
}

package com.example.yo.a6week;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    ArrayList<Data> ress = new ArrayList<Data>();

    EditText etname,ettel,etmenu1,etmenu2,etmenu3,etaddr;
    Button btnAdd,btnCancel;
    RadioButton radio1,radio2,radio3;
    int cata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etname = (EditText)findViewById(R.id.etname);
        ettel = (EditText)findViewById(R.id.ettel);
        etmenu1 = (EditText)findViewById(R.id.etmenu1);
        etmenu2 = (EditText)findViewById(R.id.etmenu2);
        etmenu3 = (EditText)findViewById(R.id.etmenu3);
        etaddr = (EditText)findViewById(R.id.etaddr);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        radio1 = (RadioButton)findViewById(R.id.radio1);
        radio2 = (RadioButton)findViewById(R.id.radio2);
        radio3 = (RadioButton)findViewById(R.id.radio3);


    }
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            if(radio1.isChecked()){
                cata = 1;
            }
            if(radio2.isChecked()){
                cata = 2;
            }if(radio3.isChecked()){
                cata = 3;
            }

            Intent intent = getIntent();

            long now = System.currentTimeMillis();
            Date date = new Date(now);
            SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyy/MM/dd  HH:mm");
            final String strCurDate = CurDateFormat.format(date);
            String name = etname.getText().toString();
            int num = Integer.parseInt(ettel.getText().toString());
            String menu1 = etmenu1.getText().toString();
            String menu2 = etmenu2.getText().toString();
            String menu3 = etmenu3.getText().toString();
            String homepage = etaddr.getText().toString();
            String when = strCurDate;

            Data res = new Data(name, num, menu1,menu2,menu3,homepage,when,cata);
            intent.putExtra("restuarantdata", res);
            intent.putExtra("resname",name);
            setResult(1,intent);
            finish();

        }
        if(v.getId() == R.id.btnback){
            finish();
        }
    }
}

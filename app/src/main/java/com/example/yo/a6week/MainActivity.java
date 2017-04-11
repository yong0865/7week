package com.example.yo.a6week;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //Button bt;
    ArrayList<String> resname = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayList<Data> reslist = new ArrayList<Data>();
    Data res;
    TextView tv;
    int count = 0;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bt = (Button) findViewById(R.id.bt);
        tv = (TextView) findViewById(R.id.tv);
        setListView();
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, 10);
    }

    public void setListView() {
        resname = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listview);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resname);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                intent.putExtra("retuarant2",reslist.get(position));
                startActivity(intent);
            }
        });
//
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                creatDialog(view);
                return true;
            }
        });

    }



    public void creatDialog(View view){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("삭제확인");
        dlg.setIcon(R.drawable.res);
        dlg.setMessage("선택한 맛집을 정말 삭제하시겠습니까?");
        dlg.setNegativeButton("닫기",null);
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resname.remove(position);
                adapter.notifyDataSetChanged();
                count --;
                tv.setText("맛집리스트" + "(" + count + ")");
            }
        });
        AlertDialog alertDialog = dlg.create();
        alertDialog.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10) {
            if (resultCode == 1) {
                String rname = data.getStringExtra("resname");
                Data tttt = data.getParcelableExtra("restuarantdata");
                resname.add(rname);
                reslist.add(tttt);
                adapter.notifyDataSetChanged();
                count++;
                tv.setText("맛집리스트" + "(" + count + ")");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}

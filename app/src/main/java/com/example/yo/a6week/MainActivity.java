package com.example.yo.a6week;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //Button bt;

    ArrayList<Data> reslist = new ArrayList<Data>();
    CustomAdapter adapter;
    Button bt4, bt5;
    int count = 0;
    boolean check = true;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bt = (Button) findViewById(R.id.bt);
        et = (EditText) findViewById(R.id.et);
        reslist = new ArrayList<>();
        setListView();

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<Data> searchResult = new ArrayList<Data>();
                String search = s.toString();

                for(Data data : reslist) {
                    if(data.getName().contains(search)) {
                        searchResult.add(data);
                    }
                }
                adapter.setData(searchResult);
                adapter.notifyDataSetChanged();
            }
        });


    }


    public void onClick(View v) {
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);

        if (v.getId() == R.id.bt) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivityForResult(intent, 10);
        } else if (v.getId() == R.id.bt2) {
            adapter.setAscSort(1);
        } else if (v.getId() == R.id.bt3) {
            adapter.setAscSort(2);
        } else if (v.getId() == R.id.bt4) {
            if (reslist.size() != 0) {
                bt4.setVisibility(View.GONE);
                bt5.setVisibility(View.VISIBLE);
                adapter.setCheckbox(true);
            }

        } else if (v.getId() == R.id.bt5) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("삭제확인");
            dlg.setIcon(R.drawable.res);
            dlg.setMessage("선택한 맛집을 정말 삭제하시겠습니까?");
            dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    adapter.setCheckbox(false);
                }
            });
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    adapter.getremove();
                    adapter.setCheckbox(false);
                }
            });
            dlg.show();
            bt5.setVisibility(View.GONE);
            bt4.setVisibility(View.VISIBLE);
        }
    }


    public void setListView() {


        listView = (ListView) findViewById(R.id.listview);
        adapter = new CustomAdapter(this, reslist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                intent.putExtra("retuarant2", reslist.get(position));
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("삭제확인");
                dlg.setIcon(R.drawable.res);
                dlg.setMessage("선택한 맛집을 정말 삭제하시겠습니까?");
                dlg.setNegativeButton("닫기", null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reslist.remove(position);
                        adapter.notifyDataSetChanged();
                        count--;
                        Snackbar.make(view, "삭제되었습니다.", 1000).show();
                    }
                });
                AlertDialog alertDialog = dlg.create();
                alertDialog.show();
                return true;
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10) {
            if (resultCode == 1) {
                String rname = data.getStringExtra("resname");
                Data tttt = data.getParcelableExtra("restuarantdata");

                reslist.add(tttt);
                adapter.notifyDataSetChanged();
                count++;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}

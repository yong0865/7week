package com.example.yo.a6week;

/**
 * Created by yo on 2017-04-26.
 */

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

class CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<Data> arrayList = new ArrayList<>();
    ArrayList<Data> searchList = new ArrayList<>();
    private boolean mcheckboxstate = false;


    public void setCheckbox(boolean pState) {
        mcheckboxstate = pState;
        notifyDataSetChanged();
    }

    public CustomAdapter(Context context, ArrayList<Data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.customlistview, null);
        }

        TextView t1 = (TextView) convertView.findViewById(R.id.t1);
        TextView t2 = (TextView) convertView.findViewById(R.id.t2);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

        final Data one = arrayList.get(position);
        t1.setText(one.getName());
        t2.setText(one.getNumber());
        if (one.getCata() == 1) {
            imageView.setImageResource(R.drawable.chicken);
        } else if (one.getCata() == 2) {
            imageView.setImageResource(R.drawable.pizza);
        } else if (one.getCata() == 3) {
            imageView.setImageResource(R.drawable.ham);
        }

        if (mcheckboxstate) {
            checkBox.setVisibility(View.VISIBLE);
        } else {
            checkBox.setChecked(false);
            checkBox.setVisibility(View.INVISIBLE);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()) {
                    arrayList.get(position).setCheck(true);
                } else {
                    arrayList.get(position).setCheck(false);
                }
            }
        });


        return convertView;
    }

    Comparator<Data> nameAsc = new Comparator<Data>() {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    Comparator<Data> kindAsc = new Comparator<Data>() {
        @Override
        public int compare(Data o1, Data o2) {
            int value = 0;
            if (o1.getCata() > o2.getCata()) {
                value = 1;
            } else if (o1.getCata() < o2.getCata()) {
                value = -1;
            }
            return value;
        }
    };

    public boolean getcheck(int position) {
        return arrayList.get(position).getCheck();
    }

    public void getremove() {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            final int position = i;
            if (arrayList.get(i).getCheck()) {
                arrayList.remove(i);
                setCheckbox(false);
            } else setCheckbox(false);
        }
    }


    public void setAscSort(int value) {
        if (value == 1) {
            Collections.sort(arrayList, nameAsc);
            this.notifyDataSetChanged();
        } else if (value == 2) {
            Collections.sort(arrayList, kindAsc);
            this.notifyDataSetChanged();
        }

    }
    public void setData(ArrayList<Data> arrayList) {
        this.arrayList = arrayList;
    }
}


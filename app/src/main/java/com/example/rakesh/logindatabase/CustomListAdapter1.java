package com.example.rakesh.logindatabase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListAdapter1 extends ArrayAdapter<String> {

    private final Activity context;

    private final String[] classes;
    public String getsem;


    public CustomListAdapter1(Activity context, String[] classes) {
        super(context, R.layout.second, classes);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.classes=classes;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.second1, null,true);

        TextView tvsem1 = (TextView) rowView.findViewById(R.id.tvsem1);




        tvsem1.setText(classes[position]);

        return rowView;

    };
}
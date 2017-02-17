package com.example.rakesh.logindatabase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;

    private final String[] semester;
    public String getsem;


    public CustomListAdapter(Activity context, String[] semester) {
        super(context, R.layout.second, semester);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.semester=semester;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.second, null,true);

        TextView tvsem = (TextView) rowView.findViewById(R.id.tvsem);




        tvsem.setText(semester[position]);

        return rowView;

    };
}
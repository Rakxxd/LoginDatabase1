package com.example.rakesh.logindatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SemeSelect extends AppCompatActivity {
    int count2 = UserAreaActivity.count1;
    String[] classes = new String[count2];
    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seme_select);
        TextView tvclass = (TextView) findViewById(R.id.tvclass);

        Bundle extras = getIntent().getExtras();
        classes = extras.getStringArray("number");
        CustomListAdapter1 adapter = new CustomListAdapter1(this, classes);
        list1 = (ListView) findViewById(R.id.list1);
        list1.setAdapter(adapter);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //set on click with help of posion parameter passed
                String cls = classes[position];
                Toast.makeText(getApplicationContext(),"You have chosen class " + cls, Toast.LENGTH_SHORT).show();


            }
        });
    }
}

package com.example.rakesh.logindatabase;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAreaActivity extends AppCompatActivity {
    ListView list;
     String[] sems = new String[LoginActivity.count];
    String usr = LoginActivity.username;
    public static int count1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        TextView tv = (TextView) findViewById(R.id.tv);

        Bundle extras = getIntent().getExtras();
         sems = extras.getStringArray("number");


        CustomListAdapter adapter=new CustomListAdapter(this, sems);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //set on click with help of posion parameter passed

                String semCLicked = sems[position];



                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String ss;
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                JSONArray users = jsonResponse.getJSONArray("products");
                                String[] classs = new String[users.length()];
                                count1=users.length();
                                for(int i=0;i<users.length();i++){
                                    JSONObject c = users.getJSONObject(i);
                                    String cls = c.getString("class");
                                    classs[i] = cls;






                                }
                                Intent intent = new Intent(UserAreaActivity.this,SemeSelect.class);
                                intent.putExtra("number",classs);
                                startActivity(intent);


                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(UserAreaActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                SemRequest loginRequest = new SemRequest(usr, semCLicked, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserAreaActivity.this);
                queue.add(loginRequest);




            }
        });



    }
}

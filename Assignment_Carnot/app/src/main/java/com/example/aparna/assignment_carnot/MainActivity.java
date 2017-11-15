package com.example.aparna.assignment_carnot;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.ArrayList;

//import java.security.Timestamp;


public class MainActivity extends AppCompatActivity {
    public TextView results,end1,startsave1,endsave1,results2,end2,startsave2,endsave2,results3,end3,startsave3,endsave3,results4,end4,startsave4,endsave4;
    String JsonURL1 ="https://jsonplaceholder.typicode.com/comments";
    String JsonURL2 ="https://jsonplaceholder.typicode.com/photos";
    String JsonURL3="https://jsonplaceholder.typicode.com/todos";
    String JsonURL4="https://jsonplaceholder.typicode.com/posts";
    private ArrayList<String> mEntries,m,m2,m3;
    //String data = "";
    RequestQueue requestQueue;
    private String jsonResponse;
    private static String TAG = MainActivity.class.getSimpleName();
    private Button button1,button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  makeJsonArrayRequestURL1();

        results=(TextView)findViewById(R.id.t11);
        end1=(TextView)findViewById(R.id.t12);
        startsave1=(TextView)findViewById(R.id.t14);
        endsave1=(TextView)findViewById(R.id.t13);

        results2=(TextView)findViewById(R.id.t21);
        end2=(TextView)findViewById(R.id.t22);
        startsave2=(TextView)findViewById(R.id.t23);
        endsave2=(TextView)findViewById(R.id.t24);

        results3=(TextView)findViewById(R.id.t31);
        end3=(TextView)findViewById(R.id.t32);
        startsave3=(TextView)findViewById(R.id.t33);
        endsave3=(TextView)findViewById(R.id.t34);

        results4=(TextView)findViewById(R.id.t41);
        end4=(TextView)findViewById(R.id.t42);
        startsave4=(TextView)findViewById(R.id.t43);
        endsave4=(TextView)findViewById(R.id.t44);
        //fetch();
        //fetch1();
       button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch1();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch2();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch3();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch();
                fetch1();
                fetch2();
                fetch3();
            }
        });

        //DatabaseHandler db1=new DatabaseHandler(getApplicationContext());
        //String s=db1.findOne(1);
        //Log.e("Out:",s);
    }

    private void fetch() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

        JsonArrayRequest request = new JsonArrayRequest(JsonURL1,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        DatabaseHandler db=new DatabaseHandler(getApplicationContext());
                     //   int time = (int) (System.currentTimeMillis());
                       // Timestamp tsTemp = new Timestamp(time);
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        results.setText(""+timestamp);
                      //  String ts =  tsTemp.toString();
                        for(int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int pid=jsonObject.getInt("postId");
                                int id=jsonObject.getInt("id");
                                String name=jsonObject.getString("name");
                                String email=jsonObject.getString("email");
                                String body=jsonObject.getString("body");
                                Timestamp t = new Timestamp(System.currentTimeMillis());
                                if (i==0)
                                startsave1.setText(""+t);
                                db.save(pid,id,name,email,body);
                                if(i==jsonArray.length()-1) {
                                Timestamp t1 = new Timestamp(System.currentTimeMillis());
                                endsave1.setText(""+t1);}
                                mEntries.add(jsonObject.toString());
                            }
                            catch(JSONException e) {
                                mEntries.add("Error: " + e.getLocalizedMessage());
                            }
                            Timestamp ts = new Timestamp(System.currentTimeMillis());
                            end1.setText(""+ts);
                        }
                        Log.e("ASsdfbnsdkf:",mEntries.get(2));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        mEntries = new ArrayList<>();
        requestQueue.add(request);
    }

    private void fetch2() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        //results=(TextView)findViewById(R.id.t11);

        JsonArrayRequest request = new JsonArrayRequest(JsonURL3,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        DatabaseHandler db=new DatabaseHandler(getApplicationContext());
                        //   int time = (int) (System.currentTimeMillis());
                        // Timestamp tsTemp = new Timestamp(time);
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        results3.setText(""+timestamp);
                        //  String ts =  tsTemp.toString();
                        for(int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int uid=jsonObject.getInt("userId");
                                int id=jsonObject.getInt("id");
                                String title=jsonObject.getString("title");
                                String completed=jsonObject.getString("completed");
                                //String thumbnailurl=jsonObject.getString("thumbnailUrl");
                                Timestamp t = new Timestamp(System.currentTimeMillis());
                                if (i==0)
                                    startsave3.setText(""+t);
                                db.save3(uid,id,title,completed);
                                if(i==jsonArray.length()-1) {
                                    Timestamp t1 = new Timestamp(System.currentTimeMillis());
                                    endsave3.setText(""+t1);}
                                m2.add(jsonObject.toString());
                            }
                            catch(JSONException e) {
                                m2.add("Error: " + e.getLocalizedMessage());
                            }
                            Timestamp ts = new Timestamp(System.currentTimeMillis());
                            end3.setText(""+ts);
                        }
                        Log.e("ASsdfbnsdkf:",m2.get(2));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        m2 = new ArrayList<>();
        requestQueue.add(request);
    }
    private void fetch1() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        //results=(TextView)findViewById(R.id.t11);

        JsonArrayRequest request = new JsonArrayRequest(JsonURL2,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        DatabaseHandler db=new DatabaseHandler(getApplicationContext());
                        //   int time = (int) (System.currentTimeMillis());
                        // Timestamp tsTemp = new Timestamp(time);
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        results2.setText(""+timestamp);
                        //  String ts =  tsTemp.toString();
                        for(int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int aid=jsonObject.getInt("albumId");
                                int id=jsonObject.getInt("id");
                                String title=jsonObject.getString("title");
                                String url=jsonObject.getString("url");
                                String thumbnailurl=jsonObject.getString("thumbnailUrl");
                                Timestamp t = new Timestamp(System.currentTimeMillis());
                                if (i==0)
                                    startsave2.setText(""+t);
                                db.save2(aid,id,title,url,thumbnailurl);
                                if(i==jsonArray.length()-1) {
                                    Timestamp t1 = new Timestamp(System.currentTimeMillis());
                                    endsave2.setText(""+t1);}
                                m.add(jsonObject.toString());
                            }
                            catch(JSONException e) {
                                m.add("Error: " + e.getLocalizedMessage());
                            }
                            Timestamp ts = new Timestamp(System.currentTimeMillis());
                            end2.setText(""+ts);
                        }
                        Log.e("ASsdfbnsdkf:",m.get(2));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        m = new ArrayList<>();
        requestQueue.add(request);
    }

    private void fetch3() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        //results=(TextView)findViewById(R.id.t11);

        JsonArrayRequest request = new JsonArrayRequest(JsonURL4,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        DatabaseHandler db=new DatabaseHandler(getApplicationContext());
                        //   int time = (int) (System.currentTimeMillis());
                        // Timestamp tsTemp = new Timestamp(time);
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        results4.setText(""+timestamp);
                        //  String ts =  tsTemp.toString();
                        for(int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int uid=jsonObject.getInt("userId");
                                int id=jsonObject.getInt("id");
                                String title=jsonObject.getString("title");
                                String body=jsonObject.getString("body");
                                //String thumbnailurl=jsonObject.getString("thumbnailUrl");
                                Timestamp t = new Timestamp(System.currentTimeMillis());
                                if (i==0)
                                    startsave4.setText(""+t);
                                db.save4(uid,id,title,body);
                                if(i==jsonArray.length()-1) {
                                    Timestamp t1 = new Timestamp(System.currentTimeMillis());
                                    endsave4.setText(""+t1);}
                                m3.add(jsonObject.toString());
                            }
                            catch(JSONException e) {
                                m3.add("Error: " + e.getLocalizedMessage());
                            }
                            Timestamp ts = new Timestamp(System.currentTimeMillis());
                            end4.setText(""+ts);
                        }
                        Log.e("ASsdfbnsdkf:",m3.get(2));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        m3 = new ArrayList<>();
        requestQueue.add(request);
    }
}
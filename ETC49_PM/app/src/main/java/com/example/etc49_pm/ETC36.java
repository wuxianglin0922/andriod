package com.example.etc49_pm;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ETC36 extends Activity {

    public String data;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    ImageView imgbtn1;
    String tt1 , tt2 , tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etc36);
      injiexi();
    Json();
    imgbtn1 = findViewById(R.id.imageButton);
    imgbtn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Json();
        }
    });






    }

    private void injiexi() {
        t1 = findViewById(R.id.tvD1);
        t2 = findViewById(R.id.tvD2);
        t3 = findViewById(R.id.tvD3);
        t4 = findViewById(R.id.tvD4);
        t5 = findViewById(R.id.tvD5);
        t6 = findViewById(R.id.tvD6);
        t7 = findViewById(R.id.tvD7);
        t8 = findViewById(R.id.tvD8);
        t9 = findViewById(R.id.tvD9);
        t10 = findViewById(R.id.tvD10);
    }

    public void Json(){
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        Request request = new Request.Builder()
                .url("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/zaikerenshu")
                .post(RequestBody.create(mediaType,""))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                data=response.body().string();
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        });
    }
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    try {
                        JSONObject jsonObject = new JSONObject(data);
                        String a=jsonObject.getString("data");
                        JSONArray jsonArray = new JSONArray(a);
                        for (int i =0;i<jsonArray.length();i++){
                            String b=jsonArray.getString(i);
                            JSONObject jsonObject1=new JSONObject(b);
                            if (i == 0){
                                tt1 = jsonObject1.getString("num");
                                tt2 = jsonObject1.getString("renshu");

                            }
                            if (i == 1){
                                tt3 = jsonObject1.getString("num");
                                tt4 = jsonObject1.getString("renshu");

                            }
                            if (i == 2){
                                tt5 = jsonObject1.getString("num");
                                tt6 = jsonObject1.getString("renshu");

                            }
                            if (i == 3){
                                tt7 = jsonObject1.getString("num");
                                tt8 = jsonObject1.getString("renshu");

                            }
                            if (i == 4){
                                tt9 = jsonObject1.getString("num");
                               tt10 = jsonObject1.getString("renshu");

                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    t1.setText(tt1);
                    t2.setText(tt2);
                    t3.setText(tt3);
                    t4.setText(tt4);
                    t5.setText(tt5);
                    t6.setText(tt6);
                    t7.setText(tt7);
                    t8.setText(tt8);
                    t9.setText(tt9);
                    t10.setText(tt10);






                    break;
            }
        }
    };

//    private void injiexi() {
//        Log.d(".","---------------------------------");
//        final OkHttpClient okHttpClient = new OkHttpClient();
//        final MediaType mediaType = MediaType.parse(" application/json; charset=utf-8");
//
//        new Thread(){
//            @Override
//            public void run() {
//            Request request = new Request.Builder().url("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/zaikerenshu")
//                    .post(RequestBody.create(mediaType,""))
//                    .build();
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//            String date = response.body().string();
//            jie(date);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//            }
//        };
//    }
//    public void jie(String date){
//
//
//    }


}

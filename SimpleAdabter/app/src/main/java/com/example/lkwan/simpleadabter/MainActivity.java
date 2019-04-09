package com.example.lkwan.simpleadabter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
   int AK_Ok=0;
    List <Map <String, Object>> listb;
    ListView listView;



    private String[] names = new String[]{"l路", "2路", "3路","4路"};
    private String[] says = new String[]{"成都--北京", "成都--天津", "成都--南京","成都--东京"};
    private  String[] wang =new String[]{"6:00--7:00","6:00--7:00","6:00--7:00","6:00--7:00"};
    private int[] imgIds = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        listView = findViewById( R.id.listView );

        listb = new ArrayList <Map <String, Object>>();
        SimpleAdapter simpleAdapter = new SimpleAdapter( this, getData(), R.layout.layout, new String[]{"name", "says","wang","touxiang"}, new int[]{R.id.cheng1,R.id.wang,R.id.timer, R.id.cheng2} );

        listView.setAdapter( simpleAdapter );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int postion, long l) {
                Intent intent=new Intent(MainActivity.this,Ding.class );
                intent.putExtra( "adrres",says[postion] );
                startActivity( intent );
                String a = says[postion];
          SharedPreferencesUtils.saveString( MainActivity.this,"adress",a );



            }
        } );
    }

    public List <Map <String, Object>> getData() {

        Map <String, Object> map = new HashMap <String, Object>();
        for (int i = 0; i < names.length; i++) {
            Map <String, Object> showitem = new HashMap <String, Object>();
            showitem.put( "touxiang", imgIds[i] );
            showitem.put( "name", names[i] );
            showitem.put( "says", says[i] );
            showitem.put( "wang",wang[i] );
            listb.add( showitem );
        }
        //创建一个simp


        return listb;

    }

}
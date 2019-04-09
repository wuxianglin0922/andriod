package com.example.lkwan.simpleadabter;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class List extends Activity {
    ListView oklist;
    Sqlite sqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.list );
         sqlite=new Sqlite( this );
        oklist= findViewById( R.id.list_ok );
        SQLiteDatabase db=openOrCreateDatabase("money.db",MODE_PRIVATE,null);
        Cursor cursor=db.rawQuery("Select*from money",null);
        ArrayList<Map<String,Object>>arrayList=new ArrayList <Map<String, Object>>(  );
        while (cursor.moveToNext()){
            Map<String,Object> data=new HashMap <>()  ;
            data.put( "name",cursor.getString( 1 ) );
            data.put( "timer",cursor.getString( 2 ) );
            data.put( "adress",cursor.getString( 3 ) );
            data.put( "phone",cursor.getString( 4 ) );
            arrayList.add( data );

        }
        if (arrayList==null||arrayList.size()==0){
            Toast.makeText( getApplicationContext(),"没有数据",Toast.LENGTH_SHORT ).show();
        }else {
            SimpleAdapter simpleAdapter=new SimpleAdapter( List.this,arrayList,R.layout.mode,new String[]{"name","timer","adress","phone"},new int[]{R.id.text1,R.id.text2,R.id.text3,R.id.text4} );
            oklist.setAdapter( simpleAdapter );
        }



    }
}

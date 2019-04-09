package com.example.lkwan.simpleadabter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Okding extends Activity {
    TextView phone,adress,name,wangt,textw;
    String name1,phone1,adress1,data;
    Button btn2,btn3;
    Sqlite sqlite;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.okbing );
        wangt= findViewById( R.id.wang );
        btn3=findViewById( R.id.cha );
     phone= findViewById( R.id.phone );
         adress= findViewById( R.id.adress );
         name= findViewById( R.id.name );
       btn2=  findViewById( R.id.chaxun );
       textw=findViewById( R.id.timer );
        sqlite=new Sqlite( this );
        final Intent intent=getIntent();
        name1= intent.getStringExtra( "name" );
         phone1= intent.getStringExtra( "phone1" );
         adress1= intent.getStringExtra( "adress1" );
        phone.setText( phone1 );
        name.setText( name1 );
        adress.setText( adress1 );
        String as=SharedPreferencesUtils.getString( Okding.this,"adress","" );
     data=  SharedPreferencesUtils.getString( Okding.this,"date","" );
        wangt.setText( as );
        textw.setText( data );
btn3.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent1=new Intent( Okding.this,List.class );
        startActivity( intent1 );
    }
} );
        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              ;
Sqlite( sqlite.getReadableDatabase(),name1,phone1,adress1 ,data);
            }
        } );

    }
    public  void Sqlite(SQLiteDatabase db,String name,String timer,String adress,String phone){
        ContentValues contentValues=new ContentValues(  );
        contentValues.put( "name" ,name);
        contentValues.put( "timer" ,timer);
        contentValues.put( "adress" ,adress);
        contentValues.put( "phone" ,phone);
        db.insert( "money",null,contentValues );
    }
}

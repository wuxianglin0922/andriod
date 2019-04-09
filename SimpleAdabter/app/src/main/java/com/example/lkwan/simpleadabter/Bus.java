package com.example.lkwan.simpleadabter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Bus extends Activity {
    TextView texrt;
    DatePicker data;
    Button nexti;
    int year, month, day;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.bus );
        data = findViewById( R.id.data );
        texrt = findViewById( R.id.nextv );
        nexti = findViewById( R.id.nexti );
        Calendar cal = Calendar.getInstance();
        //获取年月日秒
        year = cal.get( Calendar.YEAR );
        month = cal.get( Calendar.MONTH ) + 1;//Calendar的月因为默认月份从0开始
        day = cal.get( Calendar.DAY_OF_MONTH );//当月几日


        nexti.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String data=  texrt.getText().toString().trim();
              SharedPreferencesUtils.saveString( Bus.this,"date",data );
                 intent = new Intent( Bus.this, Bing.class );

                startActivity( intent );
            }
        } );
        data.init( year, month, day, new DatePicker.OnDateChangedListener() {


            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
           Bus.this.year=i;
                Bus.this.month=i1+1;
                Bus.this.day=i2;
                texrt.setText( year+"-"+month+"-"+day );

            }
        } );
    }
}

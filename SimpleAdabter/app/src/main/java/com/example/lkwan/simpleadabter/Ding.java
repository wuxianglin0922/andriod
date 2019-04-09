package com.example.lkwan.simpleadabter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Ding extends Activity {
    String data;
    TextView textView;
    ImageView tian;
    Button button;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.ding );
        Intent intent=getIntent();
       data= intent.getStringExtra( "adrres" );
      textView= findViewById( R.id.wangzi );
      textView.setText( data );
     tian= findViewById( R.id. tian);
     button= findViewById( R.id.next );
     button.setOnClickListener( new View.OnClickListener() {
         @Override
         public void onClick(View view) {
Intent intent1=new Intent( Ding.this,Bus.class );
startActivity( intent1 );
         }
     } );

    }
}

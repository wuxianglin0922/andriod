package com.example.lkwan.simpleadabter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Bing extends Activity {
    TextView view1;

    Button btn;
    EditText adress ,name,phone;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.bing );

       view1= findViewById( R.id.wangh );
 String as=SharedPreferencesUtils.getString( Bing.this,"adress","" );
 view1.setText( as );

initDate(  );
initValue();

    }
    public  void initDate(){
       btn= findViewById( R.id.btn );
    adress= findViewById( R.id.adress );
         name= findViewById( R.id.name );
         phone= findViewById( R.id.phone );

    }
    public void initValue(){
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           String adress1=     adress.getText().toString().trim();
                String name1=     name.getText().toString().trim();
                String phone1=     phone.getText().toString().trim();
                Intent intent=new Intent( Bing.this,Okding.class );
                intent.putExtra( "name",name1 );
                intent.putExtra( "phone1",phone1 );
                intent.putExtra( "adress1",adress1 );

                startActivity( intent );

            }
        } );

    }


}

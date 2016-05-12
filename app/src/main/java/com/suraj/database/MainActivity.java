package com.suraj.database;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView tvdisp;
    Button btnadd;
    Button btndelete;
    Button tv1,tv2,tv3,tv4,tv5;
    EditText etproduct;
    EditText etnumber;

    MyDBHandler myDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd = (Button) findViewById(R.id.btnadd);
        btndelete = (Button) findViewById(R.id.btndel);
        etproduct = (EditText) findViewById(R.id.etproduct);
        etnumber = (EditText) findViewById(R.id.etnumber);

        tv1 = (Button) findViewById(R.id.tv1);
        tv2 = (Button) findViewById(R.id.tv2);
        tv3 = (Button) findViewById(R.id.tv3);
        tv4 = (Button) findViewById(R.id.tv4);
        tv5 = (Button) findViewById(R.id.tv5);


        myDBHandler = new MyDBHandler(this, null, null, 1);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product= new Product(etproduct.getText().toString(), etnumber.getText().toString());
                myDBHandler.addproduct(product);
                disp();
            }
        });

        disp();

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + myDBHandler.getdatabasestring1()[0]));
                startActivity(intent);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+myDBHandler.getdatabasestring1()[1]));
                startActivity(intent);
            }
        });


        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+myDBHandler.getdatabasestring1()[2]));
                startActivity(intent);
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+myDBHandler.getdatabasestring1()[3]));
                startActivity(intent);
            }
        });


        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+myDBHandler.getdatabasestring1()[4]));
                startActivity(intent);
            }
        });


    }



    public void disp()
    {
        if(myDBHandler.getdatabasestring()[0]==null)
            return;
        tv1.setText(myDBHandler.getdatabasestring()[0]);
        tv2.setText(myDBHandler.getdatabasestring()[1]);
        tv3.setText(myDBHandler.getdatabasestring()[2]);
        tv4.setText(myDBHandler.getdatabasestring()[3]);
        tv5.setText(myDBHandler.getdatabasestring()[4]);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

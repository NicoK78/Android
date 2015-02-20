package com.example.nkervoern.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    int countAct = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, getString(R.string.hey), Toast.LENGTH_LONG).show();
        //Log.i("tag1", getString(R.string.hey));
        setContentView(R.layout.newlayout);
        if(savedInstanceState != null) {
            countAct = savedInstanceState.getInt("count") + 1;
            String str = String.valueOf(countAct)+" "+getString(R.string.step);
            if (countAct > 1)
                str += "s";
            Button tv = (Button) findViewById(R.id.button);
            //tv.setText(savedInstanceState.getString(String.valueOf("count")));
            tv.setText(str);
        }
        //final ListView listView = (ListView)findViewById(android.R.id.list);
        //listView.setEmptyView(findViewById(android.R.id.list));



        /*
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd/MM");
        Calendar rightNow = Calendar.getInstance();
        sdf.setTimeZone(rightNow.getTimeZone());
        String[] days = new String[7];
        for(int i = 0; i < 7; i++) {
            rightNow.add(Calendar.DAY_OF_MONTH, 1);
            days[i] = sdf.format(rightNow.getTimeInMillis());
        }

        final ArrayAdapter<String> adapter  =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,  days);

        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.setAdapter(adapter);
            }
        }, 5000);*/
        //sdf.getTimeZone(rightNow.getTimeInMillis());


        //Log.i("tag2", sdf.format(rightNow.getTime()));




        /*setContentView(R.layout.activity_main);
        TextView tv;
        tv = (TextView)findViewById(R.id.tv);
        tv.setTextSize(50);
        tv.setText("YOOOOOOO");
        tv.setText("<h1>HEY !</h1>");
        tv.setText(Html.fromHtml("<h1><u><i>HEY !</i></u></h1>"));

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView)findViewById(R.id.tv);
                tv.setBackgroundColor(Color.BLACK);
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d("tests", "onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d("tests", "onOptionsItemSelected");
        Intent intent = new Intent(MainActivity.this, ScdActivity.class);
        startActivity(intent);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clicAction(View view) {

        Intent intent = new Intent(MainActivity.this, ScdActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count", countAct);
    }
}

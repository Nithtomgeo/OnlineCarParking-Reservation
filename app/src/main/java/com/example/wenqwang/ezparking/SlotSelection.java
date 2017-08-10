package com.example.wenqwang.ezparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SlotSelection extends AppCompatActivity implements View.OnClickListener{

    private Button but1,but2,but3,but4,but5,but6,but7,but8,but9,but10,but11,but12,but13,but14,but15,but16,
    but17,but18,but19,but20,but21,but22,but23,but24,but25,but26,but27,but28;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_selection);

        but1 = (Button)findViewById(R.id.but1);
        but2 = (Button)findViewById(R.id.but2);
        but3 = (Button)findViewById(R.id.but3);
        but4 = (Button)findViewById(R.id.but4);
        but5 = (Button)findViewById(R.id.but5);
        but6 = (Button)findViewById(R.id.but6);
        but7 = (Button)findViewById(R.id.but7);
        but8 = (Button)findViewById(R.id.but8);
        but9 = (Button)findViewById(R.id.but9);
        but10 = (Button)findViewById(R.id.but10);
        but11 = (Button)findViewById(R.id.but11);
        but12 = (Button)findViewById(R.id.but12);
        but13 = (Button)findViewById(R.id.but13);
        but14 = (Button)findViewById(R.id.but14);
        but15 = (Button)findViewById(R.id.but15);
        but16 = (Button)findViewById(R.id.but16);
        but17 = (Button)findViewById(R.id.but17);
        but18 = (Button)findViewById(R.id.but18);
        but19 = (Button)findViewById(R.id.but19);
        but20 = (Button)findViewById(R.id.but20);
        but21 = (Button)findViewById(R.id.but21);
        but22 = (Button)findViewById(R.id.but22);
        but23= (Button)findViewById(R.id.but23);
        but24 = (Button)findViewById(R.id.but24);
        but25 = (Button)findViewById(R.id.but25);
        but26 = (Button)findViewById(R.id.but26);
        but27= (Button)findViewById(R.id.but27);
        but28 = (Button)findViewById(R.id.but28);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);
        but10.setOnClickListener(this);
        but11.setOnClickListener(this);
        but12.setOnClickListener(this);
        but13.setOnClickListener(this);
        but14.setOnClickListener(this);
        but15.setOnClickListener(this);
        but16.setOnClickListener(this);
        but17.setOnClickListener(this);
        but18.setOnClickListener(this);
        but19.setOnClickListener(this);
        but20.setOnClickListener(this);
        but21.setOnClickListener(this);
        but22.setOnClickListener(this);
        but23.setOnClickListener(this);
        but24.setOnClickListener(this);
        but25.setOnClickListener(this);
        but26.setOnClickListener(this);
        but27.setOnClickListener(this);
        but28.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.but1:
                temp = but1.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but2:
                temp = but2.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but3:
                temp = but3.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but4:
                temp = but4.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but5:
                temp = but5.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but6:
                temp = but6.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but7:
                temp = but7.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but8:
                temp = but8.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but9:
                temp = but9.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but10:
                temp = but10.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but11:
                temp = but11.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but12:
                temp = but12.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but13:
                temp = but13.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but14:
                temp = but14.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but15:
                temp = but15.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but16:
                temp = but16.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but17:
                temp = but17.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but18:
                temp = but18.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but19:
                temp = but19.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but20:
                temp = but20.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but21:
                temp = but21.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but22:
                temp = but22.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but23:
                temp = but23.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but24:
                temp = but24.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but25:
                temp = but25.getText().toString();
                // Code for button 1 click
                break;

            case R.id.but26:
                temp = but26.getText().toString();
                // Code for button 2 click
                break;

            case R.id.but27:
                temp = but27.getText().toString();
                // Code for button 3 click
                break;
            case R.id.but28:
                temp = but28.getText().toString();
                // Code for button 1 click
                break;

        }
        Intent i =new Intent(SlotSelection.this,Confirmation.class);
        Bundle b = new Bundle();
        b.putString("area",temp);

        Bundle b1 = getIntent().getExtras();
        String value = null,value1 = null,value2 = null, value3 = null,value4= null,close = null;
        value = b1.getString("P");
        value1 = b1.getString("date");
        value2 = b1.getString("stime");
        value3 = b1.getString("etime");
        close = b1.getString("closest");

        Toast.makeText(SlotSelection.this,"You can choose the next nearest Parking Slot available : "+close,Toast.LENGTH_LONG).show();
        b.putString("P",value);
        b.putString("date",value1);
        b.putString("stime",value2);
        b.putString("etime",value3);
        //b.putString("closest",close);
        i.putExtras(b);
        finish();
        startActivity(i);
       // startActivity(new Intent(SlotSelection.this,Confirmation.class));
    }
}

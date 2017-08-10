package com.example.wenqwang.ezparking;

import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Booking extends AppCompatActivity implements View.OnClickListener {

    private Button date, start_time, end_tiem, search;
    private TextView Edate, Estart, Eend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        date = (Button)findViewById(R.id.date_selection);
        search = (Button)findViewById(R.id.Search);
        start_time = (Button)findViewById(R.id.start_time);
        end_tiem = (Button)findViewById(R.id.end_time);
        Edate = (TextView) findViewById(R.id.Edate);
        Estart = (TextView) findViewById(R.id.Estart);
        Eend = (TextView) findViewById(R.id.Eend);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("date_picker"));
        date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });
        start_time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DialogFragment newFragment = new StimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
                }
        });
        end_tiem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DialogFragment newFragment = new EtimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
                }
        });

        search.setOnClickListener(this);

    }
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String type = intent.getStringExtra("type");
            if(type.equals("1")){
                String year = intent.getStringExtra("year");
                String month = intent.getStringExtra("month");
                String day = intent.getStringExtra("day");
                Edate.setText(month+"/"+day+"/"+year);
            }
            else if(type.equals("2")){
                String hour = intent.getStringExtra("hour");
                String minute = intent.getStringExtra("minute");
                Estart.setText(hour+":"+minute);
            }
            else if(type.equals("3")){
                String hour = intent.getStringExtra("hour");
                String minute = intent.getStringExtra("minute");
                Eend.setText(hour+":"+minute);
            }
        }
    };
    @Override
    protected void onDestroy() {
        // Unregister since the activity is about to be closed.
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }
    //@Override
    public void onClick(View view) {
        if(view == search) {
            finish();
            Intent i =new Intent(this,SlotSelection.class);
            Bundle b = new Bundle();
            b.putString("date",Edate.getText().toString());
            b.putString("stime",Estart.getText().toString());
            b.putString("etime",Eend.getText().toString());

            Bundle b1 = getIntent().getExtras();
            String value = null,close = null;
            value = b1.getString("P");
            close = b1.getString("closest");
            Toast.makeText(this,value,Toast.LENGTH_SHORT);
            b.putString("P",value);
            b.putString("closest",close);
            i.putExtras(b);
            finish();
            startActivity(i);
        }
    }
}

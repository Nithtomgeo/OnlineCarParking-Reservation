package com.example.wenqwang.ezparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Confirmation extends AppCompatActivity implements View.OnClickListener {

    private Button book;String emaili;
    private TextView text1,text2,text3,text4,text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        book = (Button)findViewById(R.id.button5);
        book.setOnClickListener(this);
        Bundle b = getIntent().getExtras();
        String value = null, temp1 = null, temp2 = null, temp3 = null, temp4 = null;
        if(b != null)
        {
            value = b.getString("P");
            temp1 = b.getString("date");
            temp2 = b.getString("stime");
            temp3 = b.getString("etime");
            temp4 = b.getString("area");
        }
        emaili = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        TextView  text1 = (TextView)findViewById(R.id.editText);
        TextView  text2 = (TextView)findViewById(R.id.editText2);
        TextView  text3 = (TextView)findViewById(R.id.editText3);
        TextView  text4 = (TextView)findViewById(R.id.editText4);
        TextView  text5 = (TextView)findViewById(R.id.editText5);
        text1.setText(emaili);
        text2.setText(value);
        text3.setText(temp4);
        text4.setText(temp1);
        text5.setText(temp2 + " - " + temp3 );

        FirebaseDatabase database = FirebaseDatabase.getInstance();


        String emailing = EncodeString(emaili);
        DatabaseReference myRef = database.getReference(emailing);
       // if(myRef.getParent().toString()== emailing) {
            myRef.child("Parking Area").push().setValue(value);
           // myRef.child("Parking Area").setValue(value);
            myRef.child("Parking Slot").push().setValue(temp4);
           // myRef.child("Parking Slot").push().setValue(temp4);
            myRef.child("Parking Date").push().setValue(temp1);
           // myRef.child("Parking Date").push().setValue(temp1);
            myRef.child("Parking Start Time").push().setValue(temp2);
           // myRef.child("Parking Start Time").push().setValue(temp2);
            myRef.child("Parking End Time").push().setValue(temp3);
           // myRef.child("Parking End Time").push().setValue(temp3);
        //}
    }

    @Override
    public void onClick(View view) {
        if(view == book)
        {
            finish();
            startActivity(new Intent(this,Profile.class));
        }
    }

    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }

}

package com.example.wenqwang.ezparking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private Button buttonRegister;
    private EditText edittextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    public boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        edittextEmail = (EditText)findViewById(R.id.editTextemail);
        editTextPassword = (EditText)findViewById(R.id.editTextpassword);
        editTextConfirmPassword = (EditText)findViewById(R.id.editConfirmpassword);

        buttonRegister.setOnClickListener(this);
    }

    private void registerUser(){

        String email = edittextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmpassword = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){

            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(confirmpassword)){

            Toast.makeText(this,"Please confirm your password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!(editTextPassword.getText().toString().trim().equals(editTextConfirmPassword.getText().toString().trim()))){

            Toast.makeText(this,"Passwords don't match. Please re-enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                               flag = true;
                            progressDialog.cancel();
                            FirebaseAuth.getInstance().signOut();
                            finish();
                            startActivity(new Intent(Register.this, Login.class));
                        //    return;
                        }
                        else
                            Toast.makeText(Register.this,"Registeration Unsuccessful",Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();
                    }
                });

    }
    @Override
    public void onClick(View view) {

        if(view == buttonRegister) {
            registerUser();


            if (FirebaseAuth.getInstance().getCurrentUser()!=null) {
                /*FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, Login.class));*/
            }
        }
    }
}






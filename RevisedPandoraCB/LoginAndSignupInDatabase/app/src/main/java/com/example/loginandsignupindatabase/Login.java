package com.example.loginandsignupindatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername,etPassword;
    TextView tvRegisterLink;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink =(TextView) findViewById(R.id.tvRegisterLink);
        userLocalStore = new UserLocalStore(this);
        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.bLogin:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                User user = new User(username, password);
                authenticate(user);
                break;
            case R.id.tvRegisterLink:

                startActivity(new Intent(this, Register.class));
                break;
        }
    }
    private void authenticate(User user){

        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.fetchUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if(returnedUser == null){
                    showErrorMessage(returnedUser);
                }else {
                    logUserIn(returnedUser);
                }
            }
        });
    }
    private void showErrorMessage(User user){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Login.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("OK",null);
        dialogBuilder.show();
    }
    private void logUserIn(User returnedUser){
        userLocalStore.storedUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);
        startActivity(new Intent(this,MainActivity.class));

    }
}

package com.cebs.computergeek;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminActivity extends AppCompatActivity {
    private EditText txtEmail,txtPassword;
    private Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        onLogin();
    }

    private void onLogin()
    {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=txtEmail.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();
                if (email.length()==0)
                {
                    txtEmail.setError("Mandatory Field");
                }
                else if (password.length()==0)
                {
                    txtPassword.setError("Mandatory Field");
                }
                else if (password.length()<4)
                {
                    txtPassword.setError("Password must at least 4 characters");
                }
                else if (email.equals(getString(R.string.email))&&password.equals(getString(R.string.password)))
                {
                    Intent intent=new Intent(AdminActivity.this,AdminMainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(AdminActivity.this);
                    alertDialog.setTitle(R.string.error);
                    alertDialog.setMessage(R.string.message);
                    alertDialog.setCancelable(true);
                    alertDialog.show();

                }
            }
        });

    }
}

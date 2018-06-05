package com.cebs.computergeek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnAdmin,btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onbuttonclick();

    }

    private void onbuttonclick() {
        btnAdmin=(Button)findViewById(R.id.btnAdmin);
        btnStudent=(Button)findViewById(R.id.btnStudent);
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,AdminActivity.class);
                startActivity(intent);
            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Student.class);
                startActivity(intent);
            }
        });

    }
}

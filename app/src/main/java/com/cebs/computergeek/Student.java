package com.cebs.computergeek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Student extends AppCompatActivity {
    private Spinner quiztype;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student2);
        quiztype=(Spinner)findViewById(R.id.quiztype);
        btnStart=(Button)findViewById(R.id.btnStart);
    }
    public void startQuiz(View view)
    {
        if(view==btnStart) {
            String q = quiztype.getSelectedItem().toString();
            switch (q) {
                case "Java Quiz":
                    Intent intent = new Intent(this, StudentActivity.class);
                    intent.putExtra("quiztype", q);
                    startActivity(intent);
                    break;

                case "C Quiz":
                    intent = new Intent(this, StudentActivity.class);
                    intent.putExtra("quiztype", q);
                    startActivity(intent);
                    break;

                case "C++ Quiz":
                    intent = new Intent(this, StudentActivity.class);
                    intent.putExtra("quiztype", q);
                    startActivity(intent);
                    break;
                case "Hadoop Quiz":
                    intent = new Intent(this, StudentActivity.class);
                    intent.putExtra("quiztype", q);
                    startActivity(intent);
                    break;
                default:
                    Toast.makeText(this, "Please select a Quiz", Toast.LENGTH_LONG).show();
                    break;
            }
        }

    }
}

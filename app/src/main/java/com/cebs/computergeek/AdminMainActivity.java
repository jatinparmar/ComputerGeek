package com.cebs.computergeek;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminMainActivity extends AppCompatActivity {

    private EditText txtQuestion,txtOption1,txtOption2,txtOption3,txtOption4,txtAnswer;
    private Button btnAdd;
    private Spinner quizes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);


        initcomponents();
        onAddQuestions();


    }

    private void initcomponents() {
        txtQuestion=(EditText)findViewById(R.id.txtQuestion);
        txtOption1=(EditText)findViewById(R.id.txtOption1);
        txtOption2=(EditText)findViewById(R.id.txtOption2);
        txtOption3=(EditText)findViewById(R.id.txtOption3);
        txtOption4=(EditText)findViewById(R.id.txtOption4);
        txtAnswer=(EditText)findViewById(R.id.txtAnswer);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        quizes=(Spinner)findViewById(R.id.quizes);
    }

    private void onAddQuestions() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question question=new Question();
                question.setQuestion(txtQuestion.getText().toString());
                question.setOption1(txtOption1.getText().toString());
                question.setOption2(txtOption2.getText().toString());
                question.setOption3(txtOption3.getText().toString());
                question.setOption4(txtOption4.getText().toString());
                question.setAnswer(txtAnswer.getText().toString());

                if(quizes.getSelectedItem().toString().equals("Java Quiz"))
                {
                    QuestionBank.javaquiz.add(question);
                    Toast.makeText(AdminMainActivity.this,"Java Questions are Added Successfully !",Toast.LENGTH_SHORT).show();
                    clearFields();
                }
                else if(quizes.getSelectedItem().toString().equals("C Quiz"))
                {
                    QuestionBank.cquiz.add(question);
                    Toast.makeText(AdminMainActivity.this,"C Questione are Added Successfully !",Toast.LENGTH_SHORT).show();
                    clearFields();
                }
                else if (quizes.getSelectedItem().toString().equals("C++ Quiz"))
                {
                    QuestionBank.cplusquiz.add(question);
                    Toast.makeText(AdminMainActivity.this,"C++ Questions are Added Successfully !",Toast.LENGTH_SHORT).show();
                    clearFields();
                }
                else if (quizes.getSelectedItem().toString().equals("Hadoop Quiz"))
                {
                    QuestionBank.hadoopquiz.add(question);
                    Toast.makeText(AdminMainActivity.this,"Hadoop Questions are Added Successfully !",Toast.LENGTH_SHORT).show();
                    clearFields();
                }

            }
        });


    }
    public void clearFields(){
        txtQuestion.setText("");
        txtOption1.setText("");
        txtOption2.setText("");
        txtOption3.setText("");
        txtOption4.setText("");
        txtAnswer.setText("");
        txtQuestion.requestFocus();
    }
}

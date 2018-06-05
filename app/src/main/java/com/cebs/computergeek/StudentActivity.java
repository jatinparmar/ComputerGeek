package com.cebs.computergeek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
    ArrayList<Question> questions=null;
    private RadioGroup options;
    private Button btnPrev,btnNext;
    private Question q;
    private int index;
    int score=0;

    private TextView title,txtQuestion;
    private RadioButton option1,option2,option3,option4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        options=(RadioGroup)findViewById(R.id.options);
        title=(TextView)findViewById(R.id.viewTitle);
        txtQuestion=(TextView)findViewById(R.id.viewQuestion);
        option1=(RadioButton)findViewById(R.id.option1);
        option2=(RadioButton)findViewById(R.id.option2);
        option3=(RadioButton)findViewById(R.id.option3);
        option4=(RadioButton)findViewById(R.id.option4);
        btnPrev=(Button)findViewById(R.id.btnPrevious);
        btnNext=(Button)findViewById(R.id.btnNext);
        Bundle bundle= getIntent().getExtras();
        String type= bundle.getString("quiztype");
        title.setText(type);
        if(type.equals("Java Quiz"))
            questions=QuestionBank.javaquiz;
        else if (type.equals("C Quiz"))
            questions=QuestionBank.cquiz;
        else if (type.equals("C++ Quiz"))
            questions=QuestionBank.cplusquiz;
        else if (type.equals("Hadoop Quiz"))
            questions=QuestionBank.hadoopquiz;
        if(questions!=null && questions.size()>0)
        {
            q=questions.get(index);
            txtQuestion.setText(q.getQuestion());
            option1.setText(q.getOption1());
            option2.setText(q.getOption2());
            option3.setText(q.getOption3());
            option4.setText(q.getOption4());
        }
        configurebutton();
    }

    private void configurebutton() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton button=(RadioButton)findViewById(options.getCheckedRadioButtonId());
                if(button.getText().toString().equals(q.getAnswer())){
                    score++;
                }
                index++;
                if(questions!=null && questions.size()>0 && index<questions.size())
                {
                    q=questions.get(index);                     //q is our current question reference....
                    txtQuestion.setText(q.getQuestion());
                    option1.setText(q.getOption1());
                    option2.setText(q.getOption2());
                    option3.setText(q.getOption3());
                    option3.setText(q.getOption4());

                    //if(q.getAnswer().equals())


                }
                else
                {
                    Intent intent=new Intent(StudentActivity.this,ResultActivity.class);
                    Bundle b=new Bundle();
                    b.putInt("score",score);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();

                   // Toast.makeText(StudentActivity.this,"There are no Questions left",Toast.LENGTH_LONG).show();
                }

            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0)
                {
                    index--;
                    Question q=questions.get(index);
                    txtQuestion.setText(q.getQuestion());
                    option1.setText(q.getOption1());
                    option2.setText(q.getOption2());
                    option3.setText(q.getOption3());
                    option3.setText(q.getOption4());
                    options.clearCheck();
                }
                else
                {
                    btnPrev.setEnabled(false);
                }


            }
        });
    }
}

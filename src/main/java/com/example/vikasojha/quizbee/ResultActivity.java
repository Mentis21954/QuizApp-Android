package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv, tv2;
    Button btnRestart;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        db = new DatabaseHelper(ResultActivity.this);

        tv = (TextView)findViewById(R.id.score);
        tv2 = (TextView)findViewById(R.id.highScore);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        if(QuestionsActivity.wrong == 3){
            db.addNewScore(QuestionsActivity.correct);
            int highScore = db.findHighScore();
            StringBuffer sb = new StringBuffer();
            sb.append("Correct answers: " + QuestionsActivity.correct + "\n");
            StringBuffer sb2 = new StringBuffer();
            sb2.append("High Score: " + highScore + "\n");
            tv.setText(sb);
            tv2.setText(sb2);
            tv2.setText(sb2);

            QuestionsActivity.correct=0;
            QuestionsActivity.wrong=0;
        }



        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }

}

package com.example.vikasojha.quizbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;


public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    TextView questionCount;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    ImageView falseX;
    ArrayList <Integer> numbers = new ArrayList();
    Random random = new Random();
    int flag = 0;
    int questionCounter = 1;

    String questions[] = {
                            "Ποια Αγγλική ομάδα έχει για γήπεδό της το Old Trafford;",
                            "Ποιος είναι ο πρώτος σκόρερ όλων των εποχών στην Ελλάδα;",
                            "Πόσα κύπελλα πρωταθλητριών και Τσάμπιονς Λιγκ έχει ο Άγιαξ;",
                            "Ποια χώρα έχει τις περισσότερες κατακτήσεις στο Τσάμπιονς Λίγκ;",
                            "Ποιος είναι ο πρώτος σκόρερ στην ιστορία του Champions League;",
                            "Ποιος ήταν ο πρώτος σκόρερ στη Super League για τη σεζόν 2021/22;",
                            "Η Τσέλσι στέφθηκε πρωταθλήτρια Ευρώπης νικώντας 1-0 τη Μάντσεστερ Σίτι. Ποιος ήταν ο σκόρερ του μοναδικού τέρματος του τελικού;",
                            "Ποια ήταν η πρώτη ευρωπαϊκή ομάδα του Ντιέγκο Μαραντόνα;",
                            "Ποιος είναι ο πρώτος σκόρερ στην ιστορία της Πρέμιερ Λιγκ;",
              /*10*/        "Πόσες κατακτήσεις EURO έχει η Ολλανδία;",
                            "Ποιο ήταν το σκορ στον τελικό Ισπανία-Ιταλία το Euro 2012 ;",
                            "Ποιος ποδοσφαιριστής κατέχει το ρεκόρ για τις περισσότερες ασίστ στην Πρέμιερ Λιγκ;",
                            "Η Μάντσεστερ Γιουνάιτεντ ποια ομάδα κέρδισε στον τελικό του Γιουρόπα Λιγκ το 2017;",
                            "Ποιος κέρδισε το βραβείο Man of the Match στον τελικό του Παγκοσμίου Κυπέλλου 2014;",
                            "Ποιος είναι ο τελευταίος Έλληνας ποδοσφαιριστής που έχει αγωνιστεί σε τελικό Champions League;",
                            "Ποιος είναι ο μοναδικός τερματοφύλακας που έχει κατακτήσει την Χρυσή Μπάλα;",
                            "Ποια ελληνική ποδοσφαιρική ομάδα ΔΕΝ έχει προπονήσει ο Ντούσαν Μπάγιεβιτς;",
                            "Σε ποια ελληνική ομάδα έχει αγωνιστεί ο Άλβαρο Ρεκόμπα;",
                            "Πόσα κύπελλα πρωταθλητριών έχει η Νότιχαμ Φόρεστ;",
              /*20*/        "Σε ποια ομάδα αγωνίστηκε μετά την Ρεάλ Μαδρίτης ο Μαρσέλο;",
                            "Ποιος από τους παρακάτω κορυφαίους Έλληνες ποδοσφαιριστές αποκαλούνταν Νουρέγιεφ",
                            "Πόσες φορές έχει κατακτήσει το Champions League η Ρεάλ Μαδρίτης;",
                            "Ποια σεζόν ο Ολυμπιακός έφτασε μέχρο τους 8 του Τσάμπιονς Λιγκ;"

                         };
    String answers[] = {"Μάντσεστερ Γιουνάιτεντ","Θωμάς Μαύρος","Τέσσερα","Ισπανία","Κριστιάνο Ρονάλντο",
            "Φαν Βερτ","Χάβερτζ","Μπαρτσελόνα","Άλαν Σίρερ","Μία","4-0","Ράιαν Γκιγκς","Άγιαξ","Μάριο Γκέτσε","Άκης Ζήκος",
            "Λεβ Γιασίν","Παναθηναϊκό","Πανιώνιο","Δύο","Ολυμπιακό","Βασίλης Χατζηπαναγής","14","1998-99"};
    String opt[] = {
                    "Μάντσεστερ Σίτι","Μάντσεστερ Γιουνάιτεντ","Μπρίστολ Σίτι","Νιουκάστλ",
                    "Δημήτρης Σαραβάκος","Θωμάς Μαύρος","Μίμης Δομάζος","Κριστόφ Βαζέχα",
                    "Κανένα","Ένα","Τρία","Τέσσερα",
                    "Αγγλία","Ιταλία","Ισπανία","Γερμανία",
                    "Λιονέλ Μέσσι","Μπενζεμά","Κριστιάνο Ρονάλντο","Ραούλ",
                    "Ελ Αραμπί","Αραούχο","Φαν Βερτ"," Παλάσιος",
                    "Ζορζίνιο","Βέρνερ","Χάβερτζ","Τιάγκο Σίλβα",
                    "Νάπολι","Μπαρτσελόνα","Σεβίλλη","Δεν έχει αγωνιστεί ποτέ σε ευρωπαϊκή ομάδα",
                    "Σέρχιο Αγκουέρο","Γουέιν Ρούνεϊ","Άλαν Σίρερ","Χάρι Κέιν",
                    "Μία","Δύο","Τρεις","Τέσσερις",
                    "2-0","3-0","4-0","6-2",
                    "Ποουλ Σκουλς","Φρανκ Λάμπαρντ", "Σεσκ Φάμπρεκας", "Ράιαν Γκιγκς",
                    "Τσέλσι","Βιγιαρεάλ","Άγιαξ", "Σεβίλλη",
                    "Μπάστιαν Σβάινσταϊγκερ","Sergio Aguero","Μάριο Γκέτσε","Λιονελ Μεσσι",
                    "Κώστας Τσιμίκας","Θοδωρής Ζαγοράκης", "Ντέμης Νικολαΐδης","Άκης Ζήκος",
                    "Λεβ Γιασίν","Μάνουελ Νόιερ","Όλιβερ Καν","Ίκερ Κασίγιας",
                    "ΠΑΟΚ","Ολυμπιακό","Παναθηναϊκό","Άρη",
                    "Ολυμπιακό","Παναθηναϊκό","Δόξα δράμα","Πανιώνιο",
                    "Κανένα","Ένα","Δύο","Τρία",
                    "Μπάγιερν Μονάχου","Κάντιθ","Ολυμπιακό","Μπόρμουθ",
                    "Βασίλης Χατζηπαναγής","Θωμάς Μαύρος","Γιώργος Κούδας","Μίμης Δομάζος",
                    "12","13","14","15",
                    "1996-97","1997-98","1998-99","1999-2000"

                   };


    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.scoreButton);
        questionCount =(TextView)findViewById(R.id.questionCounter);
        /*TextView name =(TextView)findViewById(R.id.playerName);
        Intent intent = getIntent();
        String player= intent.getStringExtra("playerName");

        if (player.trim().equals(""))
            name.setText("Hello User");
        else
            name.setText(player + "'s Turn");*/
        questionCount.setText("Question " + this.questionCounter);
        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        falseX = (ImageView)findViewById(R.id.falseX);

        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);

        while (numbers.size() < questions.length) {
            //Get Random numbers between range
            int randomNumber = random.nextInt((questions.length));
            //Check for duplicate values
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        tv.setText(questions[numbers.get(flag)]);
        rb1.setText(opt[4*numbers.get(flag)]);
        rb2.setText(opt[4*numbers.get(flag) + 1]);
        rb3.setText(opt[4*numbers.get(flag) + 2]);
        rb4.setText(opt[4*numbers.get(flag) + 3]);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Παρακαλώ επίλεξε μία απάντηση", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("FLAG" ,String.valueOf(flag));
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[numbers.get(flag)])) {
                    correct++;
                    Log.d("NUMBER OF CORRECTS",String.valueOf(correct));
                    Toast.makeText(getApplicationContext(), "Σωστό", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Λάθος", Toast.LENGTH_SHORT).show();
                    if (wrong == 1){
                        falseX.setVisibility(View.VISIBLE);
                    }else if(wrong == 2){
                        falseX.setImageResource(R.drawable.xx);
                        falseX.setVisibility(View.VISIBLE);
                    }else{
                        Intent in = new Intent(getApplicationContext(),GameOverActivity.class);
                        startActivity(in);
                    }

                }

                flag ++;

                if (score != null)
                    score.setText("Your Score: "+correct);

                if(flag < numbers.size())
                {
                    questionCounter++;
                    questionCount.setText("Question " + questionCounter);
                    tv.setText(questions[numbers.get(flag)]);
                    rb1.setText(opt[4*numbers.get(flag)]);
                    rb2.setText(opt[4*numbers.get(flag) + 1]);
                    rb3.setText(opt[4*numbers.get(flag) + 2]);
                    rb4.setText(opt[4*numbers.get(flag) + 3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
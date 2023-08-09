package com.example.bollywoodgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NextActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;
    Button btn0, commonButton, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnA,btnB,btnC,btnD,btnE,btnF,btnG,btnH,btnI,btnJ,btnK,btnL,btnM,btnN,btnO;
    Button btnP,btnQ,btnR,btnS,btnT,btnU,btnV,btnW,btnX,btnY,btnZ;
    Set<Character> movieSet;
    String nameOfMovie;
    String converted="";
    int guesserScore=0;
    int setterScore=0;
    TextView setterScoreTextView,guesserScoreTextView;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        mTextView = (TextView) findViewById(R.id.textView1);
        nameOfMovie=getIntent().getStringExtra("text").toUpperCase().trim();

        movieSet=new HashSet<>();
        for (int i=0;i<nameOfMovie.length();i++){
            movieSet.add(nameOfMovie.charAt(i));
        }


        for (int i=0;i<nameOfMovie.length();i++){
            if (nameOfMovie.charAt(i)==' '){
                //leave it as it is
                converted+=' ';
            }else{
                converted+='*';
            }
        }
        mTextView.setText(converted);

        builder = new AlertDialog.Builder(this);

        setterScoreTextView=(TextView) findViewById(R.id.setterScore);
        setterScoreTextView.setText(Integer.toString(setterScore));
        guesserScoreTextView=(TextView) findViewById(R.id.guesserScore);
        guesserScoreTextView.setText(Integer.toString(guesserScore));





        btn0=(Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2=(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3=(Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4=(Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5=(Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6=(Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7=(Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8=(Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9=(Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        btnA=(Button) findViewById(R.id.btnA);
        btnA.setOnClickListener(this);

        btnB=(Button) findViewById(R.id.btnB);
        btnB.setOnClickListener(this);

        btnC=(Button) findViewById(R.id.btnC);
        btnC.setOnClickListener(this);

        btnD=(Button) findViewById(R.id.btnD);
        btnD.setOnClickListener(this);

        btnE=(Button) findViewById(R.id.btnE);
        btnE.setOnClickListener(this);

        btnF=(Button) findViewById(R.id.btnF);
        btnF.setOnClickListener(this);

        btnG=(Button) findViewById(R.id.btnG);
        btnG.setOnClickListener(this);

        btnH=(Button) findViewById(R.id.btnH);
        btnH.setOnClickListener(this);

        btnI=(Button) findViewById(R.id.btnI);
        btnI.setOnClickListener(this);

        btnJ=(Button) findViewById(R.id.btnJ);
        btnJ.setOnClickListener(this);

        btn2=(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btnK=(Button) findViewById(R.id.btnK);
        btnK.setOnClickListener(this);

        btnL=(Button) findViewById(R.id.btnL);
        btnL.setOnClickListener(this);

        btnM=(Button) findViewById(R.id.btnM);
        btnM.setOnClickListener(this);

        btnN=(Button) findViewById(R.id.btnN);
        btnN.setOnClickListener(this);

        btnO=(Button) findViewById(R.id.btnO);
        btnO.setOnClickListener(this);

        btnP=(Button) findViewById(R.id.btnP);
        btnP.setOnClickListener(this);

        btnQ=(Button) findViewById(R.id.btnQ);
        btnQ.setOnClickListener(this);

        btnR=(Button) findViewById(R.id.btnR);
        btnR.setOnClickListener(this);

        btnS=(Button) findViewById(R.id.btnS);
        btnS.setOnClickListener(this);

        btnT=(Button) findViewById(R.id.btnT);
        btnT.setOnClickListener(this);

        btnU=(Button) findViewById(R.id.btnU);
        btnU.setOnClickListener(this);

        btnV=(Button) findViewById(R.id.btnV);
        btnV.setOnClickListener(this);

        btnW=(Button) findViewById(R.id.btnW);
        btnW.setOnClickListener(this);

        btnX=(Button) findViewById(R.id.btnX);
        btnX.setOnClickListener(this);

        btnY=(Button) findViewById(R.id.btnY);
        btnY.setOnClickListener(this);

        btnZ=(Button) findViewById(R.id.btnZ);
        btnZ.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        char c='0';
        String character;
        switch (v.getId()) {
            case R.id.btn0:
                commonButton=(Button) findViewById(R.id.btn0);
                break;

            case R.id.btn1:
                commonButton=(Button) findViewById(R.id.btn1);
                break;
            case R.id.btn2:
                commonButton=(Button) findViewById(R.id.btn2);
                break;
            case R.id.btn3:
                commonButton=(Button) findViewById(R.id.btn3);
                break;

            case R.id.btn4:
                commonButton=(Button) findViewById(R.id.btn4);
                break;
            case R.id.btn5:
                commonButton=(Button) findViewById(R.id.btn5);
                break;
            case R.id.btn6:
                commonButton=(Button) findViewById(R.id.btn6);
                break;

            case R.id.btn7:
                commonButton=(Button) findViewById(R.id.btn7);
                break;
            case R.id.btn8:
                commonButton=(Button) findViewById(R.id.btn8);
                break;
            case R.id.btn9:
                commonButton=(Button) findViewById(R.id.btn9);
                break;
            case R.id.btnA:
                commonButton=(Button) findViewById(R.id.btnA);
                break;
            case R.id.btnB:
                commonButton=(Button) findViewById(R.id.btnB);
                break;

            case R.id.btnC:
                commonButton=(Button) findViewById(R.id.btnC);
                break;
            case R.id.btnD:
                commonButton=(Button) findViewById(R.id.btnD);
                break;
            case R.id.btnE:
                commonButton=(Button) findViewById(R.id.btnE);
                break;
            case R.id.btnF:
                commonButton=(Button) findViewById(R.id.btnF);
                break;
            case R.id.btnG:
                commonButton=(Button) findViewById(R.id.btnG);
                break;
            case R.id.btnH:
                commonButton=(Button) findViewById(R.id.btnH);
                break;
            case R.id.btnI:
                commonButton=(Button) findViewById(R.id.btnI);
                break;

            case R.id.btnJ:
                commonButton=(Button) findViewById(R.id.btnJ);
                break;
            case R.id.btnK:
                commonButton=(Button) findViewById(R.id.btnK);
                break;
            case R.id.btnL:
                commonButton=(Button) findViewById(R.id.btnL);
                break;

            case R.id.btnM:
                commonButton=(Button) findViewById(R.id.btnM);
                break;
            case R.id.btnN:
                commonButton=(Button) findViewById(R.id.btnN);
                break;
            case R.id.btnO:
                commonButton=(Button) findViewById(R.id.btnO);
                break;

            case R.id.btnP:
                commonButton=(Button) findViewById(R.id.btnP);
                break;
            case R.id.btnQ:
                commonButton=(Button) findViewById(R.id.btnQ);
                break;

            case R.id.btnR:
                commonButton=(Button) findViewById(R.id.btnR);
                break;
            case R.id.btnS:
                commonButton=(Button) findViewById(R.id.btnS);
                break;
            case R.id.btnT:
                commonButton=(Button) findViewById(R.id.btnT);
                break;

            case R.id.btnU:
                commonButton=(Button) findViewById(R.id.btnU);
                break;
            case R.id.btnV:
                commonButton=(Button) findViewById(R.id.btnV);
                break;
            case R.id.btnW:
                commonButton=(Button) findViewById(R.id.btnW);
                break;

            case R.id.btnX:
                commonButton=(Button) findViewById(R.id.btnX);
                break;
            case R.id.btnY:
                commonButton=(Button) findViewById(R.id.btnY);
                break;
            case R.id.btnZ:
                commonButton=(Button) findViewById(R.id.btnZ);
                break;
            default:
                break;
        }

        character=commonButton.getText().toString();
        c=character.charAt(0);



        if (movieSet.contains(c)) {
            Toast.makeText(getApplicationContext(),"Bingo! Right guess",Toast.LENGTH_SHORT).show();
            commonButton.setBackgroundColor(Color.GREEN);
            String newConverted="";
            for (int i=0;i<nameOfMovie.length();i++){
                char movieChar=nameOfMovie.charAt(i);
                if (c==movieChar){
                    newConverted+=c;
                    guesserScore++;
                }else{
                    if (nameOfMovie.charAt(i)==' '){
                        newConverted+=' ';
                    }else{
                        newConverted+=converted.charAt(i);
                    }
                }
            }
            converted=newConverted;
            mTextView.setText(converted);
            guesserScoreTextView.setText(Integer.toString(guesserScore));

            if (nameOfMovie.equals(converted)){
                if (guesserScore>setterScore){
                    int won=guesserScore-setterScore;
                    //guesser won the game
                    Toast.makeText(getApplicationContext(),"Hurrah! Guesser won the game  by "+won+" points",Toast.LENGTH_SHORT).show();

                    //Uncomment the below code to Set the message and title from the strings.xml file
                    builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                    //Setting message manually and performing action on button click
                    builder.setMessage("Guesser="+guesserScore+"    Setter="+setterScore+"\n\nPlay again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                    Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
                                    Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Hurray! Guesser won the game");
                    alert.show();

                }else if (setterScore>guesserScore){
                    //setter won the game
                    int won=setterScore-guesserScore;
                    Toast.makeText(getApplicationContext(),"Hurrah! Setter won the game by "+won+" points",Toast.LENGTH_SHORT).show();

                    builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                    //Setting message manually and performing action on button click
                    builder.setMessage("Guesser="+guesserScore+"    Setter="+setterScore+"\n\nPlay again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                    Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
                                    Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Hurray! Setter won the game");
                    alert.show();

                }else{
                    //game tie
                    Toast.makeText(getApplicationContext(),"It's a draw",Toast.LENGTH_SHORT).show();

                    builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                    //Setting message manually and performing action on button click
                    builder.setMessage("Guesser="+guesserScore+"    Setter="+setterScore+"\n\nPlay again?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                    Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
                                    Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Lol! It's a draw");
                    alert.show();

                }
            }
            commonButton.setOnClickListener(null);

        }else{
            Toast.makeText(getApplicationContext(),"Sorry! Wrong guess",Toast.LENGTH_SHORT).show();
            commonButton.setBackgroundColor(Color.RED);
            setterScore++;
            setterScoreTextView.setText(Integer.toString(setterScore));
            commonButton.setOnClickListener(null);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
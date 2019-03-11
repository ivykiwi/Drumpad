package com.example.user.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    TextView Login;
    private Button btnn1, btnn2, btnn3, btnn4, btnn5, btnn6, btnn7, btnn8, btnn9, btnn10;
    private MediaPlayer btn1S, btn2S, btn3S, btn4S, btn5S, btn6S, btn7S, btn8S, btn9S;
    private int a;
    Button Base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Login = (TextView) findViewById(R.id.textView2);

        Intent Main = getIntent();

        String tlogin = Main.getStringExtra("tlogin");
        String tpass = Main.getStringExtra("tpass");

        Login.setText("Добро пожаловать " + tlogin);


        Base = (Button) findViewById(R.id.btn);
        View.OnClickListener BaseClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Main3 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(Main3);
            }
        };
        Base.setOnClickListener(BaseClick);


        btnn1 = (Button)findViewById(R.id.btn1);
        btnn2 = (Button)findViewById(R.id.btn2);
        btnn3 = (Button)findViewById(R.id.btn3);
        btnn4 = (Button)findViewById(R.id.btn4);
        btnn5 = (Button)findViewById(R.id.btn5);
        btnn6 = (Button)findViewById(R.id.btn6);
        btnn7 = (Button)findViewById(R.id.btn7);
        btnn8 = (Button)findViewById(R.id.btn8);
        btnn9 = (Button)findViewById(R.id.btn9);
        btnn10 = (Button)findViewById(R.id.btn10);

        btn1S = MediaPlayer.create(this, R.raw.s1);
        btn2S = MediaPlayer.create(this, R.raw.s2);
        btn3S = MediaPlayer.create(this, R.raw.s3);
        btn4S = MediaPlayer.create(this, R.raw.s4);
        btn5S = MediaPlayer.create(this, R.raw.s5);
        btn6S = MediaPlayer.create(this, R.raw.s6);
        btn7S = MediaPlayer.create(this, R.raw.s7);
        btn8S = MediaPlayer.create(this, R.raw.s8);
        btn9S = MediaPlayer.create(this, R.raw.s9);

        btnClick();
    }

    public void btnClick () {
        btnn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn1S);
                    }
                }
        );
        btnn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn2S);
                    }
                }
        );
        btnn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn3S);
                    }
                }
        );
        btnn4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn4S);
                    }
                }
        );
        btnn5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn5S);
                    }
                }
        );
        btnn6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn6S);
                    }
                }
        );
        btnn7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn7S);
                    }
                }
        );
        btnn8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn8S);
                    }
                }
        );
        btnn9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay (btn9S);
                    }
                }
        );
        a = 1;
        btnn10.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(a==1){
                            volumeOff(btn1S);
                            volumeOff(btn2S);
                            volumeOff(btn3S);
                            volumeOff(btn4S);
                            volumeOff(btn5S);
                            volumeOff(btn6S);
                            volumeOff(btn7S);
                            volumeOff(btn8S);
                            volumeOff(btn9S);
                            a = 0;
                            btnn10.setText("Включить звук");
                        } else if (a==0) {
                            volumeOn(btn1S);
                            volumeOn(btn2S);
                            volumeOn(btn3S);
                            volumeOn(btn4S);
                            volumeOn(btn5S);
                            volumeOn(btn6S);
                            volumeOn(btn7S);
                            volumeOn(btn8S);
                            volumeOn(btn9S);
                            a = 1;
                            btnn10.setText("Выключить звук");
                        }
                    }
                }
        );
    }

    public void soundPlay (MediaPlayer sound) {
        if (sound.isPlaying() == true) {
            sound.pause();
            sound.seekTo(0);
        }
        sound.start();
    };

    public void volumeOn (MediaPlayer sound) {
        sound.setVolume(1,1);
    };

    public void volumeOff (MediaPlayer sound) {
        sound.setVolume(0,0);
    };

}

package com.example.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int Minute;
    int Second;
    int second;
    String displayMinute;
    String displaySecond;
    TextView textView;

    public void Clicked(View view) {
        CountDownTimer countDownTimer = new CountDownTimer((Second+1) * 1000, 1000) {
            @Override
            public void onTick(long l) {
                Log.i("Seconds remaining", String.valueOf(l / 1000));
                Minute = (int) (l / 60000);
                second = (int) ((l - 60000 * Minute) / 1000);

                displayMinute = Integer.toString(Minute);
                displaySecond = Integer.toString(second);

                textView.setText(displayMinute + ":" + displaySecond);
                textView.setText(displayMinute + ":" + displaySecond);
            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tropical_v2);
                mediaPlayer.start();
            }
        };
        countDownTimer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Second = 300;

        textView = (TextView) findViewById(R.id.textView);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(600);
        seekBar.setProgress(Second);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Second = i;
                Minute = i / 60;
                second = i - 60 * Minute;
                displayMinute = Integer.toString(Minute);
                displaySecond = Integer.toString(second);
                textView.setText(displayMinute + ":" + displaySecond);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
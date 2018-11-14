package com.example.edu.thread_mainui;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textViewThreadValue;
    Button buttonThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewThreadValue = findViewById(R.id.textViewThreadValue);
        buttonThread = findViewById(R.id.buttonThread);
        buttonThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String TAG = "Error ThreadActivityTag";
        long endTime = System.currentTimeMillis() + 20 * 5000;
        Log.i(TAG, "Thread running !");

        TextView threadValue = (TextView)findViewById(R.id.textViewThreadValue);

        while (System.currentTimeMillis() < endTime){
            synchronized (this){
                Log.i(TAG, "Thread running !");
                threadValue.setText(String.valueOf(System.currentTimeMillis()));
            }
        }
    }
}


/*
    Thread

    돌림 합창


    인스턴스 -> 메모리에 올라가는거
    프로세스 -> Cpu 단위
        앱이 하나 올라가면 프로세스가 뜨면서 cpu일부를 점유
        프로세스는 관처럼 길게 생김
        CPU는 바늘처럼 생겨서 프로세스를 찍음

    쓰레드는 프로세스를 나누는 것

    프로세스는 쓰레드를 만든다.
    쓰레는 분단

    쓰레드는 while문과 비슷하다

    시작은 결정할 수 있으나 순서나 끝나는 거는 알아서 됨.

    activity가 뜨면 메인UI가 뜬다. activity마다
    activity 전담하는 MainUI  3자thread



    */
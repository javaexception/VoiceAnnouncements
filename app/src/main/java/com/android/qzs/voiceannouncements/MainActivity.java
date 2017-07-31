package com.android.qzs.voiceannouncements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.qzs.voiceannouncementlibrary.VoiceUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VoiceUtils.with(this).Play("1111",false);

    }
}

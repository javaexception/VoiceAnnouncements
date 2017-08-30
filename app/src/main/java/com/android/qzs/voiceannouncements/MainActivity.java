package com.android.qzs.voiceannouncements;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.qzs.voiceannouncementlibrary.VoiceUtils;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= (TextView) findViewById(R.id.tv);

             //普通用法
        VoiceUtils.with(this).Play("111",true);

        /*
      同时有很多语音一起接收，防止重叠
         */
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play("222.78");
            }
        });

    }

    private synchronized  void Play(final String str) {
        System.out.println("aDASDASDASDAD "+VoiceUtils.with(this).GetIsPlay());
        if (VoiceUtils.with(this).GetIsPlay()){
            System.out.println("正在播放语音 ");
            new Thread() {
                @Override
                public  void run() {
                    super.run();
                    try {
                        Thread.sleep(100);//休眠3秒
                        Play(str);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /**
                     * 要执行的操作
                     */
                }
            }.start();
        }else {
            System.out.println("不冲突");
            VoiceUtils.with(this).Play(str,true);
        }
    }

}

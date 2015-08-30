package com.busantoseoul.busan;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by NAVER on 2015-08-30.
 */
public class LoadingPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();       // 3 초후 이미지를 닫아버림
            }
        }, 2000);
    }
}

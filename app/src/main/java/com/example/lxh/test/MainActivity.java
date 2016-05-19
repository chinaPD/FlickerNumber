package com.example.lxh.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements RefreshTimerUtil.OnRefreshCallBack {

    private RefreshTimerUtil refreshTimerUtil;
    static String string = "149";
    private boolean flag=false;
    private FinalSurfaceView myTextView;
    private MySurfaceView mySurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (FinalSurfaceView) findViewById(R.id.tv_lxh);
        myTextView.setText("- -");
        mySurfaceView= (MySurfaceView) findViewById(R.id.mysurfaceview);
        refreshTimerUtil= new RefreshTimerUtil(this);
        refreshTimerUtil.startRefreshDelay();

    }

    private static String getRandomString(int length) {

        StringBuffer sb = new StringBuffer();

        int len = string.length();

        for (int i = 0; i < length; i++) {

            sb.append(string.charAt(getRandom(len - 1)));

        }
        return sb.toString();
    }
    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));

    }
    @Override
    public void onRefresh() {

//       int s= (int)(Math.random()*6)+1;
        int s=4;
        String temp=getRandomString(s)+"."+getRandomString(2);
        myTextView.setText(temp);
//        Log.i("TEST",temp);
        mySurfaceView.setText(".");
    }

    @Override
    public void onCancel() {

    }
}

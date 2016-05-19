package com.example.lxh.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * * 作者：lxh on 2016/5/10 09:21
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable {

    public String oldString ="";
    public String newString =".";

    /**
     * * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Rect mRect;
    private Paint mTextPaint;
    private int offset = 0;
    private boolean isrunning = true;
    private int maxOffset = 0;

    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private Thread t;
    private boolean isRunning;
    private int textsize=15;
    private boolean isFirst=false;

    public MySurfaceView(Context context,String num){
        super(context);
        isFirst=true;
        mHolder=getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        newString=num;
        mBound = new Rect();
        mTextPaint= new Paint();
        mTextPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,textsize,getResources().getDisplayMetrics()));

    if(newString.equals(".")){
        mTextPaint.getTextBounds("3", 0, newString.length(), mBound);
        mBound.right=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,3,getResources().getDisplayMetrics());
    }else {
        mTextPaint.getTextBounds("3", 0, newString.length(), mBound);
    }
    }



    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        isFirst=true;
        mHolder=getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        mBound = new Rect();
        mTextPaint=new Paint();
        mTextPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,25,getResources().getDisplayMetrics()));
        mTextPaint.getTextBounds(newString, 0, newString.length(), mBound);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        // 开启线程
        isRunning =true;
        t = new Thread(this);
        t.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {



    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        isRunning= false;
    }

    @Override
    public void run() {

        while (isRunning){
            long start = System.currentTimeMillis();
              draw();
            long end = System.currentTimeMillis();
            try
            {
                if (end - start < 20)
                {
                    Thread.sleep(20 - (end - start));
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    private void draw() {

        if(!isRunning){
            return;
        }
        try {
            mCanvas = mHolder.lockCanvas();
            if(isFirst){
                offset=maxOffset;
                isFirst=false;
            }
            if (mCanvas != null) {
                offset+=2;
                if(offset>=maxOffset){
                    offset=maxOffset;
                }
                mCanvas.drawColor(Color.WHITE);
                mTextPaint.setDither(true);
                mTextPaint.setAntiAlias(true);
                mTextPaint.setColor(Color.RED);

                mCanvas.drawText(newString,getMeasuredWidth() / 2 - mBound.width() / 2,getMeasuredHeight() / 2 + mBound.height() / 2+getMeasuredHeight()-offset,mTextPaint);

                mCanvas.drawText(oldString, getMeasuredWidth() / 2 - mBound.width() / 2, getMeasuredHeight() / 2 + mBound.height() / 2 - offset, mTextPaint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(mCanvas!=null){
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }

    public void setText(String news) {

        oldString = newString;
        newString = news;
        if (!oldString.equals(newString)) {
            offset=0;
        }
        isFirst=false;
//        mTextPaint.getTextBounds(news, 0, news.length(), mBound);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 设置icon的绘制范围
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            int desired =getPaddingLeft() + mBound.width() + getPaddingRight();
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            int desired = getPaddingTop() + mBound.height() + getPaddingBottom();
            height = desired;
        }
        mRect = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
        maxOffset=height;
        setMeasuredDimension(width, height);

    }

    public void setIsRunning(boolean run){

        isRunning=run;
    }

}

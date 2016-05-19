package com.example.lxh.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * * 作者：lxh on 2016/5/9 09:40
 */
public class MyTextView extends View {

    public String oldString = "";
    public String newString ="4";

    /**
     * * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Rect mRect;
    private Paint mPaint;
    private Paint mTextPaint;
    private int offset = 0;
    private boolean isrunning = true;
    private int maxOffset = 0;
    private boolean isFirst=false;

    public MyTextView(Context context,String num){
        super(context);

        mPaint = new Paint();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,20,getResources().getDisplayMetrics()));
        newString=num;
        mBound = new Rect();
        isFirst=true;
        if(newString.equals(".")){
            mTextPaint.getTextBounds("1", 0, newString.length(), mBound);
//            mBound.right=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,4,getResources().getDisplayMetrics());
        }else {
            mTextPaint.getTextBounds("3", 0, newString.length(), mBound);
            mBound.bottom=mBound.bottom+(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,1,getResources().getDisplayMetrics());
        }

    }
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,20,getResources().getDisplayMetrics()));
        mBound = new Rect();
        if(newString.equals(".")){
            mTextPaint.getTextBounds("3", 0, newString.length(), mBound);
            mBound.right=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,3,getResources().getDisplayMetrics());
        }else {
            mTextPaint.getTextBounds("3", 0, newString.length(), mBound);
        }
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

    // 0表示完全透明，255表示
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        mTextPaint.setDither(true);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.RED);
        if(isFirst){
            canvas.drawText(newString,getMeasuredWidth() / 2 - mBound.width() / 2,getMeasuredHeight() / 2 + mBound.height() / 2,mTextPaint);
            isFirst=false;
            return;
        }


        canvas.drawText(oldString, getMeasuredWidth() / 2 - mBound.width() / 2, getMeasuredHeight() / 2 + mBound.height() / 2 - offset, mTextPaint);
        canvas.drawText(newString,getMeasuredWidth() / 2 - mBound.width() / 2,getMeasuredHeight() / 2 + mBound.height() / 2+getMeasuredHeight()-offset,mTextPaint);
    }

    public void setText( String news) {
        oldString = newString;
        newString = news;
        if (!oldString.equals(newString)) {
            offset=0;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (offset < maxOffset) {
                    long start = System.currentTimeMillis();
                    long end = System.currentTimeMillis();
                    try {
                        if (end - start < 10) {
                            Thread.sleep(10 - (end - start));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    offset+=2;
                    postInvalidate();
                }
            }
        }).start();
    }
//    Bitmap mBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(),
//            Bitmap.Config.ARGB_8888);
//    Canvas mCanvas = new Canvas(mBitmap);
//    Log.i("TEST",mBound.height()+"--"+mBound.width());
//    mCanvas.drawRect(mBound,mPaint);
//      mCanvas.drawColor(Color.RED);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
//      BitmapDrawable lxh= (BitmapDrawable) getResources().getDrawable(R.mipmap.kwl_tab_mystock);
//      Bitmap s=lxh.getBitmap();
//        mPaint.setAlpha(255);
//        mCanvas.drawText(oldString, 0,0, mPaint);
//      mCanvas.drawBitmap(s,null,mRectdes,mPaint);
//    canvas.drawBitmap(mBitmap, 0, 0, null);
//        mPaint.setTextSize(40);
}

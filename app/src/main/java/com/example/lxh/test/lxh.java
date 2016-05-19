package com.example.lxh.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * * 作者：lxh on 2016/5/5 09:59
 */
public class lxh extends LinearLayout
{
    String oldString=null;
    private Context context;
    AlphaAnimation alphaAnimation;
    TranslateAnimation translateAnimation;
    public lxh(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        alphaAnimation= new AlphaAnimation(1f,0.1f);
        alphaAnimation.setDuration(400);
        translateAnimation = new TranslateAnimation(0,0,0,40);
        translateAnimation.setDuration(400);
    }

    ArrayList textViews = new ArrayList<>();
    public void setText( final String newString) {

        if(oldString==null) {
            oldString=newString;
            for (int i = 0; i <=newString.length() - 1; i++) {
                TextView textView = new TextView(context);
                textView.setTextSize(20);
                textView.setText(newString.substring(i,i+1));
                textViews.add(textView);
                addView(textView);
            }
            return;
        }
        for (int j=0;j<textViews.size();j++ ) {
            if(oldString.charAt(j)==newString.charAt(j)){
                return;
            }
            final TextView  text=(TextView) textViews.get(j);
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            text.startAnimation(animationSet);
            final int temp=j;
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    text.setText(newString.substring(temp,temp+1));
            }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        }
    }

}

package com.example.lxh.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * * 作者：lxh on 2016/5/10 10:43
 */
public class FinalSurfaceView extends LinearLayout {

    public String oldString = "";
    public String newString = "- -";
    public ArrayList<MyTextView> list=new ArrayList<>();
    public Context mContext;
    public FinalSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
           mContext=context;

           for(int i=0;i<newString.length();i++){
               MyTextView mySurfaceView= new MyTextView(context,newString.substring(i,i+1));
               list.add(mySurfaceView);
               LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
               params.gravity= Gravity.CENTER;
               if(newString.substring(i,i+1).equals(".")){
                   mySurfaceView.setPadding(0,0,0,0);
               }else{
                   mySurfaceView.setPadding(0,0,5,0);
               }
               addView(mySurfaceView,params);
           }

    }

    public void setText(String news) {
        oldString=newString;
        newString=news;
        if (oldString == null || newString == null) {
            return;
        }
        int oldLength = oldString.length();
        int newLength = newString.length();
         //说明数据的位数增加了
        if(newLength!=oldLength){
            removeAllViews();
            list.clear();
            for(int i=0;i<newString.length();i++){
                MyTextView mySurfaceView= new MyTextView(mContext,newString.substring(i,i+1));
                list.add(mySurfaceView);
                LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.gravity= Gravity.CENTER;
                mySurfaceView.setPadding(0,0,5,0);
                addView(mySurfaceView,params);

            }
//            for(int i=newLength-oldLength-1;i>=0;i--){
//                MySurfaceView mySurfaceView= new MySurfaceView(mContext,newString.substring(i,i+1));
//                list.add(0,mySurfaceView);
////                this.addView(mySurfaceView);
//            }
//            for (int i = newLength-oldLength; i < list.size(); i++) {
//                list.get(i).setText(newString.substring(i,i+1));
//            }
//        }else if(oldLength>newLength){
//             for(int i=0;i<oldLength-newLength;i++){
//                 this.removeView(list.get(0));
//                 list.remove(0);
//
//             }
//            for(int i=0;i<list.size();i++){
//                list.get(i).setText( newString.substring(i, i + 1));
//            }
        }else {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setText(newString.substring(i, i + 1));

            }
        }
    }


}

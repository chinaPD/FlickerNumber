package com.example.lxh.test;

import android.os.Handler;


/**
 * 定时刷新工具类,使用时实例化，并实现回调接口，即可在回调函数中实现定时任务
 * Created by Liaoch on 2016/4/27.
 */
public class RefreshTimerUtil {

    private long REFRESH_TIME = 2000;
    private OnRefreshCallBack onRefreshListener;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(runnable, REFRESH_TIME);
            onRefreshListener.onRefresh();
        }
    };

    public RefreshTimerUtil(OnRefreshCallBack onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }

    /**
     * 启动刷新延迟一次
     */
    public void startRefreshDelay() {
        handler.postDelayed(runnable, REFRESH_TIME);
    }

    /**
     * 启动刷新
     */
    public void startRefresh() {
        handler.postDelayed(runnable, 0);
    }

    /**
     * 停止刷新
     */
    public void stopRefresh() {
        handler.removeCallbacks(runnable);
        onRefreshListener.onCancel();
    }

    /**
     * 设置刷新间隔时间
     *
     * @param REFRESH_TIME 刷新时间
     */
    public void setREFRESH_TIME(long REFRESH_TIME) {
        this.REFRESH_TIME = REFRESH_TIME;
    }

    /**
     * 定时刷新回调接口
     */
    public interface OnRefreshCallBack {
        void onRefresh();

        void onCancel();
    }
}

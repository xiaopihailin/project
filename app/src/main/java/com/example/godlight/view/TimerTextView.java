package com.example.godlight.view;


import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.godlight.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Lzh on 2018/4/20.
 */
public class TimerTextView extends LinearLayout {
    private boolean run = false; //是否启动了
    private Timer timer;
    private TextView tvTime;
    private Context context;
    private int second;
    private String originalDes = "获取验证码";
    private String strStart = "剩余";
    private String strEnd = "秒";

    private final String TIME = "time";
    private final String CTIME = "ctime";

    public TimerTextView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public TimerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initUI(context);
    }

    public TimerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initUI(context);
    }

    public void initUI(Context context) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.include_timer, null);
        tvTime = (TextView) myView.findViewById(R.id.tv_seconds);
        addView(myView);
    }

    private Handler mHandler = new Handler() {
    };

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void start() {

        if (!isRun()) {
            run = true;
            setRun(run);
            tvTime.setFocusable(false);

            tvTime.setTextColor(getResources().getColor(R.color.black_weak));
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mHandler.post(new Runnable() {      // UI thread
                        @Override
                        public void run() {
                            if (second == 0) {
                                run = false;
                                setRun(run);
                                tvTime.setTextColor(getResources().getColor(R.color.black_weak));
                                tvTime.setBackgroundResource(R.color.gray);
                                tvTime.setFocusable(true);
                                tvTime.setText(originalDes);
                                if(timer!=null){
                                    timer.cancel();
                                    timer=null;
                                }
                            } else if (second > 0) {
                                tvTime.setText(second < 10 ? (strStart + second + strEnd) : strStart + second + strEnd);

                            } else {
                                timer.cancel();
                            }
                            second--;

                        }
                    });

                }
            }, 100, 1000);

        } else {
            Toast.makeText(context,"验证码已发送，请注意查收", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * @param length
     */
    public void setTimes(Integer length) {
        tvTime.setText(strStart + length + strEnd);
        second = length;

    }

    public void stopRun() {
        tvTime.setTextColor(getResources().getColor(R.color.colorAccent));
        tvTime.setFocusable(true);
        tvTime.setText(originalDes);
        timer.cancel();
    }

    public void setTimerDes(String originalDes, String strStart, String strEnd) {
        this.originalDes = originalDes;
        this.strStart = strStart;
        this.strEnd = strEnd;
        tvTime.setText(originalDes);

    }

//    /**
//     * 和activity的onDestroy()方法同步
//     */
//    public void onDestroy() {
//        if (App.timeMap == null)
//            App.timeMap = new HashMap<String, Integer>();
//        App.timeMap.put(TIME, second);
//        App.timeMap.put(CTIME, SystemUtil.getCurrentTime());
//        if (timer != null) {
//            timer.cancel();
//        }
//        timer = null;
//        Log.e("yung", "onDestroy");
//    }
//
//
//    /**
//     * 和activity的onCreate()方法同步
//     */
//    public void onCreate() {
//        Log.e("yung", App.timeMap + "");
//        if (App.timeMap == null)
//            return;
//        if (App.timeMap.size() <= 0)// 这里表示没有上次未完成的计时
//            return;
//        long time = SystemUtil.getCurrentTime() - App.timeMap.get(CTIME)
//                - App.timeMap.get(TIME);
//        App.timeMap.clear();
//        if (time > 0)
//            return;
//        else {
//            //还有上次未完成的计时
//            second = (int) Math.abs(time);
//            start();
//
//        }
//    }

}

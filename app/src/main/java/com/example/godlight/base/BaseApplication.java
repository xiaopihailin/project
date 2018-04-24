package com.example.godlight.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;


import java.util.Stack;


/**
 * Created by Lzh on 2018/4/20.
 */
public class BaseApplication extends Application {

    private final static String PROCESS_NAME = "com.example.godlight";
    private Stack<Activity> activityStack = new Stack<Activity>();//Activity堆
    private static BaseApplication instance;



    @Override
    public void onCreate() {
        super.onCreate();
             CrashHandler crashHandler = CrashHandler.getInstance();
             crashHandler.init(getApplicationContext());
    }

    /**
     * baseapplication单例
     *
     * @return
     */
    public synchronized static BaseApplication getInstance() {
        if (null == instance) {
            instance = new BaseApplication();
        }
        return instance;
    }

    /**
     * 堆栈空间添加activity
     *
     * @param curAT
     */
    public void addActivity(final Activity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(curAT);
    }

    /**
     * 在对战空间中删除某个activity
     *
     * @param curAT
     */
    public void removeActivity(final Activity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<Activity>();
        }
        activityStack.remove(curAT);
    }

    /**
     * 获取堆栈顶部的activity
     *
     * @return
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 删除上一个界面
     *
     * @return
     */
    public boolean finishLastActivity() {
        boolean isSucees = false;
        if (activityStack.size() > 2) {
            isSucees = true;
            activityStack.get(howManyActivities() - 2).finish();
        }

        return isSucees;
    }

    public Activity firstActivity() {
        Activity activity = activityStack.firstElement();
        return activity;
    }

    /**
     * 堆栈存储量
     *
     * @return
     */
    public int howManyActivities() {
        return activityStack.size();
    }

    /**
     * 关闭所有activity
     */
    public void finishAllActivities() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }


    /**
     * 判断是不是UI主进程，因为有些东西只能在UI主进程初始化
     * <p>
     * 由于推送，分享等第三方都会初始化自己的application，为了防止baseApplication多次被初始化，需要提前判断
     */
    public static boolean isAppMainProcess() {
        try {
            int pid = android.os.Process.myPid();
            String process = getAppNameByPID(BaseApplication.getInstance(), pid);
            if (TextUtils.isEmpty(process)) {
                return true;
            } else if (PROCESS_NAME.equalsIgnoreCase(process)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * 根据Pid得到进程名
     */
    public static String getAppNameByPID(Context context, int pid) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                return processInfo.processName;
            }
        }
        return "";
    }

}

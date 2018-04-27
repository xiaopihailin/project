package com.example.godlight.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


import java.io.DataOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;


public class SystemUtil {


    private static long lastClickTime;


    /*n秒之内点击多次*/
    public static boolean isFastDoubleClickN(int l) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        l = l * 1000;
        if (0 < timeD && timeD < l) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * 检测网络是否链接
     *
     * @param context
     * @return
     */
    public static boolean checkNet(Context context) {

        // 获取手机所以连接管理对象（包括wi-fi，net等连接的管理）
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conn != null) {
            // 网络管理连接对象
            NetworkInfo info = conn.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 判断当前网络是否连接
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 检查字符串为空
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (str == null || "".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMobileNum(String phone) {
        if (isNull(phone))
            return false;
        String regex = "^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$";
        return phone.matches(regex);
    }


    /**
     * 隐藏软键盘
     *
     * @param context
     * @param view
     */
    public static void hideSoftKeybord(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            imm.hideSoftInputFromInputMethod(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

    }

    /**
     * 显示软键盘
     *
     * @param context
     * @param view
     */
    public static void showSoftKeybord(Context context, View view) {
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * 将px转换为dip
     */
    public static int px2dip(Context cc, float pxValue) {
        final float scale = cc.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip转换为px
     */
    public static int dip2px(Context cc, float pxValue) {
        final float scale = cc.getResources().getDisplayMetrics().density;
        return (int) (pxValue * scale + 0.5f);
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
   /* public static int getScreenWidth() {
//        WindowManager windowManager = ((Activity)context).getWindowManager();
        int width = 0;
        if (BaseApplication.getInstance().currentActivity() != null) {
            WindowManager windowManager = BaseApplication.getInstance().currentActivity().getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            width = metrics.widthPixels;//像素
        }

        return width;

    }*/

    /**
     * 获取屏幕高度
     *
     * @return
     */
   /* public static int getScreenHeight() {
        int height = 0;
        if (BaseApplication.getInstance().currentActivity() != null) {
            WindowManager windowManager = BaseApplication.getInstance().currentActivity().getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            height = metrics.heightPixels;//像素
        }

        return height;

    }*/

    public static int[] getWidgetWidth(View view) {
        int[] attr;
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int height = view.getMeasuredHeight();
        int width = view.getMeasuredWidth();
        attr = new int[]{width, height};
        return attr;
    }

    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 网络是否可用
     *
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {

        // 获取手机所以连接管理对象（包括wi-fi，net等连接的管理）
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conn != null) {
            // 网络管理连接对象
            NetworkInfo info = conn.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 判断当前网络是否连接
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 网络状态
     *
     * @param context
     * @return
     */
    public static boolean is2G3G(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo == null)
            return false;
        if (activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        }
        if ((activeNetInfo.getSubtype() == TelephonyManager.NETWORK_TYPE_EDGE || activeNetInfo.getSubtype() == TelephonyManager.NETWORK_TYPE_GPRS || activeNetInfo
                .getSubtype() == TelephonyManager.NETWORK_TYPE_CDMA)) {
            return true;
        }
        return false;
    }

    /**
     * 获取GPRS的IP地址
     *
     * @return
     */
    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
        }
        return null;
    }

    /**
     * 获取wifi地址
     *
     * @return
     */
    public static String getWifiIpAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        // 获取32位整型IP地址
        int ipAddress = wifiInfo.getIpAddress();

        //返回整型地址转换成“*.*.*.*”地址
        return String.format("%d.%d.%d.%d",
                (ipAddress & 0xff), (ipAddress >> 8 & 0xff),
                (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
    }

    /**
     * 网络类型
     *
     * @param type
     * @return
     */
    public static String getNetWorkName(int type) {
        String typeName = "";
        // TelephonyManager.NETWORK_TYPE_GPRS;
        switch (type) {
            case 0:
                typeName = "NETWORK_TYPE_UNKNOWN";
                break;
            case 1:
                typeName = "NETWORK_TYPE_GPRS";
                break;
            case 2:
                typeName = "NETWORK_TYPE_EDGE";
                break;
            case 3:
                typeName = "NETWORK_TYPE_UMTS";
                break;
            case 4:
                typeName = "NETWORK_TYPE_CDMA";
                break;
            case 5:
                typeName = "NETWORK_TYPE_EVDO_0";
                break;
            case 6:
                typeName = "NETWORK_TYPE_EVDO_A";
                break;
            case 7:
                typeName = "NETWORK_TYPE_1xRTT";
                break;
            case 8:
                typeName = "NETWORK_TYPE_HSDPA";
                break;
            case 9:
                typeName = "NETWORK_TYPE_HSUPA";
                break;
            case 10:
                typeName = "NETWORK_TYPE_HSPA";
                break;
            case 11:
                typeName = "NETWORK_TYPE_IDEN";
                break;
            case 12:
                typeName = "NETWORK_TYPE_EVDO_B";
                break;
        }
        return typeName;
    }

    /**
     * 网络类型
     *
     * @return
     */
   /* public static String getNetworkType() {
        ConnectivityManager cm = (ConnectivityManager) BaseApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return "None-无网络";
        }
        if (info.getType() == ConnectivityManager.TYPE_WIFI) {
            return "Wifi-无线网";
        }
        if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            String typeName = "Unknown-未知的网络类型";
            switch (info.getSubtype()) {
                case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                    typeName = "NETWORK_TYPE_UNKNOWN-未知的手机网络";
                    break;
                case TelephonyManager.NETWORK_TYPE_GPRS:
                    typeName = "NETWORK_TYPE_GPRS-移动/联通2G";
                    break;
                case TelephonyManager.NETWORK_TYPE_EDGE:
                    typeName = "NETWORK_TYPE_EDGE-移动/联通2G";
                    break;
                case TelephonyManager.NETWORK_TYPE_UMTS:
                    typeName = "NETWORK_TYPE_UMTS-联通3G";
                    break;
                case TelephonyManager.NETWORK_TYPE_CDMA:
                    typeName = "NETWORK_TYPE_CDMA-电信2G";
                    break;
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    typeName = "NETWORK_TYPE_EVDO_0-电信3G";
                    break;
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    typeName = "NETWORK_TYPE_EVDO_A-电信3G";
                    break;
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                    typeName = "NETWORK_TYPE_1xRTT";
                    break;
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    typeName = "NETWORK_TYPE_HSDPA-联通3G";
                    break;
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                    typeName = "NETWORK_TYPE_HSUPA";
                    break;
                case TelephonyManager.NETWORK_TYPE_HSPA:
                    typeName = "NETWORK_TYPE_HSPA";
                    break;
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    typeName = "NETWORK_TYPE_IDEN";
                    break;
                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    typeName = "NETWORK_TYPE_EVDO_B-电信3G";
                    break;
                case TelephonyManager.NETWORK_TYPE_LTE:
                    typeName = "NETWORK_TYPE_LTE-4G";
                    break;
                case TelephonyManager.NETWORK_TYPE_EHRPD:
                    typeName = "NETWORK_TYPE_EHRPD";
                    break;
                case TelephonyManager.NETWORK_TYPE_HSPAP:
                    typeName = "NETWORK_TYPE_HSPAP-联通3G";
                    break;
            }
            return typeName;
        }
        return "Unknown-未知的网络类型";
    }*/




    // 获取文件
    /*应用程序在运行的过程中如果需要向手机上保存数据，一般是把数据保存在SDcard中的。
大部分应用是直接在SDCard的根目录下创建一个文件夹，然后把数据保存在该文件夹中。
这样当该应用被卸载后，这些数据还保留在SDCard中，留下了垃圾数据。
如果你想让你的应用被卸载后，与该应用相关的数据也清除掉，该怎么办呢？

通过Context.getExternalFilesDir()方法可以获取到 SDCard/Android/data/你的应用的包名/files/ 目录，一般放一些长时间保存的数据


通过Context.getExternalCacheDir()方法可以获取到 SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据

如果使用上面的方法，当你的应用在被用户卸载后，SDCard/Android/data/你的应用的包名/ 这个目录下的所有文件都会被删除，不会留下垃圾信息。

而且上面二个目录分别对应 设置->应用->应用详情里面的”清除数据“与”清除缓存“选项*/
    //Context.getExternalFilesDir() --> SDCard/Android/data/你的应用的包名/files/ 目录，一般放一些长时间保存的数据
    //Context.getExternalCacheDir() --> SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据
    public static long getFolderSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    public static String getTotalCacheSize(Context context) throws Exception {
        long cacheSize = getFolderSize(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cacheSize += getFolderSize(context.getExternalCacheDir());
        }
        return getFormatSize(cacheSize);
    }


    public static void clearAllCache(Context context) {
        deleteDir(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteDir(context.getExternalCacheDir());
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * 格式化单位
     *
     * @param size
     * @return
     */
    public static String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
//            return size + "Byte";
            return "0K";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                + "TB";
    }

//    //给Textview设置缓存大小
//    public static void setTextViewCache(Context context, TextView tv) {
//        try {
//            if (CameraUtils.isExternalStorageUseful()) {
//                String size = SystemUtil.getTotalCacheSize(context);
//                tv.setText(size);
//            }
//
//        } catch (Exception e) {
//        }
//
//    }




    /**
     * 获取当前位置的经纬度
     * <p>
     * 需要权限
     * <uses-permission android:name="android.permission.INTERNET" />
     * <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
     * <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
     *
     * @param context
     * @return
     */
    public static double[] getLatLon(Context context) {
        final double[] latLon = new double[2];

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return latLon;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {//GPS
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                latLon[0] = location.getLatitude();
                latLon[1] = location.getLongitude();
            }
        } else {//NETWORK
            LocationListener locationListener = new LocationListener() {

                // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                // Provider被enable时触发此函数，比如GPS被打开
                @Override
                public void onProviderEnabled(String provider) {

                }

                // Provider被disable时触发此函数，比如GPS被关闭
                @Override
                public void onProviderDisabled(String provider) {

                }

                //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
                @Override
                public void onLocationChanged(Location location) {
                    if (location != null) {

                        latLon[0] = location.getLatitude();
                        latLon[1] = location.getLongitude();
                    }
                }
            };
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);

            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (location != null) {
                latLon[0] = location.getLatitude(); //经度
                latLon[1] = location.getLongitude(); //纬度
            }
        }

        return latLon;

    }


    /**
     * 是否获取root权限
     *
     * @return
     */
   /* public static boolean isRoot() {
        String command = "chmod 777 " + BaseApplication.getInstance().getPackageCodePath();
        Process process = null;
        DataOutputStream os = null;
        try {
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes(command + "\n");
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        } catch (Exception e) {
            Log.d("*** DEBUG ***", "ROOT REE" + e.getMessage());
            return false;
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                process.destroy();
            } catch (Exception e) {
            }
        }
        Log.d("*** DEBUG ***", "Root SUC ");
        return true;
    }*/


    // SD卡可用内存空间
    public static long getSDCardAvailableSpace() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File sdcardDir = Environment.getExternalStorageDirectory();
            StatFs sf = new StatFs(sdcardDir.getPath());
            long blockSize = sf.getBlockSize();
            long availCount = sf.getAvailableBlocks();
            return availCount * blockSize / 1024;
        }
        return 0;
    }


    /***
     * 获取文件夹大小
     ***/
    public static long getFileSize(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    /**
     * 转换文件大小单位(b/kb/mb/gb)
     **/
    public static String FormetFileSize(long fileS) {// 转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        DecimalFormat df2 = new DecimalFormat("#");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df2.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }







/*

     * http 请求加密参数
     *
     * @param url
     * @return

    public static String getHttpHeaderAuthorization(String url) {
        String authorization = "";
        try {
            String queryString = url.substring(url.indexOf("?") + 1, url.length());
            Date d = new Date();
            Long timeStamp = d.getTime();
            String md5 = md5encode(queryString + "&timestamp=" + timeStamp);
            String deskey = "android:20121009:" + timeStamp + ":" + md5.toUpperCase();
            String desvalue = Des.des3EncodeECB(deskey);
            desvalue = desvalue.substring(0, desvalue.length() - 1);

            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(desvalue);
            desvalue = m.replaceAll("");

            authorization = Base64.encodeToString(desvalue.getBytes(), Base64.DEFAULT);
            m = p.matcher(authorization);
            authorization = m.replaceAll("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Basic " + authorization;
    }

*/


    /*
     * MD5算法
     */
    private final static String md5encode(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    // 获取当前时间的年月日
    public static String getCurrentTimeYMD() {
        SimpleDateFormat dateForamt = new SimpleDateFormat("yyyy-MM-dd");
        return dateForamt.format(System.currentTimeMillis());
    }

    //设置状态栏字体为黑色
    public static boolean setMeizuStatusBarDarkIcon(Activity activity, boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }
}

package com.example.zyh.jxnudiscuss;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.push.PushConstants;

/**
 * Created by zyh on 17-3-1.
 */

public class PushMessageReceiver  extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_menu_send);
        Icon icon=Icon.createWithResource(context,R.drawable.ic_menu_send);
        String msg=intent.getStringExtra("msg");
        String newmsg=msg.substring(10,msg.length()-2);
    if(intent.getAction().equals(PushConstants.ACTION_MESSAGE)){
        Log.d("bmob", "客户端收到推送内容："+msg);

        Toast.makeText(context,"客户端收到推送内容："+intent.getStringExtra("msg"),Toast.LENGTH_LONG).show();
        Log.v("thread is",Thread.currentThread()+"");
        Notification.Builder notificationbuilder=new Notification.Builder(context);
        notificationbuilder.setContentTitle("new things from JXNU");
        notificationbuilder.setContentText(newmsg);
        notificationbuilder.setTicker("hello my  friends");
        Notification notification=notificationbuilder.build();
        notificationbuilder.setLargeIcon(bitmap);
        notificationbuilder.setSmallIcon(icon);
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1=new Intent(context,MainActivity.class);
        intent1.setAction("android.intent.action.MAIN");
        intent1.addCategory("com.example.zyh.jxnudiscuss");
        PendingIntent pendingIntent =PendingIntent.getActivity(context,1,intent1,PendingIntent.FLAG_CANCEL_CURRENT);
        notification.contentIntent=pendingIntent;
        notificationManager.notify(1,notification);






    }
}
}
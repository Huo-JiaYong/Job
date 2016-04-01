package com.yong.job.four;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by jyong on 2016/3/30.
 */
public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //get sms
        Bundle bundle = intent.getExtras();
        Object[] objects = (Object[]) bundle.get("pdus");
        SmsMessage[] smsMessages = new SmsMessage[objects.length];
        for (int i = 0; i < objects.length; i++) {
            smsMessages[i] = SmsMessage.createFromPdu((byte[]) objects[i]);
        }

        //sms address
        String address = smsMessages[0].getOriginatingAddress();
        //sms context
        String body = "";
        for (SmsMessage message : smsMessages) {
            body += message.getMessageBody();
        }

        Log.e("Message", address + "," + body);

//
//        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
//        dialog.setTitle(address);
//        dialog.setMessage(body);
//        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        AlertDialog alertDialog = dialog.create();
//        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//
//        alertDialog.show();
    }
}

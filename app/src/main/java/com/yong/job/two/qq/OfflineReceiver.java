package com.yong.job.two.qq;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by jyong on 2016/3/21.
 */
public class OfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        //show dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("下线提示");
        dialog.setMessage("您的账号在其他地方登陆，请重新登陆");
        dialog.setCancelable(false);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityController.removeAll();

                Intent intent1 = new Intent(context, LoginActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        });

        AlertDialog alertDialog = dialog.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}

package com.ryg.chapter_2.Test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.ryg.chapter_2.R;

/**
 * Created by liumeng on 2017/6/5 on 11:20
 */

public class DialogUtils {
    public static void maekSureDialog(final Activity activity, final CallBack callBaok) {
		/*
		 * 1. 创建一个AlertDialog的构建者
		 */
        //		AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());//错误的写法
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);//因为只有Activity才有Window的引用
		/*
		 * 2. 设置参数（包括，图标，标题，消息，按钮）
		 */
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("请做出您的选择");
        builder.setMessage("您愿意嫁给小明吗?");
        //设置消极的按钮（取消按钮）
		/*
		 * 参数1：按钮上的文字
		 */
        builder.setNegativeButton("不愿意", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(activity, "您选择了不愿意", Toast.LENGTH_SHORT).show();
                callBaok.canCel();
            }
        });
        //设置积极按钮（确定）
        builder.setPositiveButton("愿意", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                callBaok.confirm();
            }
        });
        builder.create().show();
    }
}

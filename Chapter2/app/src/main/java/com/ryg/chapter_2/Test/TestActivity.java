package com.ryg.chapter_2.Test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ryg.chapter_2.R;

public class TestActivity extends Activity implements CallBack {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void showDialog(View view) {
        DialogUtils.maekSureDialog(this,this);
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TestActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TestActivity","onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TestActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TestActivity","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TestActivity","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TestActivity","onDestroy");

    }


    @Override
    public void confirm() {
        Toast.makeText(TestActivity.this, "您选择了愿意", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void canCel() {
        Toast.makeText(TestActivity.this, "您选择了不愿意", Toast.LENGTH_SHORT).show();
    }
}

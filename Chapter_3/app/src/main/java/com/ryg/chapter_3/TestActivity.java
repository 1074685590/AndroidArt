package com.ryg.chapter_3;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * 1.mButton1中的文字时如何动起来的,为什么只是文字在移动
 * 调用scrollTo方法,该方法移动的只是控件的内容
 *
 */
public class TestActivity extends Activity implements OnClickListener,
        OnLongClickListener {

    private static final String TAG = "TestActivity";



    private Button mButton1;
    private View   mButton2;

    private int mCount = 0;
    private static final int MESSAGE_SCROLL_TO = 1;
    private static final int FRAME_COUNT       = 30;
    private static final int DELAYED_TIME      = 33;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_SCROLL_TO: {
                    mCount++;
                    if (mCount <= FRAME_COUNT) { //帧计数 ,一秒钟内分33帧移动到目标位置
                        float fraction = mCount / (float) FRAME_COUNT; //分数
                        int scrollX = (int) (fraction * 100);  //x轴上移动到100,0点
                        mButton1.scrollTo(scrollX, 0);
                        mHandler.sendEmptyMessageDelayed(MESSAGE_SCROLL_TO, DELAYED_TIME);
                    }
                    break;
                }

                default:
                    break;
            }
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = (TextView) findViewById(R.id.button2);
        mButton2.setOnLongClickListener(this);
    }

    /**
     * 问题 onWindowFocusChanged 在哪些时候会被调用,edit焦点变化会调用吗
     * http://blog.csdn.net/yueqinglkong/article/details/44981449
     * @param hasFocus
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Log.d(TAG, "button1.left=" + mButton1.getLeft());
            Log.d(TAG, "button1.x=" + mButton1.getX());
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onClick(View v) {
        if (v == mButton1) {
             mButton1.setTranslationX(100);

             Log.d(TAG, "button1.left=" + mButton1.getLeft());
             Log.d(TAG, "button1.x=" + mButton1.getX());
//             ObjectAnimator.ofFloat(mButton1, "translationX", 0, 100).setDuration(1000).start();
             ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mButton1.getLayoutParams();
             params.width += 100;
             params.leftMargin += 100;
//             mButton1.requestLayout();  这两个方法使用一个就可以了
             mButton1.setLayoutParams(params);

            final int startX = 0;
            final int deltaX = 100;
            ValueAnimator animator = ValueAnimator.ofInt(0,
                    1).setDuration(1000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    float fraction = animator.getAnimatedFraction();
                    mButton1.scrollTo(startX + (int) (deltaX * fraction), 0);
                }
            });
//            animator.start();

//                        mHandler.sendEmptyMessageDelayed(MESSAGE_SCROLL_TO, DELAYED_TIME);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "long click", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }
}

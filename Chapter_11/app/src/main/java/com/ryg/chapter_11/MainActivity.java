package com.ryg.chapter_11;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 1. AsyncTask的使用 http://blog.csdn.net/iispring/article/details/50639090
 *
 *
 */
public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scheduleThreads();
//124=100=100=150
    }

    private void scheduleThreads() {
        runAsyncTask();
        runIntentService();
        runThreadPool();
    }

    private void runThreadPool() {
        Runnable command = new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
            }
        };

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        fixedThreadPool.execute(command);
        
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(command);
        
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
        // 2000ms后执行command
        scheduledThreadPool.schedule(command, 2000, TimeUnit.MILLISECONDS);
        // 延迟10ms后，每隔1000ms执行一次command
        scheduledThreadPool.scheduleAtFixedRate(command, 10, 1000, TimeUnit.MILLISECONDS);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(command);
    }

    private void runIntentService() {
        //为了证明多次start多次调用onStartCommand()
        Intent service = new Intent(this, LocalIntentService.class);
        service.putExtra("task_action", "com.ryg.action.TASK1");
        startService(service);
        service.putExtra("task_action", "com.ryg.action.TASK2");
        startService(service);
        service.putExtra("task_action", "com.ryg.action.TASK3");
        startService(service);
    }

    private void runAsyncTask() {
        try {
            new DownloadFilesTask().execute(new URL("http://www.baidu.com"),
                    new URL("http://www.renyugang.cn"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 泛型三个参数的探究
     * AsyncTask<Params, Progress, Result>
     *  参数的类型
     *  后台任务执行进度类型
     *  后台任务返回结果的类型
     */
    private class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {

        protected Long doInBackground(URL... urls) {
            int count = urls.length;
            long totalSize = 0;
            for (int i = 0; i < count; i++) {
//                 totalSize += Downloader.downloadFile(urls[i]);
                publishProgress((int) ((i / (float) count) * 100));
//                 Escape early if cancel() is called
                if (isCancelled())
                    break;
            }
            return totalSize;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected void onProgressUpdate(Integer... progress) {
//             setProgressPercent(progress[0]);
        }

        protected void onPostExecute(Long result) {
//             showDialog("Downloaded " + result + " bytes");
        }
    }

}

package com.example.practical4;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

public class TimerService extends Service {

    private int seconds = 0;
    private boolean running = false;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private Thread timerThread;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!running) {
            running = true;
            timerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (running) {
                        try {
                            Thread.sleep(1000);
                            seconds++;

                            mainHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),
                                            "Timer: " + seconds + " seconds",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                        } catch (InterruptedException e) {
                            // Thread interrupted, exit loop
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            timerThread.start();
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        running = false;
        if (timerThread != null) {
            timerThread.interrupt();
        }
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

package com.shnoble.backgroundexecutionlimits;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MusicPlayerService extends Service {

    private static final String TAG = MusicPlayerService.class.getSimpleName();

    private MediaPlayer mMediaPlayer;

    public MusicPlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate");
        mMediaPlayer = MediaPlayer.create(this, R.raw.bensound_clearday);
        mMediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand");
        mMediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");
        mMediaPlayer.stop();
    }
}

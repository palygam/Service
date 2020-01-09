package com.example.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Random;

public class SortService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void sortArray (){
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
        Arrays.sort(array);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        sortArray();
        stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Array Sorted",
                Toast.LENGTH_SHORT).show();
    }
}

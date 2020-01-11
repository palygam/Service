package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Arrays;
import java.util.Random;

public class SortService extends Service {
    private int[] array;
    private final IBinder binder = new LocalBinder();


    public class LocalBinder extends Binder {
        SortService getService() {
            return SortService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    public int[] sortArray() {
        array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
        Arrays.sort(array);
        return array;
    }
}

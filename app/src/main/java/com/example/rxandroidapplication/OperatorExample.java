package com.example.rxandroidapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class OperatorExample extends AppCompatActivity {

    private static final String TAG = OperatorExample.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // fromArray
        Integer[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        Observable.fromArray(number)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "Number" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Error" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "All Emiter Completed");
                    }
                });
    }
}

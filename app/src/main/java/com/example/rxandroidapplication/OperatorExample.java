package com.example.rxandroidapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class OperatorExample extends AppCompatActivity {

    private static final String TAG = OperatorExample.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // fromArray
        fromArrayOPerator();
        // range operator
        fromRangeOperator();
        // repeate operator
        fromRepeateOPerator();
        //chaining of Operator
        fromPrintEvenNumber();


    }

    private void fromPrintEvenNumber() {

        Observable.range(1,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer%2==0;
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return integer+"is Even number";
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                    Log.d(TAG,"Number"+s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void fromRepeateOPerator() {
        Observable.range(1,3)
                .repeat(2)
                .subscribe(new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG,"Repeate"+integer);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void fromRangeOperator() {
        Observable.range(2, 23)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "Number Range" + integer);
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

    private void fromArrayOPerator() {
        Integer[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 21};
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

package ro.ovidiuconeac.androidasynchronousmvp.featurex.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ro.ovidiuconeac.androidasynchronousmvp.featurex.presenter.XPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.featurex.presenter.XPresenterImpl;

/**
 * Created by ovidiu on 12/29/16.
 */

public class XActivity extends AppCompatActivity implements XView {

    private XPresenter presenter;
    private ExecutorService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new XPresenterImpl(this);
        service = Executors.newCachedThreadPool();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.requestAction1();
        this.requestAction2();
        this.requestAction3();
    }

    @Override
    protected void onDestroy() {
        presenter = null;
        service.shutdown();
        service= null;
        super.onDestroy();
    }

    @Override
    public void requestAction1() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                presenter.requestAction1();
            }
        };
        service.submit(task);
    }

    @Override
    public void postResult1(final String result) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Log.d(getClass().getName(), result);
            }
        };
        runOnUiThread(task);
    }

    @Override
    public void requestAction2() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                presenter.requestAction2();
            }
        };
        service.execute(task);
    }

    @Override
    public void postResult2(final String result) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Log.d(getClass().getName(), result);
            }
        };
        runOnUiThread(task);
    }

    @Override
    public void requestAction3() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                presenter.requestAction3();
            }
        };
        service.submit(task);
    }

    @Override
    public void postResult3(final String result) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Log.d(getClass().getName(), result);
            }
        };
        runOnUiThread(task);
    }
}
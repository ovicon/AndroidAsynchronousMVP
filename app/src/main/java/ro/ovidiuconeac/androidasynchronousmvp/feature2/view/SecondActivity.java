package ro.ovidiuconeac.androidasynchronousmvp.feature2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.ovidiuconeac.androidasynchronousmvp.R;
import ro.ovidiuconeac.androidasynchronousmvp.common.Util;
import ro.ovidiuconeac.androidasynchronousmvp.feature2.model.SecondModel;
import ro.ovidiuconeac.androidasynchronousmvp.feature2.presentor.SecondPresenter;

public class SecondActivity extends AppCompatActivity implements SecondScreen {

    @BindView(R.id.progressBarName)
    ProgressBar progressBarName;

    @BindView(R.id.editTextName)
    EditText editTextName;

    @BindView(R.id.buttonName)
    Button buttonName;

    @BindView(R.id.progressBarAge)
    ProgressBar progressBarAge;

    @BindView(R.id.editTextAge)
    EditText editTextAge;

    @BindView(R.id.buttonAge)
    Button buttonAge;

    @BindView(R.id.progressBarImage)
    ProgressBar progressBarImage;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.buttonImage)
    Button buttonImage;

    private SecondPresenter secondPresenter;
    private ExecutorService executor;
    private SecondScreen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        secondPresenter = new SecondPresenter();
        executor = Executors.newCachedThreadPool();
        screen = this;
    }

    @Override
    protected void onDestroy() {
        secondPresenter = null;
        executor.shutdown();
        executor = null;
        super.onDestroy();
    }

    @Override
    @OnClick(R.id.buttonName)
    public void requestName() {
        final Runnable enableUiTask = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                buttonName.setEnabled(true);
                editTextName.setEnabled(true);
                progressBarName.setVisibility(View.INVISIBLE);
            }
        };
        final Runnable disableUiTask = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                buttonName.setEnabled(false);
                editTextName.setEnabled(false);
                progressBarName.setVisibility(View.VISIBLE);
            }
        };
        Runnable task = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                runOnUiThread(disableUiTask);
                secondPresenter.requestName(screen);
                runOnUiThread(enableUiTask);
            }
        };
        executor.submit(task);
    }

    @Override
    public void postName(final String name) {
        Util.simulateNetworkLatency(6000);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                editTextName.setText(name);
            }
        };
        editTextName.post(task);
    }

    @Override
    @OnClick(R.id.buttonAge)
    public void requestAge() {
        final Runnable enableUiTask = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                buttonAge.setEnabled(true);
                editTextAge.setEnabled(true);
                progressBarAge.setVisibility(View.INVISIBLE);
            }
        };
        final Runnable disableUiTask = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                buttonAge.setEnabled(false);
                editTextAge.setEnabled(false);
                progressBarAge.setVisibility(View.VISIBLE);
            }
        };
        Runnable task = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                runOnUiThread(disableUiTask);
                secondPresenter.requestAge(screen);
                runOnUiThread(enableUiTask);
            }
        };
        executor.submit(task);
    }

    @Override
    public void postAge(final int age) {
        Util.simulateNetworkLatency(3000);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                editTextAge.setText(String.valueOf(age));
            }
        };
        editTextAge.post(task);
    }

    @Override
    @OnClick(R.id.buttonImage)
    public void requestImage() {
        final Runnable enableUiTask = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                buttonImage.setEnabled(true);
                progressBarImage.setVisibility(View.INVISIBLE);
            }
        };
        final Runnable disableUiTask = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                buttonImage.setEnabled(false);
                progressBarImage.setVisibility(View.VISIBLE);
            }
        };
        Runnable task = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                runOnUiThread(disableUiTask);
                secondPresenter.requestImage(screen);
                runOnUiThread(enableUiTask);
            }
        };
        executor.submit(task);
    }

    @Override
    public void postImage(final Bitmap bitmap) {
        Util.simulateNetworkLatency(3000);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                imageView.setImageBitmap(bitmap);
            }
        };
        runOnUiThread(task);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}

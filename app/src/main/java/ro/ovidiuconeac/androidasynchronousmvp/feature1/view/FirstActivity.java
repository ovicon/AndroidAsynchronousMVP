package ro.ovidiuconeac.androidasynchronousmvp.feature1.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.ovidiuconeac.androidasynchronousmvp.BuildConfig;
import ro.ovidiuconeac.androidasynchronousmvp.R;
import ro.ovidiuconeac.androidasynchronousmvp.common.Util;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.presenter.FirstPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.feature2.view.SecondActivity;

public class FirstActivity extends AppCompatActivity implements FirstScreen {

    @BindView(R.id.editTextUser)
    EditText user;

    @BindView(R.id.editTextPassword)
    EditText password;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.buttonLogin)
    Button login;

    @BindView(R.id.textViewRandomMessage)
    TextView message;

    private final static String USER = "user";
    private final static String PASSWORD = "password";
    private final static String PROGRESS_BAR = "progressBa";
    private final static String LOGIN = "login";
    private final static String MESSAGE = "message";

    private FirstPresenter presenter;
    private ExecutorService executor;
    private FirstScreen screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        presenter = new FirstPresenter();
        executor = Executors.newCachedThreadPool();
        // This view should not be visible by default, feels like a bug man
        progressBar.setVisibility(View.INVISIBLE);
        if (BuildConfig.DEBUG) {
            user.setText("admina");
            password.setText("admin");

        }
        screen = this;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(USER, user.isEnabled());
        outState.putBoolean(PASSWORD, password.isEnabled());
        outState.putBoolean(LOGIN, login.isEnabled());
        outState.putInt(PROGRESS_BAR, progressBar.getVisibility());
        outState.putString(MESSAGE, message.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        user.setEnabled(savedInstanceState.getBoolean(USER));
        password.setEnabled(savedInstanceState.getBoolean(PASSWORD));
        login.setEnabled(savedInstanceState.getBoolean(LOGIN));
        progressBar.setVisibility(savedInstanceState.getInt(PROGRESS_BAR) == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        message.setText(savedInstanceState.getString(MESSAGE));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        presenter = null;
        executor.shutdown();
        executor = null;
        screen = null;
        super.onDestroy();
    }

    @Override
    public void requestLogin() {
        final Runnable disableUiTask = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                user.setEnabled(false);
                password.setEnabled(false);
                login.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
            }
        };
        Runnable requestLoginTask = new Runnable() {
            final String u = user.getText().toString();
            final String p = password.getText().toString();
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                runOnUiThread(disableUiTask);
                presenter.requestLogin(screen, new User(u, p));
            }
        };
        executor.submit(requestLoginTask);
    }

    @Override
    public void doLogin() {
        Util.simulateNetworkLatency(3000);
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    public void showLoginError() {
        Util.simulateNetworkLatency(3000);
        final Context _this = this;
        final Runnable enableUiTask = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                user.setEnabled(true);
                password.setEnabled(true);
                login.setEnabled(true);
                progressBar.setVisibility(View.INVISIBLE);
            }
        };
        runOnUiThread(enableUiTask);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
                Toast.makeText(_this, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
            }
        };
        runOnUiThread(task);
    }

    @Override
    @OnClick(R.id.buttonRequestMessage)
    public void requestMessage() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                presenter.requestMessage(screen);
            }
        };
        executor.submit(task);
    }

    @Override
    public void postMessage(final String msg) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                message.setText(msg);
            }
        };
        runOnUiThread(task);
    }

    @OnClick(R.id.buttonLogin)
    public void login() {
        requestLogin();
    }
}
package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import ro.ovidiuconeac.androidasynchronouscallbackmvp.R;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.model.User;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.presenter.FirstPresenter;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.presenter.FirstPresenterImpl;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.view.SecondActivity;

public class FirstActivity extends AppCompatActivity implements FirstView {

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

    private FirstPresenter presenter;
    private ExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        presenter = new FirstPresenterImpl(this);
        executor = Executors.newCachedThreadPool();
        // This view should not be visible by default, feels like a bug man
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        presenter = null;
        executor.shutdown();
        executor = null;
        super.onDestroy();
    }

    @Override
    public void requestLogin() {
        final Runnable enableUiTask = new Runnable() {
            @Override
            public void run() {
                user.setEnabled(true);
                password.setEnabled(true);
                login.setEnabled(true);
                progressBar.setVisibility(View.INVISIBLE);
            }
        };
        final Runnable disableUiTask = new Runnable() {
            @Override
            public void run() {
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
                runOnUiThread(disableUiTask);
                presenter.requestLogin(new User(u, p));
                runOnUiThread(enableUiTask);
            }
        };
        executor.submit(requestLoginTask);
    }

    @Override
    public void doLogin() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    public void showLoginError() {
        final Context _this = this;
        Runnable task = new Runnable() {
            @Override
            public void run() {
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
                presenter.requestMessage();
            }
        };
        executor.submit(task);
    }

    @Override
    public void postMessage(final String msg) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
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
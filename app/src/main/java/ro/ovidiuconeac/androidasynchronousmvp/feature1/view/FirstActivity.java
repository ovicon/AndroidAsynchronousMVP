package ro.ovidiuconeac.androidasynchronousmvp.feature1.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import ro.ovidiuconeac.androidasynchronousmvp.App;
import ro.ovidiuconeac.androidasynchronousmvp.BuildConfig;
import ro.ovidiuconeac.androidasynchronousmvp.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        presenter = new FirstPresenter();
        // This view should not be visible by default, feels like a bug man
        progressBar.setVisibility(View.INVISIBLE);
        if (BuildConfig.DEBUG) {
            user.setText("admina");
            password.setText("admin");

        }
        presenter = FirstPresenter.getInstance(this);
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
        presenter = FirstPresenter.getInstance(this);
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
        super.onDestroy();
    }

    private void enableUi(boolean enabled) {
        user.setEnabled(enabled);
        password.setEnabled(enabled);
        login.setEnabled(enabled);
        if (enabled) {
            progressBar.setVisibility(View.INVISIBLE);
        } else {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void requestLogin() {
        enableUi(false);
        presenter.requestLogin(new User(user.getText().toString(), password.getText().toString()));
    }

    @Override
    public void doLogin() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    public void showLoginError() {
        enableUi(true);
        Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    @OnClick(R.id.buttonRequestMessage)
    public void requestMessage() {
        presenter.requestMessage(this);
    }

    @Override
    public void postMessage(final String msg) {
        message.setText(msg);
    }

    @OnClick(R.id.buttonLogin)
    public void login() {
        requestLogin();
    }
}
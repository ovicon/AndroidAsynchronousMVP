package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.ovidiuconeac.androidasynchronousmvp.BuildConfig;
import ro.ovidiuconeac.androidasynchronousmvp.R;
import ro.ovidiuconeac.androidasynchronousmvp.cache.Cache;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter.FirstPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view.SecondActivity;

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

    private final static String PRESENTER = "presenter";
    private final static String USER = "user";
    private final static String USER_TXT = "user_txt";
    private final static String PASSWORD = "password";
    private final static String PASSWORD_TXT = "password_txt";
    private final static String PROGRESS_BAR = "progressBa";
    private final static String LOGIN = "login";
    private final static String MESSAGE = "message";

    private FirstPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        // This view should not be visible by default, feels like a bug man
        progressBar.setVisibility(View.INVISIBLE);
        if (BuildConfig.DEBUG) {
            user.setText("admina");
            password.setText("admin");

        }
        presenter = new FirstPresenter(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(USER, user.isEnabled());
        outState.putString(USER_TXT, user.getText().toString());
        outState.putBoolean(PASSWORD, password.isEnabled());
        outState.putString(PASSWORD_TXT, password.getText().toString());
        outState.putBoolean(LOGIN, login.isEnabled());
        outState.putInt(PROGRESS_BAR, progressBar.getVisibility());
        outState.putString(MESSAGE, message.getText().toString());
        // Save presenter instance
        outState.putString(PRESENTER, presenter.getUuid().toString());
        Cache.getInstance().getCache().put(presenter.getUuid(), presenter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        user.setEnabled(savedInstanceState.getBoolean(USER));
        user.setText(savedInstanceState.getString(USER_TXT));
        password.setEnabled(savedInstanceState.getBoolean(PASSWORD));
        login.setEnabled(savedInstanceState.getBoolean(LOGIN));
        progressBar.setVisibility(savedInstanceState.getInt(PROGRESS_BAR)
                == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        message.setText(savedInstanceState.getString(MESSAGE));
        // Restore presenter instance
        presenter = (FirstPresenter) Cache.getInstance().getCache().get(UUID.fromString(savedInstanceState.getString(PRESENTER)));
        presenter.setScreen(this);
        super.onRestoreInstanceState(savedInstanceState);
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
        finish();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.visit_developer: {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.
                        developer)));
                startActivity(intent);
                break;
            }
            default: {
                break;
            }
        }
        return true;
    }
}
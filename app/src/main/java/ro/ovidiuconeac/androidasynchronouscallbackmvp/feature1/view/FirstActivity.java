package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
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
    private SparseArray<String> messages;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        presenter = new FirstPresenterImpl(this);
        executor = Executors.newCachedThreadPool();
        // This view should not be visible by default, feels like a bug man
        progressBar.setVisibility(View.INVISIBLE);
        messages = new SparseArray<>();
        messages.put(0, "In teaching others we teach ourselves.");
        messages.put(1, "Don’t regret the past, just learn from it.");
        messages.put(2, "It does not matter how slowly you go as long as you do not stop.");
        messages.put(3, "I hear and I forget, I see and I remember. I do and I understand.”");
        messages.put(4, "Wherever you go, go with all your heart.");
        messages.put(5, "Don’t wait. The time will never be just right.");
        messages.put(6, "Do what you can, with what you have, where you are.");
        messages.put(7, "Action is the foundational key to all success.");
        messages.put(8, "The best way out is always through.");
        messages.put(9, "If not us, who? If not now, when?");
        messages.put(10, "I can, therefore I am.");
        random = new Random();
    }

    @Override
    protected void onDestroy() {
        presenter = null;
        executor.shutdown();
        executor = null;
        messages = null;
        random = null;
        super.onDestroy();
    }

    @Override
    public void requestLogin() {
        final Runnable enableUi = new Runnable() {
            @Override
            public void run() {
                user.setEnabled(true);
                password.setEnabled(true);
                login.setEnabled(true);
                progressBar.setVisibility(View.INVISIBLE);
            }
        };
        final Runnable disableUi = new Runnable() {
            @Override
            public void run() {
                user.setEnabled(false);
                password.setEnabled(false);
                login.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
            }
        };
        final String u = this.user.getText().toString();
        final String p = this.password.getText().toString();
        final Runnable requestLoginTask = new Runnable() {
            @Override
            public void run() {
                runOnUiThread(disableUi);
                presenter.requestLogin(new User(u, p));
                runOnUiThread(enableUi);
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

    @OnClick(R.id.buttonLogin)
    public void login() {
        requestLogin();
    }

    @OnClick(R.id.buttonRandomMessage)
    public void randomMessage() {
        message.setText(messages.get(random.nextInt(11)));
    }
}
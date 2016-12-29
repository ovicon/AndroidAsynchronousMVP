package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.R;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.presentor.SecondPresenter;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.presentor.SecondPresenterImpl;

public class SecondActivity extends AppCompatActivity implements SecondView {

    @BindView(R.id.progressBarName)
    ProgressBar progressBarName;

    @BindView(R.id.editTextName)
    EditText editTextName;

    @BindView(R.id.progressBarAge)
    ProgressBar progressBarAge;

    @BindView(R.id.editTextAge)
    EditText editTextAge;

    @BindView(R.id.progressBarImage)
    ProgressBar progressBarImage;

    @BindView(R.id.imageView)
    ImageView imageView;

    private SecondPresenter secondPresenter;
    private ExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        secondPresenter = new SecondPresenterImpl(this);
        executor = Executors.newCachedThreadPool();
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
        Runnable task = new Runnable() {
            @Override
            public void run() {
                secondPresenter.requestName();
            }
        };
        executor.submit(task);
    }

    @Override
    public void postName(final String name) {
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
        Runnable task = new Runnable() {
            @Override
            public void run() {
                secondPresenter.requestAge();
            }
        };
        executor.submit(task);
    }

    @Override
    public void postAge(final int age) {
        Runnable ageTask = new Runnable() {
            @Override
            public void run() {
                editTextAge.setText(String.valueOf(age));
            }
        };
        editTextAge.post(ageTask);
    }

    @Override
    @OnClick(R.id.buttonImage)
    public void requestImage() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                secondPresenter.requestImage();
            }
        };
        executor.submit(task);
    }

    @Override
    public void postImage(Bitmap bitmap) {

    }
}

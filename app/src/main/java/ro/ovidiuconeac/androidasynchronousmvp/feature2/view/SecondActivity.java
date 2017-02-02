package ro.ovidiuconeac.androidasynchronousmvp.feature2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.ovidiuconeac.androidasynchronousmvp.R;
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

    private SecondPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        presenter = SecondPresenter.getInstance(this);
    }

    @Override
    protected void onDestroy() {
        presenter = null;
        super.onDestroy();
    }

    private void enableUi(boolean enabled) {
        buttonName.setEnabled(enabled);
        editTextName.setEnabled(enabled);
        if (enabled) {
            progressBarName.setVisibility(View.INVISIBLE);
        } else {
            progressBarName.setVisibility(View.VISIBLE);
        }
    }

    @Override
    @OnClick(R.id.buttonName)
    public void requestName() {
        enableUi(false);
        presenter.requestName();
    }

    @Override
    public void postName(final String name) {
        enableUi(false);
        editTextName.setText(name);
    }

    @Override
    @OnClick(R.id.buttonAge)
    public void requestAge() {
        enableUi(false);
        presenter.requestAge();
    }

    @Override
    public void postAge(final int age) {
        editTextAge.setText(String.valueOf(age));
    }

    @Override
    @OnClick(R.id.buttonImage)
    public void requestImage() {
        presenter.requestImage();
    }

    @Override
    public void postImage(final Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}

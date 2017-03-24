package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.ovidiuconeac.androidasynchronousmvp.R;
import ro.ovidiuconeac.androidasynchronousmvp.cache.Cache;
import ro.ovidiuconeac.androidasynchronousmvp.features.Presenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor.SecondPresenterImpl;

public class SecondActivity extends AppCompatActivity implements SecondView {

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

    private final static String PRESENTER = "presenter";
    // Name
    private final static String NAME_BTN = "name_btn";
    private final static String NAME_EDT = "name_edt";
    private final static String NAME_TXT = "name_txt";
    private final static String NAME_PRG = "name_PRG";
    // Age
    private final static String AGE_BTN = "age_btn";
    private final static String AGE_EDT = "age_edt";
    private final static String AGE_TXT = "age_txt";
    private final static String AGE_PRG = "age_PRG";
    // Image
    private final static String IMG_BTN = "img_btn";
    private final static String IMG_IMG = "img_img";
    private final static String IMG_PRG = "img_prg";

    private SecondPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        presenter = new SecondPresenterImpl(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Name
        outState.putBoolean(NAME_BTN, buttonName.isEnabled());
        outState.putBoolean(NAME_EDT, editTextName.isEnabled());
        outState.putString(NAME_TXT, editTextName.getText().toString());
        outState.putInt(NAME_PRG, progressBarName.getVisibility());
        // Age
        outState.putBoolean(AGE_BTN, buttonAge.isEnabled());
        outState.putBoolean(AGE_EDT, editTextAge.isEnabled());
        outState.putString(AGE_TXT, editTextAge.getText().toString());
        outState.putInt(AGE_PRG, progressBarAge.getVisibility());
        // Image
        outState.putBoolean(IMG_BTN, buttonImage.isEnabled());
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bitmapdata = stream.toByteArray();
        outState.putByteArray(IMG_IMG, bitmapdata);
        outState.putInt(IMG_PRG, progressBarImage.getVisibility());
        // Save presenter instance
        outState.putString(PRESENTER, presenter.getUuid().toString());
        cachePresenter(presenter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Name
        buttonName.setEnabled(savedInstanceState.getBoolean(NAME_BTN));
        editTextName.setEnabled(savedInstanceState.getBoolean(NAME_EDT));
        progressBarName.setVisibility(savedInstanceState.getInt(NAME_PRG)
                == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        // Age
        buttonAge.setEnabled(savedInstanceState.getBoolean(AGE_BTN));
        editTextAge.setEnabled(savedInstanceState.getBoolean(AGE_EDT));
        progressBarAge.setVisibility(savedInstanceState.getInt(AGE_PRG)
                == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        // Image
        buttonImage.setEnabled(savedInstanceState.getBoolean(IMG_BTN));
        byte[] bitmapdata = savedInstanceState.getByteArray(IMG_IMG);
        Drawable image = new BitmapDrawable(getResources(),BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length));
        imageView.setImageDrawable(image);
        progressBarImage.setVisibility(savedInstanceState.getInt(IMG_PRG)
                == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        // Restore presenter instance
        restorePresenter(UUID.fromString(savedInstanceState.getString(PRESENTER)));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    @OnClick(R.id.buttonName)
    public void requestName() {
        editTextName.setEnabled(false);
        buttonName.setEnabled(false);
        progressBarName.setVisibility(View.VISIBLE);
        presenter.requestName();
    }

    @Override
    public void postName(final String name) {
        editTextName.setEnabled(true);
        buttonName.setEnabled(true);
        progressBarName.setVisibility(View.INVISIBLE);
        editTextName.setText(name);
    }

    @Override
    @OnClick(R.id.buttonAge)
    public void requestAge() {
        editTextAge.setEnabled(false);
        buttonAge.setEnabled(false);
        progressBarAge.setVisibility(View.VISIBLE);
        presenter.requestAge();
    }

    @Override
    public void postAge(final int age) {
        editTextAge.setEnabled(true);
        buttonAge.setEnabled(true);
        progressBarAge.setVisibility(View.INVISIBLE);
        editTextAge.setText(String.valueOf(age));
    }

    @Override
    @OnClick(R.id.buttonImage)
    public void requestImage() {
        buttonImage.setEnabled(false);
        progressBarImage.setVisibility(View.VISIBLE);
        presenter.requestImage();
    }

    @Override
    public void postImage(final Bitmap bitmap) {
        buttonImage.setEnabled(true);
        progressBarImage.setVisibility(View.INVISIBLE);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
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

    @Override
    public void cachePresenter(Presenter presenter) {
        Cache.getInstance().cachePresenterFor(presenter.getUuid(), presenter);
    }

    @Override
    public void restorePresenter(UUID uuid) {
        presenter = (SecondPresenterImpl) Cache.getInstance().restorePresenterFor(uuid);
        presenter.setView(this);
    }
}

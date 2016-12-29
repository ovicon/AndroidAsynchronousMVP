package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.R;

public class SecondActivity extends AppCompatActivity implements SecondView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}

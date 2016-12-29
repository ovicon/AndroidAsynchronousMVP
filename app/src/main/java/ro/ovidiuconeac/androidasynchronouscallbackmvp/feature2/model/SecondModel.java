package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.model;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.common.Util;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.presentor.SecondPresenter;

/**
 * Created by ovidiu on 12/29/16.
 */

public class SecondModel {

    private final Random random = new Random();

    private SecondPresenter presenter;
    private SparseArray<String> names;
    private SparseArray<String> images;

    public SecondModel(SecondPresenter presenter) {
        this.presenter = presenter;
        this.names = new SparseArray<>();
        names.put(0, "Ovidiu");
        names.put(1, "Coneac");
        names.put(2, "Lucian");
        names.put(3, "Daniel");
        names.put(4, "Carmina");
        names.put(5, "Alexandru");
        names.put(6, "Ioana");
        names.put(7, "Flavia");
        names.put(8, "Adriana");
        names.put(9, "Cosmin");
        names.put(10, "Andra");
        this.images = new SparseArray<>();
        images.put(0, "img1.jpg");
        images.put(1, "img2.jpg");
        images.put(2, "img3.png");
        images.put(3, "img4.jpg");
        images.put(4, "img5.png");
    }

    public void requestName() {
        Util.simulateNetworkLatency(2000);
        presenter.postName(names.get(random.nextInt(11)));
    }

    public void requestAge() {
        Util.simulateNetworkLatency(3000);
        presenter.postAge(random.nextInt(101));
    }

    public void requestImage() {
        Util.simulateNetworkLatency(1000);
        presenter.postImage(getRandomBitmap());
    }

    private Bitmap getRandomBitmap() {
        Bitmap randomBitmap = null;
        AssetManager assetManager = presenter.getContext().getAssets();
        try {
            InputStream inputStream = assetManager.open(images.get(random.nextInt(5)));
            randomBitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomBitmap;
    }
}
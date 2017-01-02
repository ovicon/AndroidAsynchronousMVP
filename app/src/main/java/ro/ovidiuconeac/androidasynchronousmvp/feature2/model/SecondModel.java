package ro.ovidiuconeac.androidasynchronousmvp.feature2.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import ro.ovidiuconeac.androidasynchronousmvp.common.Util;

/**
 * Created by ovidiu on 12/29/16.
 */

public class SecondModel {

    private final Random random = new Random();

    private SparseArray<String> names;
    private SparseArray<String> images;

    public SecondModel() {
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

    public String requestName() {
        Util.simulateNetworkLatency(2000);
        return names.get(random.nextInt(11));
    }

    public int requestAge() {
        Util.simulateNetworkLatency(3000);
        return random.nextInt(101);
    }

    public Bitmap requestImage(Context context) {
        Util.simulateNetworkLatency(1000);
        return getRandomBitmap(context.getAssets());
    }

    private Bitmap getRandomBitmap(AssetManager assetManager) {
        Bitmap randomBitmap = null;
        try {
            InputStream inputStream = assetManager.open(images.get(random.nextInt(5)));
            randomBitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomBitmap;
    }
}
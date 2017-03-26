package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by ovidiu on 12/29/16.
 *
 */

public class SecondModel {

    private final Random random = new Random();

    private HashMap<Integer, String> names;
    private HashMap<Integer, String> images;

    @SuppressLint("UseSparseArrays")
    public SecondModel() {
        this.names = new HashMap<>();
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
        this.images = new HashMap<>();
        images.put(0, "img1.jpg");
        images.put(1, "img2.jpg");
        images.put(2, "img3.png");
        images.put(3, "img4.jpg");
        images.put(4, "img5.png");
    }

    // Use case "request value"
    public Name requestName() {
        Name name = new Name();
        name.setValue(names.get(random.nextInt(11)));
        return name;
    }

    // Use case "request age"
    public Age requestAge() {
        Age age = new Age();
        age.setValue(random.nextInt(101));
        return age;
    }

    // Use case "request image"
    public Image requestImage(Context context) {
        Bitmap bitmap = getRandomBitmap(context.getAssets());
        Image image = new Image();
        image.setBitmap(bitmap);
        return image;
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
package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model;

import android.graphics.Bitmap;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public class Image {

    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return bitmap != null ? bitmap.equals(image.bitmap) : image.bitmap == null;

    }

    @Override
    public int hashCode() {
        return bitmap != null ? bitmap.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Image{" +
                "bitmap=" + bitmap +
                '}';
    }
}

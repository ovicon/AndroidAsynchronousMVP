package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor;

import android.graphics.Bitmap;

import ro.ovidiuconeac.androidasynchronousmvp.features.Presenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model.Age;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model.Image;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model.Name;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public interface SecondPresenter extends Presenter {
    void requestName();
    void postName(Name name);
    void requestAge();
    void postAge(Age age);
    void requestImage();
    void postImage(Image bitmap);
}

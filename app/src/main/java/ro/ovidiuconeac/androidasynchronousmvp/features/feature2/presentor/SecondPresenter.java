package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor;

import ro.ovidiuconeac.androidasynchronousmvp.features.Presenter;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public interface SecondPresenter extends Presenter {
    void requestName();
    void requestAge();
    void requestImage();
}

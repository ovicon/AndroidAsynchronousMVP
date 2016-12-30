package ro.ovidiuconeac.androidasynchronousmvp.feature2.presentor;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface SecondPresenter {
    void requestName();
    void requestAge();
    void requestImage();
    Context getContext();
}

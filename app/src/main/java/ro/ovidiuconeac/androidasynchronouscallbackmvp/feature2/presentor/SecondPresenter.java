package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.presentor;

import android.content.Context;
import android.graphics.Bitmap;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.view.SecondView;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface SecondPresenter {
    void requestName();
    void postName(String name);
    void requestAge();
    void postAge(int age);
    void requestImage();
    void postImage(Bitmap bitmap);
    Context getContext();
}

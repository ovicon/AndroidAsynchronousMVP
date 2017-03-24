package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view;

import android.content.Context;
import android.graphics.Bitmap;

import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface SecondView extends Screen {
    void requestName();
    void postName(String name);
    void requestAge();
    void postAge(int age);
    void requestImage();
    void postImage(Bitmap bitmap);
    Context getContext();
}

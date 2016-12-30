package ro.ovidiuconeac.androidasynchronousmvp.feature2.view;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface SecondView {
    void requestName();
    void postName(String name);
    void requestAge();
    void postAge(int age);
    void requestImage();
    void postImage(Bitmap bitmap);
    Context getContext();
}

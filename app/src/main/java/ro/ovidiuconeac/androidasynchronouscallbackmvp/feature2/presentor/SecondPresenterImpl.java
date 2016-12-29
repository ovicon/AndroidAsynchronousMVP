package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.presentor;

import android.content.Context;
import android.graphics.Bitmap;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.model.SecondModel;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.view.SecondActivity;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.view.SecondView;

/**
 * Created by ovidiu on 12/29/16.
 */

public class SecondPresenterImpl implements SecondPresenter {

    private SecondView view;
    private SecondModel model;

    public SecondPresenterImpl(SecondView view) {
        this.view = view;
        this.model = new SecondModel(this);
    }

    @Override
    public void requestName() {
        model.requestName();
    }

    @Override
    public void postName(String name) {
        view.postName(name);
    }

    @Override
    public void requestAge() {
        model.requestAge();
    }

    @Override
    public void postAge(int age) {
        view.postAge(age);
    }

    @Override
    public void requestImage() {
        model.requestImage();
    }

    @Override
    public void postImage(Bitmap bitmap) {
        view.postImage(bitmap);
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }
}

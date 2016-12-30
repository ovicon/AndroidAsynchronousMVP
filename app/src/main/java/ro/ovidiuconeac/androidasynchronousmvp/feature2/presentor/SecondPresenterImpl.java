package ro.ovidiuconeac.androidasynchronousmvp.feature2.presentor;

import android.content.Context;

import ro.ovidiuconeac.androidasynchronousmvp.feature2.model.SecondModel;
import ro.ovidiuconeac.androidasynchronousmvp.feature2.view.SecondView;

/**
 * Created by ovidiu on 12/29/16.
 */

public class SecondPresenterImpl implements SecondPresenter {

    private SecondView view;
    private SecondModel model;

    public SecondPresenterImpl(SecondView view) {
        this.view = view;
        this.model = new SecondModel(view.getContext());
    }

    @Override
    public void requestName() {
        view.postName(model.requestName());
    }

    @Override
    public void requestAge() {
        view.postAge(model.requestAge());
    }

    @Override
    public void requestImage() {
        view.postImage(model.requestImage());
        model.requestImage();
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }
}

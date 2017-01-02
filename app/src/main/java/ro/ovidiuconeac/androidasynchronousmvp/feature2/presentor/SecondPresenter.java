package ro.ovidiuconeac.androidasynchronousmvp.feature2.presentor;

import ro.ovidiuconeac.androidasynchronousmvp.feature2.model.SecondModel;
import ro.ovidiuconeac.androidasynchronousmvp.feature2.view.SecondScreen;

/**
 * Created by ovidiu on 12/29/16.
 */

public class SecondPresenter {

    private SecondModel model = new SecondModel();

    public void requestName(SecondScreen screen) {
        screen.postName(model.requestName());
    }

    public void requestAge(SecondScreen screen) {
        screen.postAge(model.requestAge());
    }

    public void requestImage(SecondScreen screen) {
        screen.postImage(model.requestImage(screen.getContext()));
    }
}

package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter;

import ro.ovidiuconeac.androidasynchronousmvp.features.Presenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view.FirstView;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public interface FirstPresenter extends Presenter {
    void requestLogin(final User user);
    void requestMessage(final FirstView screen);
}

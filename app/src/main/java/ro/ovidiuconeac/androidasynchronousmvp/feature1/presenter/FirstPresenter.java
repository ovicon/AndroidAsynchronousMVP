package ro.ovidiuconeac.androidasynchronousmvp.feature1.presenter;

import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.User;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface FirstPresenter {
    void requestLogin(User user);
    void requestMessage();
}

package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter;

import ro.ovidiuconeac.androidasynchronousmvp.features.Presenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.Message;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.User;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public interface FirstPresenter extends Presenter {
    void requestLogin(final User user);
    void doLogin();
    void showLoginError();
    void requestMessage();
    void postMessage(Message message);
}

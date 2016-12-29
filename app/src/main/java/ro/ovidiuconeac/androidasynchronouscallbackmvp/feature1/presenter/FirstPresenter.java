package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.presenter;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.model.User;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface FirstPresenter {
    void requestLogin(User user);
    void doLogin();
    void showLoginError();
    void requestMessage();
    void postMessage(String message);
}

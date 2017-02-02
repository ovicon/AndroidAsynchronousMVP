package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view;

import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface FirstScreen extends Screen {
    void requestLogin();
    void doLogin();
    void showLoginError();
    void requestMessage();
    void postMessage(String message);
}
